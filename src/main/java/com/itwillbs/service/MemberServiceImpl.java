package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service  // 스프링(root-context.xml)에서 해당 파일을 서비스로 인식하게 하려고 붙인 Annotation
public class MemberServiceImpl implements MemberService {

	// 멤버 변수 공간 ==========================================
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// MemberDAO 객체를 주입(DI) -- 객체를 직접 생성 X, 만들어진 객체 사용하기!!! 만들어진 게 어딨는데? root-context.xml 마트에~~
	@Inject
	private MemberDAO dao;
	
	// 멤버 변수 공간 끝 ==========================================

	
	
	// 1. memberJoin 시작
	@Override
	public void memberJoin(MemberVO vo) {
		log.info("(♥♥♥♥♥ 1.memberJoin(vo)) 컨트롤러가 -> 서비스Impl 호출했음");
		log.info("(♥♥♥♥♥ 1.memberJoin(vo)) 호출됨");
		log.info("(♥♥♥♥♥ 1.memberJoin(vo)) 서비스Impl -> DAOImpl 호출할 거임");
		
		// DAO 객체 생성 -> 메서드 호출
		//   dao 객체 있나? root-context.xml가서 빈즈 그래프 보니까,, memberDAOImpl 있네?! 이거 주입 받자~~
		//      객체 생성할 필요 XXX~~~~~~~~~~
		dao.insertMember(vo); // DAOImpl에서 엎어치기 했으니까 그게 실행됨~~ 
		// 흐름: Service --> DAOImpl_insertMember --> mapper.xml --> DB 가서 insert 하고 --> 다시 Service로 돌아옴!! --> 다시 Controller로
		
		log.info("(♥♥♥♥♥ 1.memberJoin(vo)) DAO 동작 완!! 서비스(現在)Impl에서 -> 컨트롤러로 돌아갈 것임");
		
		
	}
	// 1. memberJoin 끝
	
	
	// 2. memberLogin 시작
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		log.info("(♥♥♥♥♥ 2.memberLogin(MemberVO vo)) 컨트롤러가 -> 서비스Impl 호출했음");
		log.info("(♥♥♥♥♥ 2.memberLogin(MemberVO vo)) 호출됨");
		log.info("(♥♥♥♥♥ 2.memberLogin(MemberVO vo)) 서비스Impl -> DAOImpl 호출할 거임");
		
		// 컨트롤러 -> 로그인정보(vo[id,pw]) 들고 -> Service
		// Service -> 로그인정보(vo[id,pw]) 들고  -> DAO
		 
		log.info("(♥♥♥♥♥ 2.memberLogin(MemberVO vo)) dao.loginMember(vo) 호출");
		MemberVO loginVO = dao.loginMember(vo);
		log.info("(♥♥♥♥♥ 2.memberLogin(MemberVO vo)) loginVO: " + loginVO);
		
		return loginVO;
		//return dao.loginMember(vo); 이렇게 리턴에 바로 적어도 ㅇㅋㅇㅋ 
	}
	// 2. memberLogin 끝
	
	
	
	// 3. memberGet 시작
	@Override
	public MemberVO memberGet(String userid) {
		log.info("(♥♥♥♥♥ 3.memberGet(userid)) 컨트롤러가 -> 서비스Impl 호출했음");
		log.info("(♥♥♥♥♥ 3.memberGet(userid)) 호출됨");
		log.info("(♥♥♥♥♥ 3.memberGet(userid)) 서비스Impl -> DAOImpl -> getMember() 호출할 거임");
		
		// 주입 객체 사용해서 dao 메서드 호출 -> 바로 리턴!!!
		return dao.getMember(userid);
	}
	// 3. memberGet 끝
	


}
