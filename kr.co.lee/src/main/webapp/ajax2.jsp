<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부 js를 이용하여 DB에 저장 및 회신결과 받기</title>
</head>
<body>
상담자 아아디 : <input type="text" id="CID"><br>
상담자 명  : <input type="text" id="CNAME"><br>
<input type="button" value="상담신청" onclick="ajax_test()">

</body>
<!-- crossorigin="anonymous" : 익명 웹 서비스를 이용하는 상황(인증서 없이) -->
<script src="http://172.30.1.54:8080/ajax2.js"></script>
<script>
function ajax_test(){
	var cid = document.getElementById("CID");
	var cname = document.getElementById("CNAME");
	if(cid.value=="" || cname.value=="" ){
		alert("모든 입력값에 필수로 데이터를 입력하세요");
	}
	else{
		//상대방 서버에 있는 함수를 로드하여 호출 및 결과값을 리턴 받음 
	var result = apink_love(cid.value,cname.value);
		if(result=="ok"){
			alert("해당 상담신청이 올바르게 등록되었습니다.");
		}
		else{
			alert("현재 서비스가 불안정한 상황으로 잠시 후 다시 신청하세요.");	
		}
	}
}
</script>

</html>