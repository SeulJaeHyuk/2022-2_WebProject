package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BinsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");

		//p_name, quantity, price를 받아와서 알맞는 변수에 입력한다.
		
		String p_name = request.getParameter("p_name");
		int quantity  = Integer.parseInt(request.getParameter("quantity"));
		int price  = Integer.parseInt(request.getParameter("price"));
		
		BoardDto dto = new BoardDto(0, p_name, quantity, price); 
		BoardDao dao = new BoardDao();
		dao.insert(dto);
	}

}
