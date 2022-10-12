package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	// test
	// http://localhost:8080/web/member/test  (X)
	// http://localhost:8080/member/test      (O)
	@RequestMapping("/test")
	public void TestMember() {
		log.info("(♥♥♥♥♥ TestMember) MemberController 실행됨");
	}
	
	
	
	// 1-1. 회원가입 GET  (조회하기-단순 출력時 || 입력 받기)            http://localhost:8080/member/insert
				// ㄴ주소줄에 데이터 담아 보내서~ 길이 제한 있고~ 근데 처리속도 빠르고~~
	
	// http://localhost:8080/member/insert
	//                        ㄴ컨트롤러 찾고(class MemberController)
	//                                 ㄴ메서드 찾고(insertGET 메서드)
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertGET() {
		log.info("(♥♥♥♥♥ 1-1.insertGET) 호출됨");
		log.info("(♥♥♥♥♥ 1-1.insertGET) 연결된 view 페이지 출력해줄거"); 
		// 패턴1. DB 안 쓰고 바로 뷰 페이지로~
		// void니까 뭐 리턴할 필요도 없고~  insert.jsp로 이동하겠군~~ 
		log.info("(♥♥♥♥♥ 1-1.insertGET) 리턴타입 void라서 member/insert.jsp로 이동할거"); 
		
	}
	// 1-1. 회원가입 GET 끝
	
	
	// 1-2. 회원가입 POST (입력 받은 거 DB 처리하기)           http://localhost:8080/member/insert
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
		log.info("(♥♥♥♥♥ 1-2.insertPOST) 호출됨.. 폼 태그니까 post 방식");
		
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
		log.info("(♥♥♥♥♥ 1-2.insertPOST) 전달받은 vo: " + vo); // 정보 보이나 체크
		
		// 회원 가입 동작 -> 서비스 -> DB에 저장
		//        컨트롤러가 아니라 서비스가 -> DB를 호출하도록!! // 서비스 객체 저 위에 생성해놨고(주입)
		service.memberJoin(vo);
		
		log.info("(♥♥♥♥♥ 1-2.insertPOST) 회원가입 성공");
		
		// 페이지 이동 (로그인 페이지로)
		return "redirect:/member/login"; // redirect 해야 하니까,, 주소줄 이동 yes + 페이지 이동 yes 니까!!!! 
