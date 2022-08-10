package net.softsociety.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	int boardnum;     //글번호
	String memberid;    //작성자
	String title;		//제목
	String contents;			//내용
	String intputdate; 			//작성시간
	int hits;					//조회수
	String originalfile;		//첨부파일의 월래 이름
	String savedfile;			//서버에 저장된 이름
}
