package net.softsociety.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

	int replynum;		//리플 일련번호
	int boardnum;		//본문 글번호
	String memberid;	//작성자
	String replytext;	//글내용
	String inputdate;	//작성시간
	
}
