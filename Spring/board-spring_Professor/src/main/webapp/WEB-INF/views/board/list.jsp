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
                                        <td><a href="<c:out value='/board/get?bno=${board.bno}'/>"><c:out value='${board.title}'/></a></td>
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
<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	var result = "${result}";

	checkModal(result);
	
	history.replaceState({}, null, null);
	
	function checkModal(result){
		if(result===''||history.state){
			return;
		}else if(result==='registered'){
			$(".modal-title").html("게시글 등록");
			$(".modal-body").html("새 게시글이 등록되었습니다!");

		}else if(result==='modified'){
			$(".modal-title").html("게시글 수정");
			$(".modal-body").html("새 게시글이 수정되었습니다!");			
		}else if(result==='removed'){
			$(".modal-title").html("게시글 삭제");
			$(".modal-body").html("새 게시글이 삭제되었습니다!");			
		}
		$("#myModal").modal("show");
	}
	
	$("#regBtn").on("click", function(){
		self.location="/board/register";
	});

});
</script>

<%@include file="../includes/footer.jsp"%>