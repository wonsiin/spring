package net.softsociety.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String memberid;
	String memberpw;
	String membername;
	String email;
	String phone;
	String address;
	int enabled;
	String rolename;
}
