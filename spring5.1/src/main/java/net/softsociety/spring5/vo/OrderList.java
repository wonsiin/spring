package net.softsociety.spring5.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
	int order_num;			//상품번호
	String id;			//유저id
	String name;		//유저 이름
	String address;		//주소
	String p_name;		//제품 명 F
	int p_amount;		//제품 수량 F
	int p_price;		//제품 가격 F
	int num;			//제품 번호 P
	
}
