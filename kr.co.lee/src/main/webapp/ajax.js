document.querySelector("#all").addEventListener("click", function () {
    var ea = document.querySelectorAll(".pd");
    for (let a = 0; a < ea.length; a++) {
        ea[a].checked = this.checked;
    }
});

function ajax() {
    let ea = document.querySelectorAll(".pd");
    var formdata = new FormData();
    let count = 0;

    for (let a = 0; a < ea.length; a++) {
        if (ea[a].checked === true) {
            formdata.append("product", ea[a].value);
            count++;
        }
    }

    if (count === 0) {
        alert("최소 한 개 이상 체크를 하셔야만 데이터가 전송 됩니다.");
        return;
    }

    // XMLHttpRequest 사용
   var http = new XMLHttpRequest();
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            //console.log(http.responseText);
			result = this.response;
			if(result=="ok"){
				alert("정상적으로 데이터 처리");
			}
			else{
				
				alert("데이터 천송 문제 발생으로 처리 오류 !!");
			}
        }
    };
    http.open("POST", "./ajax.do", true);
    http.setRequestHeader("mkey", "a123456");
	http.send(formdata);
	//http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	//http.setRequestHeader("content-type","application/json");
    //http.send("product="+JSON.stringify(data1));
}