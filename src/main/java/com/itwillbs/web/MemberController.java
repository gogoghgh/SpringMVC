package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*") // member로 시작하는 주소는 다 this 클래스,, 컨트롤러,,,가 캐리한다
public class MemberController {

	// 멤버 변수 공간 ==================================	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	//  서비스 객체 주입받기
	@Inject
	private MemberService service;
	
	// 멤버 변수 공간 끝 ==================================
	
	
	
	// http://localhost:8080/web/member/test  (X)
	// http://localhost:8080/member/test      (O)
	@RequestMapping("/test")
	public void TestMember() {
		log.info("(♥♥♥♥♥ TestMember) MemberController 실행됨");
	}
	
	
	
	// 회원 가입 GET  (조회하기-단순 출력時 || 입력 받기) 
				// ㄴ주소줄에 데이터 담아 보내서~ 길이 제한 있고~ 근데 처리속도 빠르고~~
	
	// http://localhost:8080/member/insert
	//                        ㄴ컨트롤러 찾고(MemberController)
	//                                 ㄴ메서드 찾고(insertGET)
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertGET() {
		log.info("(♥♥♥♥♥ insertGET) 호출됨");
		log.info("(♥♥♥♥♥ insertGET) 연결된 view 페이지 출력해줄거"); 
		// 패턴1. DB 안 쓰고 바로 뷰 페이지로~
		// void니까 뭐 리턴할 필요도 없고~  insert.jsp로 이동하겠군~~ 
		log.info("(♥♥♥♥♥ insertGET) 리턴타입 void라서 member/insert.jsp로 이동할거"); 
		
	}
	
	
	// 회원 가입 POST (입력 받은 거 DB 처리하기)
				// ㄴ주소줄이 아니라 내용에 데이터 담아 보내서~ 길이 제한 없고~ 대신 처리속도 느리고~~
	// @PostMapping  얘도 있음~~
//	@RequestMapping(value = "/insertPro", method = RequestMethod.POST) 
							// ㄴ이건 배울 때 이렇게 쓰는 거고~~ 실무에선 pro 뗀다!!
							// 어떻게 구분하지,,,? get이냐, post냐 이걸로!!!! 음~~~ ㅇㅋㅇㅋ
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public String insertPOST(HttpServletRequest request) throws Exception {
	public String insertPOST(MemberVO vo, HttpServletRequest request) throws Exception {
						// vo 관련된 정보 파라메타에서 넘어오면, 컨트롤러가 알아서! 자동으로!! 수집해준다~~~ 따봉~!!
						// 그니까 컬럼명이랑 input에 name값이랑 똑같이 해야 하는거^^
		log.info("(♥♥♥♥♥ insertPOST) 호출됨.. 폼 태그니까 post 방식");
		
/*		// 기존 MVC 에선~~~~~~~~~~~~~
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전달 정보 저장 (userid, pw, name, email)
		//     ㄴ한방에 저장하기 위해,, memberVO 객체 생성
		MemberVO vo = new MemberVO();
		vo.setUserid(request.getParameter("userid"));
		vo.setUserpw(request.getParameter("userpw"));
		vo.setUsername(request.getParameter("username"));
		vo.setUseremail(request.getParameter("useremail"));
		log.info("(♥♥♥♥♥ insertPOST) 전달받은 vo: " + vo); // 정보 보이나 체크
		
		// 3. 회원 가입 메서드 호출 -> DB에 저장
		// 4. 페이지 이동 (로그인 페이지로)
		// 는 옛날 방식이었고요~~ */
		
		
		
		// 스프링에선~~~~~~~~~~~~~~~
		// 2단계 필요 없음,, ㄷㄷㄷ 걍 인수에 MemberVO 넣어놓으면 똑같은 애들 자동으로 착착 받아오네
		log.info("(♥♥♥♥♥ insertPOST) 전달받은 vo: " + vo); // 정보 보이나 체크
		
		// 회원 가입 동작 -> 서비스 -> DB에 저장
		//        컨트롤러가 아니라 서비스가 -> DB를 호출하도록!! // 서비스 객체 저 위에 생성해놨고(주입)
		service.memberJoin(vo);
		
		log.info("(♥♥♥♥♥ insertPOST) 회원가입 성공");
		
		// 페이지 이동 (로그인 페이지로)
		return "redirect:/member/login"; // redirect 해야 하니까,, 주소줄 이동 yes + 페이지 이동 yes 니까!!!! 
//		return "/member/login"; 
		//      ㄴ--> 주소줄에는 insert고,, 화면은 login.jsp 페이지 뜨고,,, 
		//            주소는 회원가입인데, 화면은 로그인이다? 노우노우~~ 망한거네~
	}
	
	
	
	// 로그인 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() {
		log.info("(♥♥♥♥♥ loginGET) 실행");
		
		// 전달 받은 거 유무 여부 중요 !!!!! 
		// insert -> login 왔을 때, 전달 받은 게 있나? ㄴㄴ 그냥 바로 왔음~
		
		log.info("(♥♥♥♥♥ loginGET) 전달 받은 거 따로 없음~ 연결된 뷰 페이지로 이동할게요");
		
		// return "/memberLogin"; XXX  
		return "/member/memberLogin";  
				// String이 리턴타입일 때는, 호출하고자 하는 주소 풀네임!!!으로 적어줘야 함~ 폴더명까지 다
	}
	
	
	
}