//		return "/member/login"; 
		//      ㄴ--> 주소줄에는 insert고,, 화면은 login.jsp 페이지 뜨고,,, 
		//            주소는 회원가입인데, 화면은 로그인이다? 노우노우~~ 망한거네~
	}
	// 1-2. 회원가입 POST 끝
	
	
	
	
	// 2-1. 로그인 GET           http://localhost:8080/member/login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() {
		log.info("(♥♥♥♥♥ 2-1.loginGET) 호출됨");
		
		// 전달 받은 거 유무 여부 중요 !!!!! 
		// insert -> login 왔을 때, 전달 받은 게 있나? ㄴㄴ 그냥 바로 왔음~
		
		log.info("(♥♥♥♥♥ 2-1.loginGET) 전달 받은 거 따로 없음~ 연결된 뷰 페이지로 이동할게요");
		
		// return "/memberLogin"; XXX  
		return "/member/memberLogin";  
				// String이 리턴타입일 때는, 호출하고자 하는 주소 풀네임!!!으로 적어줘야 함~ 폴더명까지 다
	}
	// 2-1. 로그인 GET 끝
	
	
	
	
	// 2-2. 로그인 POST           http://localhost:8080/member/login
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginPOST(MemberVO vo /*,@ModelAttribute("userpass") String userpass*/
								, HttpSession session) {
			// loginPOST 메서드가 실행될 때, MemberVO 받아오고, HttpSession 정보 받아와야 한다!! 얘네가 매개변수다!!
			//   ㄴ== 로그인 폼에서 로그인 버턴 딱 누를 때!!
			//     그러면 우리가~ ~ 세션 정보 저장시키고 그래야 하는 거 아닌가요~~?? 
			//      아닙니다^^ 저렇게만 적어놓으면 스프링이 알아서 갖고 와줌
			//      스프링이 하는 일: 직전 동작에서(로그인 버턴 누를 때) vo 정보랑, session 정보를 가져온다!!!!!!!!!!
		log.info("(♥♥♥♥♥ 2-2.loginPOST) 호출됨");
		
		// 한글처리 => web.xml에 필터로 해놨던거 사용 == 생략^^
		// 전달 정보 저장( 파라미터 - userid, userpw )
		
		// log.info("userpass : "+userpass);
		log.info("(♥♥♥♥♥ 2-2.loginPOST) 전달받은 vo: " + vo);
		
		// 컨트롤러(여기) -> Service -> DAO -> DB에서 확인
		MemberVO loginVO = service.memberLogin(vo);
		
		log.info("(♥♥♥♥♥ 2-2.loginPOST) loginVO : "+loginVO);
		
		// 로그인 여부 확인
		if(loginVO != null) {
			// 성공 -> 메인페이지 이동, 로그인 정보를 저장(세션)
			
			// jsp(view.. 로그인 폼,..) 에서 세션 정보를 가져와서 사용~~~~
			session.setAttribute("loginVO", loginVO);
			
			return "redirect:/member/main"; // 주소줄 변화 O + 페이지 이동 O
			
		}else {
			// 실패 -> 로그인페이지 이동
			return "redirect:/member/memberLogin";
		}
		
	}
	// 2-2. 로그인 POST 끝
	
	
	
	// 3. 메인페이지 GET()           http://localhost:8080/member/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		log.info("(♥♥♥♥♥ 3.mainGET) 호출됨");
		log.info("(♥♥♥♥♥ 3.mainGET) void 리턴 --> /member/main.jsp 뷰 호출할게용");
		
	}
	// 3. 메인 GET 끝
	
	
	
	// 4. 로그아웃 GET
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		log.info("(♥♥♥♥♥ 4.logoutGET) 호출됨");
		log.info("(♥♥♥♥♥ 4.logoutGET) 세션값 뭐고?? session: " + session);
		
		// 로그아웃 == 세션 초기화
		session.invalidate();
		log.info("(♥♥♥♥♥ 4.logoutGET) 세션값 초기화 완");
		
		log.info("(♥♥♥♥♥ 4.logoutGET) return String --> 메인으로 redirect 이동");
		return "redirect:/member/main"; // 주소줄 변화 O + 페이지 이동 O
		
	}
	// 4. 로그아웃 GET 끝
	
	
	
	// 5. 회원 정보 조회 GET           http://localhost:8080/member/info
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model ) {
		log.info("(♥♥♥♥♥ 5.infoGET) 호출됨");
		
		// 직전 페이지(main.jsp)에 있던 ID 정보(loginVO) -> 여까지 끌고 와야 함 -> info 페이지로 넘겨주기
		MemberVO vo = (MemberVO) session.getAttribute("loginVO");
		
		// 정보 잘 넘어왔나 확인
		log.info("(♥♥♥♥♥ 5.infoGET) 전달받은 ID: " + vo.getUserid());
				
		// 컨트롤러(여기) -> Service -> DAO -> MyBatis(mapper.xml) -> DB 가서 정보 가져와서 
		// -> 결괏값 DAO에 리턴 -> Service로 리턴 -> 결괏값 갖고 다시 컨트롤러로~~ -> view에 출력해주~~기~~~
		MemberVO userVO = service.memberGet(vo.getUserid());
		log.info("(♥♥♥♥♥ 5.infoGET) 결과데이터 userVO: " + userVO);
		
		// 결과데이터 뷰에 출력하기 위해서 모델 객체에 저장!!! 
		//   모델이 데이터 담는 상자니까,, 이걸 이용해서 넘겨주자 
		model.addAttribute("userVO", userVO);
		
	}
	// 5. 회원 정보 조회 GET 끝
	
	
	
	
}
