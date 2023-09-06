	function test(){
		alert("test click")
	}
	window.onload=()=>{
		const btn = document.getElementById("btn")
		btn.addEventListener("click", test); 
	}