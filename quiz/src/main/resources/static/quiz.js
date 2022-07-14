window.onload = function(){
	let naio1 = document.getElementById("naio1");
	let br = document.getElementById("br");
	let h3 = document.getElementById("h3");
	let mun = document.getElementById("mun");
	let br1 = document.getElementById("br1");
	let count = document.getElementById("he");
	let sekai = document.getElementById("sekai");
	let naio2 = document.getElementById("naio2");
	let tala2 = document.getElementById("tala2");
	let mon = document.getElementById("mon");
	let totod = document.getElementById("totod");
	
//	naio1.addEventListener("keyup", function(event){
//		if(event.keyCode === 13){
//			document.getElementById("naio1").innerHTML += "<br>"+"\n";
//			event.preventDefault();
//		}
//	})
//	naio2.addEventListener("keyup", function(event){
//		if(event.keyCode === 13){
//			document.getElementById("naio2").innerHTML += "<br>"+"\n";
//			event.preventDefault();
//		}
//	})

	naio1.onkeyup = function(){
	if(event.keyCode == 13){
		totodd();
	}

	
	
}
	function totodd(){
		naio1.value = naio1.value + "<br>"
	}
	
	
//	br.onclick = function br11(){
//		naio1.value = naio1.value + "<br>"
//		naio1.focus();
//	}
//	br1.onclick = function br22(){
//		naio2.value = naio2.value + "<br>"
//		naio2.focus();
//	}
	naio2.onclick = function(){
		
		if(naio2.onclick){
			if(naio2.value == null){
			naio2.value = `${cou}. ${naio2.value} <input id= "${count.value}" type= "button" value= "${count.value}" ><br>\n${cou}`;
			naio2.focus();
		}
		}
	}
	
	mun.onclick = function(){
	//값받아서 카운터 할 값
	let cou = 0;
	let oo;
	cou = document.getElementById("he").value;
	//최대 문제수 제한값
		if (cou == 4){
			alert("더이상 늘릴수 없습니다.")
			return "session1";
		}
	//1씩 증가시킬 카운터값
	cou = parseInt(cou) + 1;
	//다시 히든값에 넣어줄 값
	document.getElementById("he").value = cou;
	//input 버튼을 만들어줄 함수
	
	if(cou == 4){
		let ii = "정답은 무엇을까요?"
		cou = ii;
	}
	if(cou != "정답은 무엇을까요?"){
		cou = (cou + 1) + ".";
	}else {
		cou;
	}

	if(naio2.value != null){
		naio2.value = naio2.value + `<input id= "${count.value}" type= "button" value= "${count.value}" ><br>\n${cou}`;
		naio2.focus();
	}
		
}
}


