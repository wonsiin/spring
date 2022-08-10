package net.softsociety.spring5.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 정보
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3222388532456457383L; // 접근불가 __ 한번대입한 값 붙일 수 없음 자료형x // 값 저장하고 읽기만 하려고 static final
	String memberid;		// 사용자 식별ID
	String memberpw;		// 비밀번호
	String membername;		// 사용자 이름
	String email;			// 이메일주소
	String phone;			// 전화번호
	String address;			// 집주소
	boolean enabled;			// 계정상태. 1:사용가능, 0:사용불가능
	String rolename;		// 사용자 구분. 'ROLE_USER', 'ROLE_ADMIN'중 하나
	
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
		return true; // false 리턴은 어떤 상황일 때 리턴할건지 추가
	}
	@Override
	public boolean isEnabled() {
		return this.enabled; // 1이면 true 리턴, 0이면 false 리턴
	} // getter setter와 상관없이 security에서는 얘네로 정보를 읽어감
	
	
}
// security에서도 쓰려면 인터페이스. 추상메소드 상속받아서 구현
