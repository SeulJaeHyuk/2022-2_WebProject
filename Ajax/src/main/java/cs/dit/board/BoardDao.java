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
	 * 작성자  : 
	 * 변경이력 : 
	 *   2022-9-11
	 * 프로그램 설명 : board 테이블의 내용과 연동하여 게시글 관리
	 * - getConnection() : 커넥션풀에서 연결객체 얻기
	 * - insert(BoardDto dto) : 사용자가 입력한 게시글 정보 DB 입력
	 * - list() : DB에서 게시글 정보 조회
	 * - update(BoardDto dto) : 변경된 게시글 정보 DB 변경
	 * - delete(int bcode) : 해당 bcode 게시글 DB 삭제
	 * - recordCount : 전체 테이블의 레코드 수 조회
	*======================================================================*/

	private Connection getConnection() throws Exception{
		
		Context initCtx  = new InitialContext();//1. JNDI를 이용하기 위한 객체 생성
		
		Context envCtx = (Context) initCtx.lookup("java:comp/env");//2. 등록된 네이밍 서비스로부터 등록된 자원을 가져옴
		
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jaehyuk");//3. 자원들 중 원하는 jdbc/jskim 자원을 찾아내어 데이터소스를 가져옴
		
		Connection con = ds.getConnection();//4. 커넥션 얻어옴
		
		return con;
	}
	
	public void insert(BoardDto dto) {
		String sql = "INSERT INTO board(SUBJECT, CONTENT, WRITER, REGDATE) VALUES(?, ?, ?, SYSDATE())";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{   
			pstmt.setString(1,  dto.getSubject());
			pstmt.setString(2,  dto.getContent());
			pstmt.setString(3,  dto.getWriter());
			
			//1. insert 문을 실행하는 코드를 작성하세요
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDto> list(int page, int numOfRecordes){
		String sql = "SELECT * FROM board order by bcode desc limit ?, ?";
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		try (	Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)
			)
		{ pstmt.setInt(1, (page-1)*numOfRecordes);
		  pstmt.setInt(2, page*numOfRecordes);
		  try(ResultSet rs = pstmt.executeQuery();){
			  while(rs.next()) {
					BoardDto dto = new BoardDto();
					
					dto.setBcode(rs.getInt("bcode"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setWriter(rs.getString("writer"));
					dto.setRegDate(rs.getDate("regDate"));
					
					//2. 위에서 만들어진 dto를 ArrayList 인 dtos에 차례로 입력하세요.
					dtos.add(dto);
				}
		  }
				

			} catch (Exception e) {
				e.printStackTrace();
			} 
		return dtos;
	}
	
	public int recordCount() {
		int count = 0;
		String sql = "select count(bcode) from board";
		try (	Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			)
			{
				if(rs.next())
					count = rs.getInt(1);

			} catch (Exception e) {
				e.printStackTrace();
			}
		return count;
	}
	
	public BoardDto selectOne(int bcode) {
		
		//3. 전달받은 bcode를 가진 레코드를 검색하는 select 문을 아래에 작성하세요.
		String sql = "select * from board where bcode = ?";
		
		
		BoardDto dto = new BoardDto();
		
		try (	Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				)
		{	pstmt.setInt(1, bcode);
		
			try(ResultSet rs = pstmt.executeQuery();)
			{
				rs.next();
				
				dto.setBcode(bcode);
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegDate(rs.getDate("regDate"));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void update(BoardDto dto) {
		String sql = "UPDATE board SET subject = ?, content = ?, writer = ?, regDate = ? WHERE bcode =?";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{
			pstmt.setString(1,  dto.getSubject());
			pstmt.setString(2,  dto.getContent());
			pstmt.setString(3,  dto.getWriter());
			pstmt.setDate(4,  (Date) dto.getRegDate());
			pstmt.setInt(5, dto.getBcode());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(int bcode) {
		String sql = "DELETE FROM board WHERE bcode =?";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{
			pstmt.setInt(1, bcode);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
		
}
