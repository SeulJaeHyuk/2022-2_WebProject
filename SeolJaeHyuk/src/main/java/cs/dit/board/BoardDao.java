package cs.dit.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {

	/**======================================================================
	 * 패키지명 : cs.dit.board
	 * 파일명   : BoardDao.java
	 * 작성자  : 김진숙
	 * 변경이력 : 
	 *   2022-9-11/ 최초작성/ 김진숙
	 * 프로그램 설명 : board 테이블의 내용과 연동하여 회원관리
	 *  	- getConnection() : 커넥션풀에서 연결객체 얻기
	 * 		- insert(BoardDto dto) : 사용자가 입력한 게시글 정보 DB 입력
	 * 		- list() : DB에서 게시글 정보 조회
	 * 		- update(BoardDto dto) : 변경된 게시글 정보 DB 변경
	 * 		- delete(int bcode) : 해당 bcode 게시글 DB 삭제
	*======================================================================*/

	private Connection getConnection() throws Exception{
		//1. JNDI를 이용하기 위한 객체 생성
		Context initCtx  = new InitialContext();
		
		//2. 등록된 네이밍 서비스로부터 등록된 자원을 가져옴
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		
		//3. 자원들 중 원하는 jdbc/jskim 자원을 찾아내어 데이터소스를 가져옴
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jaehyuk");
		
		//4. 커넥션 얻어옴
		Connection con = ds.getConnection();
		
		return con;
	}
	
	public void insert(BoardDto dto) {
		String sql = "INSERT INTO tbl_order(p_name, quantity, price) VALUES(?, ?, ?);";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{
			
			pstmt.setString(1,  dto.getP_name());
			pstmt.setInt(2,  dto.getQuantity());
			pstmt.setInt(3,  dto.getPrice());

			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDto> list(){
		
		String sql = "SELECT num, p_name, quantity, price FROM tbl_order order by num desc;";
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		try (	Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			)
			{
				while(rs.next()) {
					BoardDto dto = new BoardDto();
					
					dto.setNum(rs.getInt("num"));
					dto.setP_name(rs.getString("p_name"));
					dto.setQuantity(rs.getInt("quantity"));
					dto.setPrice(rs.getInt("price"));
					dtos.add(dto);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		return dtos;
	}	
		
}