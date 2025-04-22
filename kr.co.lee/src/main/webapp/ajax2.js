//A개발자의 입력값을 받아서 , B개발자가 Ajax 통신을 적용후 결과값을 Return 형태 
function apink_love(cid,cname){
	var result;
	if(cid=="" || cname==""){ //A개발자가 데이터를 비정상적으로 보낼 경우 
		result = "no";
	}
	else{ //정상적으로 데이터를 받을 경우 
	  fetch("http://172.30.1.54:8080/ajax2.do",{//상대방 경로로 적어야 전송이 된다 		
		method :"POST",
		body : new URLSearchParams("CID="+cid+"&CNAME="+cname)
	  }).then(function(aa){
		return aa.text();
	  }).then(function(bb){
	  		if(bb=="ok"){  //B개발 Controller에서 SQL 결과값을 받음			
			result ="ok"; //A개발자에게 결과값을 전달하기 위한 변수 값				
			}
			else{
				result ="error";	
			}
			
	  }).catch(function(error){
		console.log("통신오류 발생 !!");
	  });
			
		result = "ok";
	}

	return result; //A개발자에게 다시 회신함
}