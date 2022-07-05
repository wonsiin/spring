package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.softsociety.spring2.vo.Param;
/* Model 사용 테스트를 위한 콘트롤러 클래스
 * [ /** + enter ]
 * 
 * @author 22.07.05 문주현
 *
 */
@Controller
public class model {
	/**
	 * Medel을 사용하기 위한 테스트 기능
	 * @param model 메소드를 전달받는 파라미터의 의미를 적는칸 [model Model 객체]
	 * @return 그 메소드가 리턴하는 값이 어떤의미인지 적는칸 [ 포워딩할 HTML 파일명]
	 */
	@GetMapping({"/model/model1"})
	public String model1(Model  model) {
		String str = "서버의 문자열";
		int num = 100;
		Param p = new Param("김","KT","1111");
		
		model.addAttribute("string", str);
		model.addAttribute("numb", num);
		model.addAttribute("p", p);
		return "model1";
	}
}
