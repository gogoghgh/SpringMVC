package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//  @RunWith(SpringJUnit4ClassRunner.class)
//   : 이 클래스를 스프링모드로 테스트하겠습니다... 라는 표시다!! 이게 없으면 걍 자바 junit으로 테스트하는거고~~ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
//			ㄴ 프로젝트 실행할 때 사용할 설정, 위치: ~~
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} 
		)

public class DataSourceTest {
	// DataSource 객체 생성여부 확인
	

	private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);
	
	
	
	// DataSource 객체 생성 (직접 생성 - 강한 결합 -> 주입 ????)
	
	// @Inject :  Spring에 있는,, (=쇼핑몰?) 객체(빈)를 가져와서 주입하겠다!! 
				// 객체 직접 생성하지 않고, 의존관계를 주입하겠다... 
				// => DI (Dependency Injection)
	
	@Inject // 얘 추가하니까.. 객체가 생겼네,,??? ㄷㄷㄷ 객체 생성 됐네?!?! ds = null이었는데?? 
			// INFO : com.itwillbs.web.DataSourceTest - DataSource ds: org.springframework.jdbc.datasource.DriverManagerDataSource@46fa7c39
//	@Autowired
	private DataSource ds; // javax.sql 걸로 하삼
	
	@Test
	public void DataSource있는지(){
		// DataSource 객체가 필요,,== 의존하고 있다==의존관계
		
		log.info("DataSource ds: " + ds); //null이군~
	}
	
	@Test
	public void DB진짜연결되는지() {
		// DB 연결 체크
		
		try {
			Connection con = ds.getConnection();
			
			if(con != null) {
				log.info("DB 연결 성공 ㅊㅋㅊㅋ");
				log.info("con: " + con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
