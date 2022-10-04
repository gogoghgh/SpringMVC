package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistance.MemberDAO;
import com.itwillbs.persistance.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class) // 모드 체인쥐~!!!!! 해당 파일을 스프링(Junit)을 사용해서 테스트하도록 설정한다~~~ 
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		) // 스프링 테스트할 때 필요한 설정을, 위 경로에서 가져다가 사용하겠다~ 저기가 마트니까~~
public class MemberDAOTest {
	// MemberDAO 동작이 정상적으로 실행되는지 테스트하는 파일 ^^
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);
	
	// DAO 객체 생성 << 직접 X !!! 객체 주입 Yessssss~!~!~!~!!!!!!!!!!!!
//	MemberDAO dao = new MemberDAO(); // XXX 왜? MemberDAO가 인터페이스라서
//	MemberDAOImpl daoImpl = new MemberDAOImpl(); // 사용 가능 (강한 결합) 
												//  우리가 쭉 해왔던 방식이지만~~` 이젠 객체 주입으로^^ 강한 결합 노노!!
//	MemberDAO dao = new MemberDAOImpl(); // 사용 가능 (중간 결합) 
										// 上 = new 下 업캐스팅
	
	// 그니까~~ 객체 주입받아서 쓰자~~~~^^
	// 주입받아올 곳은? 스프링!! root-context.xml에서!!!! DAO injection 받아와야 함
	//   근데,, root-context.xml에 DAO 없는데,,? 우야노 우야노,,,,
	//    --> MemberDAOImpl 에다가 @Repository 추가
	@Inject 
	private MemberDAO dao;
	
	
	@Test
	public void daoTest() {
		log.info("(♥♥♥♥♥ MemberDAOTest_daoTest)  dao: " + dao);
		// dao 있네~~~^^ 
		// INFO : com.itwillbs.web.MemberDAOTest - ♥♥♥♥♥ dao: com.itwillbs.persistance.MemberDAOImpl@660acfb
	}
	
	
	@Test
	public void DB_시간_정보_조회() {
		log.info("(♥♥♥♥♥ MemberDAOTest_DB_시간_정보_조회) dao.getTime: " + dao.getTime());
	}
	
}
