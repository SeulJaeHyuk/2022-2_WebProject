<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<script>
	function senData(){
	var xhttp = new XMLHttpRequest(); //XMLHttpRequest ��ü ����
	
	//onreadystatechange �Ӽ��� readyState �Ӽ��� ���� ���¸� �����Ͽ� ȣ��� �Լ��� ����
	//reayState ���°���
	//0 : ��û�� �ʱ�ȭ���� ����
	//1 : ���� ���� (loading)
	//2 : ��û ���� (loaded)
	//3: ��û ó�� (interactive)
	//4 : ��û �Ϸ� (complete)
	 xhr.onreadystatechange = function(){
		
		if(this.readyState == 4){ //4���� ������ �� ó���ϴ� ���
			//���䵥���� responseText�� HTML ���� �� myDiv�� ǥ��
			document.getElementByID('myDiv').innerHTML = this.responseText;
		}
	};
	//��û���� ���� open(method, url, sync, [user, pwd])
	xhr.open("POST", "myText.txt", true);
	xhr.send(); //��û�� ������ ����
	}
	</script>
</head>
<body>
	<input type='button' onclick='sendData();', value='test'>�׽�Ʈ�Դϴ�.
	<div id="myDiv">
	</div>
</body>
</html>