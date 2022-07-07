/**
 * 
 */
 window.onload = function(){
	let num1 = document.getElementById("num1");
	let num2 = document.getElementById("num2");
	let keke = document.getElementById("keke");
	let submit = document.getElementById("submit");
	let se1 = document.getElementById("se1");
	let name = document.getElementById("name");
	let juju = document.getElementById("juju");
	
	
//	submit.onclick = function(){
//	if(keke.velue == "+"){
//		sel.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value + num2.value}`;
//	}else if(keke.velue == "-"){
//		sel.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value - num2.value}`;
//	}else if(keke.velue == "*"){
//		sel.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value * num2.value}`;
//	}else if(keke.velue == "/"){
//		sel.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value / num2.value}`;
//	}
//	}

	
}

function check(){
	let num1 = document.getElementById("num1");
	let num2 = document.getElementById("num2");
	let keke = document.getElementById("keke");
	let se1 = document.getElementById("se1");

	if(num1.value == ''||isNaN(num1.value)){
		alert('정수를 입력하세요.');
		return false;
	}
	if(num2.value == ''||isNaN(num2.value)){
		alert('정수를 입력하세요.');
		return false;
	}
	

//	if(keke.value == "+"){
//		alert(keke.value)
//		se1.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value + num2.value}`;
//	}else if(keke.value == "-"){
//		alert(keke.value)
//		se1.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value - num2.value}`;
//	}else if(keke.value == "*"){
//		alert(keke.value)
//		se1.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value * num2.value}`;
//	}else if(keke.value == "/"){
//		alert(keke.value)
//		se1.innerHTML = `${num1.value} + ${keke.value} + ${num2.value} = ${num1.value / num2.value}`;
//	}
	return true;
}