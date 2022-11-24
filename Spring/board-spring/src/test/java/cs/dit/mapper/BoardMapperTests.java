package cs.dit.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cs.dit.domain.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j //lombok을 이용해 로그를 기록하는 Logger를 변수로 생성
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testBoardGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
	log.info("insert …………………………………………");
	BoardVO board = new BoardVO();
	board.setTitle("테스트!!!");
	board.setContent("테스트!!!");
	board.setWriter("테스트!!!");
	mapper.insert(board);
	log.info(board);
	}
	
	@Test
	public void testSelectOne() {
	log.info("selectOne.....................");
	BoardVO board = mapper.selectOne(100L);
	log.info(board);
	}
	
	@Test
	public void testDelete() {
	log.info("test/delete------------------");
	log.info("delete" + mapper.delete(100L));
	}

	@Test
	public void testUpdate() {
	BoardVO board = new BoardVO();
	board.setBno(4);
	board.setTitle("수정 제목");
	board.setContent("수정 내용");
	board.setWriter("작성자 수정");
	log.info("test-update ----------------");
	int count = mapper.update(board);
	log.info("update count" + count);
	}
}
