<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<script>
	function senData(){
	var xhttp = new XMLHttpRequest(); //XMLHttpRequest 객체 생성
	
	//onreadystatechange 속성은 readyState 속성이 변경 상태를 감지하여 호출된 함수를 정의
	//reayState 상태값은
	//0 : 요청이 초기화되지 않음
	//1 : 서버 연결 (loading)
	//2 : 요청 받음 (loaded)
	//3: 요청 처리 (interactive)
	//4 : 요청 완료 (complete)
	 xhr.onreadystatechange = function(){
		
		if(this.readyState == 4){ //4번의 상태일 때 처리하는 경우
			//응답데이터 responseText를 HTML 문서 내 myDiv에 표시
			document.getElementByID('myDiv').innerHTML = this.responseText;
		}
	};
	//요청정보 설정 open(method, url, sync, [user, pwd])
	xhr.open("POST", "myText.txt", true);
	xhr.send(); //요청을 서버에 전송
	}
	</script>
</head>
<body>
	<input type='button' onclick='sendData();', value='test'>테스트입니다.
	<div id="myDiv">
	</div>
</body>
</html>