package net.softsociety.spring5.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.service.BoardService;
import net.softsociety.spring5.util.FileService;
import net.softsociety.spring5.util.PageNavigator;

@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {

	//게시판 페이지 당 출력할 글수
	@Value("${user.board.page}") // 바뀔 수도 있는 값들 한 곳에 몰아서 정의
	int countPerPage; // 변수 준비하고 변수 위에 어노테이션
	
	//게시판 목록의 페이지 이동 링크 수
	@Value("${user.board.group}")
	int pagePerGroup;
	
	//첨부파일이 저장된 경로
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	@Autowired
	BoardService service;
	
	//글 목록으로 이동
	@GetMapping("list")
	public String list(
			Model model
			, @RequestParam(name="page", defaultValue="1") int page // 안넘어오면 무조건 1페이지 -> requestParam
			, String type
			, String searchWord) {
		log.debug("페이지당 글수:{}, 페이지이동 링크수:{}, 페이지:{}, 검색대상:{}, 검색어:{}"
				, countPerPage, pagePerGroup, page, type, searchWord);
		
		PageNavigator navi = service.getPageNavigator(
				pagePerGroup, countPerPage, page, type, searchWord);
		
		//DB의 게시판 테이블의 모든 글을 읽어서
		ArrayList<Board> boardlist = service.selectAll(navi, type, searchWord);
		
		//ArrayList<Board> 타입으로 모델에 저장
		model.addAttribute("navi", navi);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("type", type); // 저장해서 html 페이지에서 사용
		model.addAttribute("searchWord", searchWord);
		
		int total = service.selectTotal();
		log.debug("전체 글 : {}", total);
		model.addAttribute("total", total);
		
		return "/boardView/list";
	}
	
	//글쓰기 폼으로 이동
	@GetMapping("write")
	public String write() {
		return "/boardView/write";
	}
	
	//글저장
	@PostMapping("write")
	public String write(
			Board board
			, @AuthenticationPrincipal UserDetails user // 로그인한 사용자 정보 전달
			, MultipartFile upload) {
		
		String id = user.getUsername(); // id 읽어서
		board.setMemberid(id); // board에 추가
		
		if(upload != null && !upload.isEmpty()) {
//			log.debug("name: {}", upload.getName());
//			log.debug("originalFilename: {}", upload.getOriginalFilename());
//			log.debug("contentType: {}", upload.getContentType()); // 어떤 종류의 파일인지
//			log.debug("size: {}", upload.getSize()); // 바이트 단위 용량 // 엄청 큰 파일이라면 여기 오기 전 에러
//			log.debug("isEmpty: {}", upload.isEmpty()); // 제대로 올라왔으면 false
			String savedfile = FileService.saveFile(upload, uploadPath); // 변경할 수 있는 값 xx. "c:/upload". 수정하더라도 application.properties만 수정 o
			board.setOriginalfile(upload.getOriginalFilename()); // 파일 원래 이름
			board.setSavedfile(savedfile); // 파일 저장된 이름
		}
		
		log.debug("저장할 글정보 : {}", board);
		
		service.writeBoard(board);
		
		return "redirect:list";
	}
	
	//글읽기
	@GetMapping("/read")
	public String read(Model model
			, @RequestParam(name="boardnum", defaultValue="0") int boardnum) { // 안들어오면 기본값 0으로 처리하겠다는 @getParameter
		log.debug("전달된 번호 : {}", boardnum);
		
		service.updateHits(boardnum); // 조회수 1
		
		//전달된 번호로 글을 읽어서 Board객체를 리턴받음
		Board board = service.selectOne(boardnum); //DB에서 글을 읽어서
		log.debug("전달된 값 : {}", board);
		
//		service.updateHits(boardnum); // 조회수 0
		
		//결과가 없으면 글목록으로 리다이렉트
		if(boardnum == 0) {
			return "redirect:/";
		}
		
		//현재 글의 리플 목록 읽기
		ArrayList<Reply> replylist = service.selectReply(boardnum);
		
		//결과가 있으면 모델에 저장하고 html에서 출력
		model.addAttribute("board", board);
		model.addAttribute("replylist", replylist);
		
		return "/boardView/read";
	}
	
	//첨부파일 다운로드
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public String fileDownload(int boardnum, Model model, HttpServletResponse response) {
		Board board = service.selectOne(boardnum);
		
		//원래의 파일명
		String originalfile = new String(board.getOriginalfile());
		try {
			response.setHeader("Content-Disposition", " attachment;filename="+ URLEncoder.encode(originalfile, "UTF-8")); // 이름을 알려줌. 저장
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//저장된 파일 경로
		String fullPath = uploadPath + "/" + board.getSavedfile();
		
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		FileInputStream filein = null;
		ServletOutputStream fileout = null;
		
		try {
			filein = new FileInputStream(fullPath); // fullPath : c:/upload/20220802.png
			fileout = response.getOutputStream();
			
			//Spring의 파일 관련 유틸 이용하여 출력
			FileCopyUtils.copy(filein, fileout); // 저장된 파일의 내용 보냄. 클라이언트에게도 똑같이 복사가 되어 저장
			
			filein.close();
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}	
	
	@GetMapping("delete")
	public String delete(
			int boardnum
			, @AuthenticationPrincipal UserDetails user) {
		
		//해당번호의 글 조회
		Board board = service.selectOne(boardnum);
		log.debug("board : {}", board);
		//결과가 없으면 글목록으로 리다이렉트
		if (board == null) {
			return "redirect:/";
		}
		
		//첨부된 파일명 확인
		String savedfile = board.getSavedfile();
		//로그인한 아이디 확인
		String id = user.getUsername();
		board.setMemberid(id); // ??
		// ~로그인한 아이디 다시 집어넣어서 글 작성자 아이디를 로그인한 아이디로 고침 / 혹시 다른 사람의 글로 접근했을 때
		
		//전달된 번호의 글 삭제 // 0 : 글 못지움 / 1 : 글 삭제함
		int result = service.delete(board);
		//글이 삭제되고 첨부파일도 있는 경우 파일삭제
		if(result == 1 && savedfile != null) { // 혹시 글 못지웠을 때 파일 삭제할 필요 없음
			FileService.deleteFile(uploadPath + "/" + savedfile); // 전체 경로 만들어서 fileService에 파일 삭제하는 코드 들어있음
		}
		
		//글목록으로 이동
		return "redirect:/board/list"; // 글 목록으로 리다이렉트
	}
	
	@GetMapping("update")
	public String update(int boardnum, Model model) { // 제목, 내용 등을 보여주면서 수정하라고 해야 함 -> Model 필요
		//전달받은 번호의 글정보를 조회
		Board board = service.selectOne(boardnum);
		//모델에 저장하고 HTML로 이동
		model.addAttribute("board", board);
		return "/boardView/update";
	}
	
	@PostMapping("update")
	public String update(
			Board board
			, MultipartFile upload // 그 폼의 파일 선택 요소와 같아야
			, @AuthenticationPrincipal UserDetails user) { // 자기글을 수정하려고 하는지
		
		//로그인한 아이디 확인 // 자기 글 수정하는지 알 수 있음
		log.debug("로그인한 아이디 : {}", user.getUsername());
		
		//첨부파일에 대한 처리. (기존 파일이 있고 새로 올리면 기존 파일 삭제 후 처리) // 기존에 첨부된 파일이 있으면 수정하면서 파일 올리지 않으면 원래 파일 남겨둠 // 새 파일이 없으면 기존 파일 그대로 두기
		if(upload != null && !upload.isEmpty()) {
			String savedfile = board.getSavedfile();
			FileService.deleteFile(uploadPath + "/" + savedfile);

			savedfile = FileService.saveFile(upload, uploadPath);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(savedfile);
		}
		
		log.debug("수정할 글정보 : {}", board);
		
		//수정한 제목과 본문, 파일명(있다면) DB에서 수정 // update 구문 xml 파일에서 if문으로
		service.update(board);
		
		//읽던 글로 돌아감
		return "redirect:/board/read?boardnum=" + board.getBoardnum(); // redirect:/board/read // 글읽기로 감. int형 boardnum 기다림 0 -> 글 없어서 목록으로 감 // 글 번호까지 줘야 갈 수 있음 // 읽기 화면으로 가되 아까 있던 페이지로 감
	}
	
	//리플 저장
	@PostMapping("replyWrite")
	public String replyWrite(
			Reply reply
			, @AuthenticationPrincipal UserDetails user) {
		//본문글번호, 리플내용 전달받아 로그인한 아이디 추가
		String id = user.getUsername();
		reply.setMemberid(id);
		//DB에 저장
		log.debug("reply : {}", reply);
		service.insertReply(reply);
		
		//아까 읽던 글로 돌아감
		return "redirect:/board/read?boardnum=" + reply.getBoardnum();
	}
	
	@PostMapping("deleteReply")
	public String deleteReply(
			int replynum
			, @AuthenticationPrincipal UserDetails user) {
		
		// 해당번호의 댓글 조회
		Reply reply = service.selectOneReply(replynum);
		log.debug("reply : {}", reply);
		
		//결과가 없으면 글목록으로 리다이렉트
		if (reply == null) {
			return "redirect:/";
		}
		
		//로그인한 아이디 확인
		String id = user.getUsername();
		reply.setMemberid(id);
		// ~로그인한 아이디 다시 집어넣어서 댓글 작성자 아이디를 로그인한 아이디로 고침 / 혹시 다른 사람의 글로 접근했을 때
		
		//전달된 번호의 글 삭제 // 0 : 글 못지움 / 1 : 글 삭제함
		service.deleteReply(reply);
			
		//글읽기로 이동
		return "redirect:/board/read?boardnum=" + reply.getBoardnum();
	}
//	
//	@GetMapping("updateReply")
//	public String updateReply(int boardnum, Model model) {
//		
//		return "/boardView/updateReply";
//	}
//	
//	@PostMapping("updateReply")
//	public String updateReply(
//			Board board
//			, MultipartFile upload // 그 폼의 파일 선택 요소와 같아야
//			, @AuthenticationPrincipal UserDetails user) {
//		
//		return "redirect:/board/read?boardnum=" + reply.getBoardnum();
//	}
}
