package cs.dit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 클라이언트 요청 분석
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		String viewPage = null;
		
		if(com != null && com.trim().equals("list")) {
			BoardService service = new BListService();
			service.execute(request,response);
			viewPage = "/WEB-INF/View/list.jsp";

		}else if(com != null && com.trim().equals("list")){
			viewPage = "/WEB-INF/View/insertForm.jsp";

		}else if(com != null && com.trim().equals("updateForm")){
			BoardService service = new BViewService();
			service.execute(request,response);
			viewPage = "/WEB-INF/View/updateForm.jsp";
			
		}  else if(com != null && com.trim().equals("update")){
			BoardService service = new BinsertService();
			service.execute(request,response);
			viewPage = "list.do";
			
		} else if(com != null && com.trim().equals("insert")){
			BoardService service = new BinsertService();
			service.execute(request,response);
			viewPage = "list.do";
			
		} else if(com != null && com.trim().equals("delete")){
			BoardService service = new BDeleteService();
			service.execute(request,response);
			viewPage = "list.do";
			
		} else if(com != null && com.trim().equals("index")){
			viewPage = "/WEB-INF/View/index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TOO Auto-generated method stub
		doGet(request, response);
	}

}
