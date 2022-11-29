package cs.dit.sample;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j //lombok을 이용해 로그를 기록하는 Logger를 변수로 생성
public class SampleTests {
	
	@Autowired
	private Restaurant rest;
	private DataSource ds;
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void test01() {
		log.info("test01.................................");
		log.info(rest);
	}
	@Test
	public void testCP() {
		
		try(Connection con = ds.getConnection();)
		{
			log.info("testCP.............................");
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	@Test
	public void testMybatis() {
		
		try(SqlSession session = sessionFactory.openSession();
				Connection con = session.getConnection())
		{ 
			log.info("sqlSession-----------------------------");
			log.info(session);
			log.info(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
