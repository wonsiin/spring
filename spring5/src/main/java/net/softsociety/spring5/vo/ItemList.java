package net.softsociety.spring5.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemList {
	int p_num;			//제품 번호
	String p_name;		//제품 명
	int amount;			//제품 수량
	int price;			//제품 가격
}
