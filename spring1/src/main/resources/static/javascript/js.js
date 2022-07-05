/**
 * 
 */
	function func(){
		let te = document.getElementById("te");
		let cou=0;
		cou = te.value;
		let add = document.getElementById("old");
		document.getElementById("te").innerHTML = cou * 2;
		document.getElementById("old").innerHTML += cou * 2;
	}
	