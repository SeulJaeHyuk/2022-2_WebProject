package cs.dit.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cs.dit.domain.BoardVO;
import cs.dit.mapper.BoardMapperTests;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j //lombok을 이용해 로그를 기록하는 Logger를 변수로 생성
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testGetList() {
	log.info("GetList---------------------------");
	BoardVO vo = new BoardVO();
		service.getList().forEach(board-> log.info(board)); //람다식 표현
	}
	
	@Test
	public void testGet() {
	log.info("GET---------------------------");
	BoardVO board = service.get(17L);
	log.info(board);
	}
	
	@Test
	public void testRemove() {
	log.info("Remove---------------------------");
	log.info("remove result : " + service.remove(4L));
	}
	
	@Test
	public void testModify() {
	log.info("Modify---------------------------");
	BoardVO board = service.get(17L);
	board.setContent("진짜 졸린다!!!!");
	log.info("Modify result : " + service.modify(board));
	}
}
