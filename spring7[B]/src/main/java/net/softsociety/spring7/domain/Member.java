package net.softsociety.spring7.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails{
	String memberid;		//사용자 식별ID
	String memberpw;		//비밀번호
	String membername;		//사용자 이름
	String email;			//이메일 주소
	String phone;			//전화번호
	String address;			//집주소
	boolean enabled;			//계정상태. 1.사용가능 0.사용불가 		boolean 이라도 0과 1은 참 거짓으로 인식한다.
	String rolename;		//사용자 구분. 'ROLE_USER', 'ROLE_ADMIN'중 하나
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.memberpw;
	}
	@Override
	public String getUsername() {
		return this.memberid;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}


	
	
}
