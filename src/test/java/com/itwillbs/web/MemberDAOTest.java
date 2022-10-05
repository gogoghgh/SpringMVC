package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
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
	
	
//	@Test
	public void daoTest() {
		log.info("(♥♥♥♥♥ MemberDAOTest_daoTest)  dao: " + dao);
		// dao 있네~~~^^ 
		// INFO : com.itwillbs.web.MemberDAOTest - ♥♥♥♥♥ dao: com.itwillbs.persistance.MemberDAOImpl@660acfb
	}
	
	
	
//	@Test
	public void DB_시간_정보_조회() {
		log.info("(♥♥♥♥♥ MemberDAOTest_DB_시간_정보_조회) dao.getTime: " + dao.getTime());
	}
	
	
	
	@Test
	public void 횐_가입_테서터() {
//		log.info("(♥♥♥♥♥ MemberDAOTest_횐_가입_테서터) dao.insertMember: " + dao.insertMember(vo) );
		log.info("(♥♥♥♥♥ MemberDAOTest_횐_가입_테서터) 회원가입 테스트 실행됨");
		log.info("(♥♥♥♥♥ MemberDAOTest_횐_가입_테서터)  --> DAOImpl 부를거임^^ ↓↓↓↓↓");
		
		MemberVO vo = new MemberVO(); // 얘는 강한 결합 아녀요??? ㄱ-  객체 주입해야하는 거 아닌감 
										// --> ㄴㄴ 주입할 필요 없음!! 매번 쓰는 것도 아니고~~~ 
		vo.setUserid("pooh");
		vo.setUserpw("pppp");
		vo.setUsername("푸우");
		vo.setUseremail("pooh@pooh.com");
		
		dao.insertMember(vo);
		
	} 
	// 1. 회원가입 insertMember Test 끝
	
	
	
	// 2. 로그인 체크 -- 입력받은 정보를 DB 값과 비교 
//	@Test
	public void 로그인_로직_테서터() {
		log.info("(♥♥♥♥♥ MemberDAOTest_로그인_로직_테서터) --> DAOImpl 부를 거임 ↓↓↓↓↓");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("12345");
		
//		MemberVO resultVO = dao.loginMember(vo); // 리턴타입이 MemberVO인 메서드^^ loginMember1
		MemberVO resultVO = dao.loginMember(vo.getUserid(), vo.getUserpw()); // loginMember2
		
		if(resultVO == null) {
			log.info("(♥♥♥♥♥ MemberDAOTest_로그인_로직_테서터) 회원정보 없음,, 로그인 실패");
		} else {
			log.info("(♥♥♥♥♥ MemberDAOTest_로그인_로직_테서터) 회원정보 있음,, 로그인 성공!!!");
			log.info("(♥♥♥♥♥ MemberDAOTest_로그인_로직_테서터) resultVO: " + resultVO);
		}
		
	}
	// 2. 로그인 체크 loginMember Test 끝
	
	
	
	// 3. 회원 정보 조회(아이디만 사용)
//	@Test
	public void 회원_정보_조회() {
		log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) --> DAOImpl 부를 거임 ↓↓↓↓↓");
		
		// DAO 객체 생성,, 할 필요 없음!! 젤 위에 dao 객체 주입받았기 때문에 이미 생성되어있는 상태
		
		// dao 안에 회원 정보 조회 메서드(리턴타입 MemberVO) 호출
		MemberVO vo = dao.getMember("haha");
		
		if( vo != null) {
			// vo가 null이 아니다 == 데이터가 있다 == 아이디에 해당하는 정보가 DB에 있다~~
			
			// 확인(콘솔에 출력해보기^^)
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 아이디: " + vo.getUserid());
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 비번: " + vo.getUserpw());
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 이름: " + vo.getUsername());
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 이메일: " + vo.getUseremail());
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 가입일: " + vo.getRegdate());
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_조회) 정보수정일: " + vo.getUpdatedate());
			
		}
		
	}
	// 3. 회원 정보 조회 getMember 끝
	
	
	
	// 4. 회원 정보 수정 - 아이디, 비밀번호가 같을 때 이메일 수정 (+ 정보 수정일 updatedate도 업뎃되게)
//	@Test
	public void 회원_정보_수정() {
		log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_수정) --> DAOImpl 부를 거임 ↓↓↓↓↓");
		
		MemberVO uvo = new MemberVO();
		uvo.setUserid("admin"); // 기존
		uvo.setUserpw("12344"); // 기존
		uvo.setUseremail("admingg@admin.com"); // 수정할 데이터 입력
		
		int result = dao.updateMember(uvo);
		
		if(result==1) {
			// 수정 완
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_수정) 수정 성공 uvo: " + uvo);
			
		} else {
			// 수정 실패
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_수정) 수정 실패ㅠ uvo: " + uvo);
		}
		
	}
	// 4. 회원 정보 수정 updateMember 끝

	
	
	// 5. 회원 정보 삭제
//	@Test
	public void 회원_정보_삭제() {
		log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_삭제) --> DAOImpl 부를 거임 ↓↓↓↓↓");
		
		MemberVO dvo = new MemberVO();
		dvo.setUserid("haha");
		dvo.setUserpw("h");
		
		int result = dao.deleteMember(dvo);
		
		if(result == 1) {
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_삭제) 삭제 성공 dvo: " + dvo);
			
		} else {
			log.info("(♥♥♥♥♥ MemberDAOTest_회원_정보_삭제) 삭제 실패 dvo: " + dvo);
			
		}
			
	}
	// 5. 회원 정보 삭제 끝
	
	
	
	// 6. 전체 회원 목록 조회	
//	@Test
	public void 전체_회원_목록_조회() {
		log.info("(♥♥♥♥♥ MemberDAOTest_전체_회원_목록_조회) --> DAOImpl 부를 거임 ↓↓↓↓↓");
		
		// DAO 전체 회원 목록 조회 메서드 호출
		List<MemberVO> memberList = dao.getMemberList();
		
		for (MemberVO vo : memberList) {
			log.info("(♥♥♥♥♥ MemberDAOTest_전체_회원_목록_조회) 아이디: " + vo.getUserid());
		}
		
	}
	// 6. 전체 회원 목록 조회 끝
	
	
	
}// MemberDAOTest
