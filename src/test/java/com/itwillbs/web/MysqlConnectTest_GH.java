package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlConnectTest_GH {
	// 테스트 클래스: 
	// 서버를 사용해서 테스트하던 동작을,, jUnit을 사용해서 대신 테스트하는 클래스
	
	// @Test: 테스트 동작을 수행하는 메서드에 사용
	//        @Test가 있어야만!!! jnit 실행 가능!! 쟤 주석 처리해보면 앎^^
	//        객체 생성,, 메서드 호출,, 할 필요 없이!! 이 주석 하나로 실행이 된다~!! 
	//        jnit 행님이 대신 실행해준다~ 댕큐 댕큐~~
	//        근데 순서는,, junit 지맘대로~~~ 작성 순서가 실행 순서를 보장하지 않음!! 랜덤임..
	//        순서 설정하고 싶으면 @Before나 @After 추가~~
	
	// @Before: 테스트 작업 전에!! 반드시 준비(실행)되어야 하는 동작을 처리하는 annotation
	// @After: 테스트 작업 후에!! 반드시 처리하는 동작
	
	// 테스트에서 junit 실행 순서
	// : @Before 먼저 실행 --> @Test 찾아가서 실행 --> @After 실행
	
	// 인제 sysout 안 쓰고,, logger 쓸 거임,,,, 
//	private static final Logger mylog =  LoggerFactory.getLogger(MysqlConnectTest.class);
	// ㄴmylog 단축키 만들고 옴^^
	private static final Logger log = LoggerFactory.getLogger(MysqlConnectTest.class);
	
	
	@Test
	public void test() throws Exception {
		System.out.println("(MysqlConnectTest) 1.test() 호출됨");
		System.out.println("(MysqlConnectTest) 테스트 클래스 실행!!!!!!!\n");
		// 실행하려면,, 객체 생성하고~~~ .test()해서 불렀어야 됐는데,, 그 럴 필 요 없 다 ㄷ ㄷ 
	}
	
//	@Test      // 우와~~ 한글 이름도 삽가능~~^^
	@Before
	public void 테서터동작하나보는테서터ㅋ() throws Exception {
		System.out.println("(MysqlConnectTest) 2.테서터동작하나보는테서터ㅋ() 호출됨");
		System.out.println("(MysqlConnectTest) 테스트 클래스 실행!!!!!!!\n");
	}
	
	@Test
	public void 디비연결테스트() throws Exception {
		System.out.println("(MysqlConnectTest) 3.디비연결테스트() 호출됨");
		System.out.println("(MysqlConnectTest) 테스트 클래스 실행!!!!!!!\n");
		
		// 디비 연결하기~
		// 1. 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("(MysqlConnectTest) 3.디비연결Test: 드라이버 로드 성공");
		
		// 2. DB 연결
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "1234");
		System.out.println("(MysqlConnectTest) 3.디비연결Test: DB 연결 성공~~ con: " + con);
		// 지금까지 우리,, 이런 작업들 실제로 서버 돌려서 확인했었지요? 
		// 근데 지금은,, 서버 안 돌리고!!! junit이 대신 서버역할 하면서 연결도 해보고~ DB 접속도 해보고~~~ 캬 좋네

//		mylog.info("3.디비연결Test: 실행되나? 테스트");
		log.info("3.디비연결Test: 실행되나? 테스트");
		
	}
	
	
	@Test
	public void 디비연결테스트2() throws Exception {
		System.out.println("(MysqlConnectTest) 디비연결테스트2() 호출됨");
		System.out.println("(MysqlConnectTest) 테스트 클래스 실행!!!!!!!\n");
		
		// try-with 구문
		//    try(자원해제가 필요한 객체 사용, AutoCloseable 인터페이스 객체를 상속하고 있는 객체를 여기다 써주세요){
		//          예외 발생할만한 코드
		//    } catch (Exception e) {
		//          예외 처리 코드
		//    }
		
		
		
		// try-with 구문 써서.. << 자원해제 알아서 해줌!! try 괄호 안에 그 객체 적으면,, 나오게
		// 디비 연결하기~
		try (Connection con = DriverManager.getConnection(
										"jdbc:mysql://localhost:3306/springdb", 
										"root", 
										"1234")) 
		{
			System.out.println("(MysqlConnectTest) 디비연결Test2: DB 연결 성공~~ con: " + con);
			// 1. 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("(MysqlConnectTest) 디비연결Test2: 드라이버 로드 성공");

			log.info("디비연결Test2: 실행되나? 테스트");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
}
