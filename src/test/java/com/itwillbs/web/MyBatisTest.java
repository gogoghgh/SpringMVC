package com.itwillbs.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 일반 클래스가 아니라~~~ junit으로 실행할 수 있게!!! 세팅하고
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
						// root-context.xml에 있는 dataSource 객체와, sqlSessionFactory 쓰기 위한 설정,,
		)

public class MyBatisTest {
	private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);

	// DB 연결 / MyBatis 설정 => 의존 관계다,,,,, ㅋ 제어의 역전이 발생해서 객체를 외부에서부터 주입받아올 수 있더라~ 
	
	// 의존관계 (DI : Dependency Injection 수행)
	//          의존관계 없이 생성하려면 각각 new 하면 되는데~ 지금은 root-context.xml에서 객체 다 생성해놨기 때문에
	//          내가 직접 만들 필요 없이 주입해서 쓰면 된다,,
//	@Inject
	private DataSource ds; // DB 연결 정보 처리하는 객체
	
	@Autowired
	private SqlSessionFactory sqlFactory;  // DB 연결 정보 + mybatis 설정까지!! 하는 객체
	
	
	@Test
	public void 객체_주입_잘됐나_여부_확인() {
		log.info("♥♥♥♥♥ DataSource ds: " + ds);
		log.info("♥♥♥♥♥ SqlSessionFactory sqlFactory: " + sqlFactory);
	}
	
	@Test
	public void 디비_연결_테스트() {
		SqlSession sqlSession = sqlFactory.openSession(); // 디비 연결
		// sqlSession 객체에  <-- sqlFactory 객체의 openSession 메서드 리턴값을
		
		log.info("♥♥♥♥♥ sqlSession: " + sqlSession);
//		sqlSession.insert/commit/delete/rollback. . .  등등 ... 많네~~^^
//		sqlSession.insert(statement);
//		sqlSession.commit();
//		sqlSession.delete(statement);
//		sqlSession.rollback();
		/* sql 쿼리에 대한 연결 수행 + sql 쿼리 제어, 실행할 수 있는 객체가 된 것이다~ */
		
	}
	
}
