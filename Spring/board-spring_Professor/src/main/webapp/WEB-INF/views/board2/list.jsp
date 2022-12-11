<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="board" items="${list}">
                                    <tr class="odd gradeX">
                                        <td><c:out value='${board.bno}'/></td>
                                        <td><a href="/board/getOne?bno=<c:out value='${board.bno}'/>"><c:out value='${board.title}'/></a></td>
                                        <td><c:out value='${board.writer}'/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<div id="mymodal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null); //브라우저 주소창에 보관하고 있는 정보 지우기
		
		function checkModal(result){
			
			if(result ===''|| history.state){ //브라우저 기록 스택의 맨위에 있는 상태값 가져오기. 상태값이 있으면 return
				return;
				
			}else if(result ==='registered'){
				$(".modal-title").html("게시글 등록");
				$(".modal-body").html("새 게시글이 등록되었습니다.");
				
			}else if(result ==='modified'){
				$(".modal-title").html("게시글 수정");
				$(".modal-body").html("게시글이 수정되었습니다.");
				
			}else if(result ==='removed'){
				$(".modal-title").html("게시글 삭제");
				$(".modal-body").html("게시글이 삭제되었습니다.");
				
			}
			$("#mymodal").modal("show");
		}
		
		$("#regBtn").click(function(){
			self.location = "/board/register";
			//window.location = "/board/register";
		});
	});
</script>

<%@include file="../includes/footer.jsp"%>