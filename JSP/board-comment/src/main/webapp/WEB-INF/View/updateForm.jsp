<%@page import="cs.dit.board.BoardDao"%>
<%@page import="cs.dit.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page import = "java.util.List, java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<title>게시판</title>
	<script type="text/javascript">
	var xhr1 = new XMLHttpRequest();  //rlist
	var xhr2 = new XMLHttpRequest();  // rinsert
	
	var bcode = encodeURIComponent(document.getElementById("bcode").value);
	
	function cList(){
		var commentsTable = document.getElementById("commentsTable");
		commentsTable.innerHTML = "";
		
		xhr1.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				console.log(this.responseText);
				
				var json = this. responseText;
				var list = JSON.parse(json); //JSON 형식의 문자열을 자바스크립트 객체로 변환함.
				
				for(var i in list){
					var row = commentsTable.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					cell1.innerHTML list[i].ccode;
					cell2.innerHTML list[i].content;
					cell3.innerHTML list[i].regdate;
				}
			}
		};
		xhr1.open('POST', '/board-mvc-comments/cList.ct', true);
		
		vat data='';
		data += 'bcode' + bcode;
		xhr1.send(data);
	}
	</script>
</head>
<body>  
<div class="container">
	<h2 class="text-center font-weight-bold">상세보기</h2>
	<br/>
	<form action="update.do" method="post">
		<input type="hidden" name="bcode" value="${dto.bcode}" id="bcode">
		<table class="table table-striped table-hover">
			<tr>
				<th>bcode</th><td>${dto.bcode}</td>
				<th>subject</th><td><input type="text" value="${dto.subject}" name="subject"></td>
			</tr>
			<tr>
				<th>content</th>
				<td colspan="3"><textarea rows="10" cols="80" name="content">${dto.content}</textarea></td>	
			</tr>
			<tr>
				<th>writer</th><td><input type="text" value="${dto.writer}" name="writer"></td>
				<th>regDate</th><td><input type="text" value="${dto.regDate}" name="regDate"></td>
			</tr>
			<tr>
				<th>filename</th><td><input type="file" value="${dto.filename}" name="filename"></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value ="게시글 수정" >
					<input type="button" value ="게시글 삭제" onclick ="location.href='delete.do?bcode=${dto.bcode}'">
					<input type="button" value ="게시글 목록" onclick ="location.href='list.do'">
					<input type="button" value ="게시글 등록" onclick ="location.href='insertForm.do'">
				</td>
			</tr>
		</table><br><br>
	</form>
	<!--  한줄 댓글 -->
	<table class="table">
	<tr>
	<td>한줄 댓글 : </td>
	<td><input type="text" name="comments" id="comments"></td>
	<td><input type="button" value="한줄댓글작성" onclick=""></td>
	</tr>
	</table>
	<table class="table">
		<tbody id="commentsTable">
	
		</tbody>
	</table>
</div>
</body>
</html>