function daumPost(){
    new daum.Postcode({
        oncomplete: function(data) {
        	console.log(data);
        	const addr1 = document.getElementById("addr1"); //우편번호
        	const addr2 = document.getElementById("addr2"); //주소
        	const addr3 = document.getElementById("addr3"); //상세주소
        	let addr="";
        	if(data.userSelectedType === "R"){//도로명 선택
        		addr = data.roadAddress
        	}else{//지번 선택
        		addr = data.jibunAddress;
        	}
        	addr1.value = data.zonecode;
        	addr2.value = addr;
        	addr3.focus();

        }
    }).open();
}

function idCh(){
	
}