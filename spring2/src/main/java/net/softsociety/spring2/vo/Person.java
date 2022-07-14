package net.softsociety.spring2.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
	String name;
	String phone;
	String phonenum;

	public Person(String name, String phone, String phonenum) {
		this.name = name;
		this.phone = phone;
		this.phonenum = phonenum;
	}

}
