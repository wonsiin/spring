package net.softsociety.spring2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@ToString
//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String id;
	String password;
	String name;
	String address;
	
	public void test() {
		System.out.println("이잉");
	}

	
}
