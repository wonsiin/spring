package net.softsociety.home.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class home {
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	@GetMapping({"/kee"})
	public String kee() {
		return "kee";
	}
	@GetMapping({"/sibun"})
	public String sibun() {
		return "sibun";
	}

	@PostMapping({"/input1"})
	public String input1(int num1, int num2, String keke, Model  model) {
		int result=0;
		
		switch(keke){
        case "+" :
        	result = num1 + num2;
        break;
        case "-" :
        	result = num1 - num2;
        break;
        case "*" :
        	result = num1 * num2;
        break;
        case "/" :
        	result = num1 / num2;
        break;
		}
        model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("kaka", keke);
		model.addAttribute("result", result);

		
		return "seiko";
	}
	
	@PostMapping({"/input2"})
	public String input2(String name,String juju, Model  model) {
		int age =0;
		String namyu=null,juju1,il=null,nal=null,oll=null;
		
		
		juju1 = juju.substring(0,6);
		nal = juju.substring(0,2);
		int toto = LocalDate.now().getYear();
		
		String tot = String.valueOf(toto);
		String totot = tot;
		tot = tot.substring(2,4);
		
//		if(Integer.parseInt(aa) > Integer.parseInt(tot)) {
//			age = Integer.parseInt(aa) - Integer.parseInt(tot)+1;
//		}else if(Integer.parseInt(aa) == Integer.parseInt(tot)) {
//			age = Integer.parseInt(tot) - Integer.parseInt(aa)+1;
//		}else if(Integer.parseInt(aa) < Integer.parseInt(tot)) {
//			age = Integer.parseInt(tot) - Integer.parseInt(aa)+1;
//		}
		
		if(juju1.length() == 6) {
			il = juju.substring(0,2);
			String aa = juju.substring(0,2);
			String ill;
			if(Integer.parseInt(aa) >=Integer.parseInt(tot)) {
				ill = "19" + il;
				age = Integer.parseInt(totot) - Integer.parseInt(ill)+1;
				il = ill.substring(2,4) + "년";
			}else if(Integer.parseInt(aa) <= Integer.parseInt(tot)) {
				ill = "20" + il;
				age = Integer.parseInt(totot) - Integer.parseInt(ill)+1;
				il = ill.substring(2,4) + "년";
			}
			il += juju.substring(2,4) + "월";
			String bb = juju.substring(2,4);
			if(Integer.parseInt(bb) > 13) {
				System.out.println("13달이상은 존재하지 않습니다.");
			}
			il += juju.substring(4,6) + "일";
		}
		
		namyu = juju.substring(7,8);
		if(Integer.parseInt(namyu) == 1 || Integer.parseInt(namyu) == 3) {
			oll = "남자";
		}else if(Integer.parseInt(namyu) == 2 || Integer.parseInt(namyu) == 4) {
			oll = "여자";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("il", il);
		model.addAttribute("age", age);
		model.addAttribute("oll", oll);
		
		return "get";
	}

}
