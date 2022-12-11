package cs.dit.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cs.dit.domain.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j //lombok을 이용해 로그를 기록하는 Logger를 변수로 생성
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetList2() {
		
		boardMapper.getList2().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트!!!!");
		board.setContent("테스트라니까요!!");
		board.setWriter("홍길동");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testSelectOne() {
		log.info("selectOne.....................");
		
		BoardVO board = boardMapper.selectOne(100L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("delete.....................");
		
		int i = boardMapper.delete(98L);
		log.info("delete count : " + i);
		
	}
	@Test
	public void testUpdate() {
		log.info("update.....................");
		BoardVO board = new BoardVO();
		board.setBno(99L);
		board.setTitle("업데이트");
		board.setContent("업데이트중...");
		board.setWriter("홍길동");
		
		int i = boardMapper.update(board);
		log.info("update count : " + i);
		
	}	
}
