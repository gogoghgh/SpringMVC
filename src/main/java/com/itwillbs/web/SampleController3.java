package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController3.class);
	
	// http://localhost:8080/web/doD
	// http://localhost:8080/web/doD?id=admin
	@RequestMapping(value = "/doD")
	public void doD(@ModelAttribute("id") String id) {
		log.info("(♥♥♥♥♥ SampleController3_doD) /doD 주소 호출 -> doD() 실행 -> 리턴값 void니까 views/doD.jsp 호출");
		log.info("(♥♥♥♥♥ SampleController3_doD) 파라메타 변수 id: " + id);
	}
	
	
	// http://localhost:8080/web/doD1?email=test@test.com
	@RequestMapping("/doD1")
	public String doD1(@ModelAttribute("email") String email) {
		log.info("(♥♥♥♥♥ SampleController3_doD1) /doD1 주소 호출 -> doD1() 실행 -> 리턴값 test니까 views/test.jsp 호출");
		log.info("(♥♥♥♥♥ SampleController3_doD1) 파라메타 변수 email: " + email);
		
		return "test";
	}
	
	
	
	// 좀 많이 보내볼게요!!!!!!! 객체를 보내보자!!
	// http://localhost:8080/web/doBean
	// http://localhost:8080/web/doBean?userid=admin&userpw=1234
	//      ㄴ -> INFO : com.itwillbs.web.SampleController3 - (♥♥♥♥♥ doBean) 파라메타 변수 vo: MemberVO [userid=admin, userpw=null, username=null, useremail=null, regdate=null, updatedate=null]
															// 개쩐다 ㄷㄷ userid에 이 값 들어가있네? 
															// MemberVO 객체에 포함되는 정보는 자동으로!!!! 저장시킴!!! 누가? 스프링이가
	// 퀘스트:  /doBean 호출 -> test.jsp로 가서 -> MemberVO 객체 전달해보기
	//                                                객체를,, 전달할 수 ,,, 있나,,???
	@RequestMapping("/doBean")
//	public String doBeanTest(@ModelAttribute("vo") MemberVO vo) {
					// 메서드 이름은 노상관~~ 암꺼나 ㅇㅋ^^
//	public String doBeanTest(MemberVO vo) { 
						// @ModelAttri~~ 생략한 형태,, --> 뷰페이지 넘어갔을 때 호출할 이름이 X...
						//   --> 전달하는 객체 클래스 이름의 첫글자를 소문자로 변경해서!! 부른다~~~ memberVO 이렇게 
	public String doBeanTest(MemberVO vo, Model model) {
						// 인수로 적어준 게,, 객체 생성 한 것이다,,,,,??? 
		
						// Model이 뭐고?
						// 스프링에서 제공하는 상자 객체 (정보를 담아서 전달하는 목적)
						// 모델 왜 만드노? 정보 담아서 전달하려고,,
						// 컨트롤러의 정보를 →  뷰페이지로 보내는 객체이다!!!!!
		
		log.info("(♥♥♥♥♥ doBean) /doBean 주소 호출 -> doBeanTest() 실행 -> 리턴값 test니까 views/test.jsp 호출");
		log.info("(♥♥♥♥♥ doBean) 파라메타 변수 vo: " + vo);

		
		// 파라메타가 아닌 곳에서 객체가 생겼을 때는? 근데 이걸 보내고 싶다면? 
		//  /doBean으로 호출했을 때,
		// (가정) DB sql 날린 결과 만들어진 값  -->  바로 jsp 로 보내서 출력하고 싶은데 어떡하쥐?
		MemberVO DBVO = new MemberVO();
		DBVO.setUserid("user01");
		DBVO.setUserpw("1234");
		DBVO.setUsername("용자1");
		DBVO.setUseremail("user01@01.com");
		
//		model.addAttribute(attributeName, attributeValue);
		// 영역객체애들.setAttribute("이름", 값)  이거랑 비슷하게 생겼죠??? 추억이네 ㅋ
		model.addAttribute("DBVO", DBVO);
		// -> key(이름), value(값) 쌍으로 정보를 저장해서 사용
		
		model.addAttribute(DBVO); 
		// 이름 저장 없이 걍 저장 ㅎㅎ 
		//   ㄴ--> 전달되는 타입의 클래스명(MemberVO)을 첫글자 소문자로 변경해서 뷰 페이지에서 이름으로 사용함 (memberVO)
		
		
		return "test";
	} // doBeanTest()
	
}
