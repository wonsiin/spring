window.onload = function(){
	let text = document.getElementById("text");
	let br = document.getElementById("br");
	let h3 = document.getElementById("h3");
	let mun = document.getElementById("mun");
	let br1 = document.getElementById("br1");
	let count = document.getElementById("he");
	let sekai = document.getElementById("sekai");
	

	
br.onclick = function(){
	text.value = text.value + "<br>"
}
br1.onclick = function(){
	text1.value = text1.value + "<br>"
}
mun.onclick = function(){
	//값받아서 카운터 할 값
	let cou = 0;
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
	text1.value = text1.value + `<input id= "${count.value}" type= "button" value= "${count.value}" ><br>`;
}

}

