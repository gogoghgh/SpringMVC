package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/itwill/*") // itwill 밑에 어떤 게 오든~~~ 다 욜로 보내달라~~ 
							   // 클래스 위에다가 이걸 써가지고,,,, 각각의 컨트롤러 구분 가능!!
public class SampleController2 {

	private static final Logger log = LoggerFactory.getLogger(SampleController2.class);
	
	// http://localhost:8080/web/doC?msg=Busan
	@RequestMapping("/doC")
//	public String doC() {
	public String doC(@ModelAttribute("msg") String msg) {
					// @ModelAttribute("파라메타 이름") 역할
					// : 1) 페이지 요청 시 전달되는 파라메타 이름의 정보를 사용해서 -> 문자열 변수에 저장
					//   2)  + 뿐만 아니라!!!! 방금 저장한 정보를 뷰 페이지로 전달까지 해준다~~ 개이득 ㄷㄷ
					//       request.setAttribute("msg", msg); 이 과정 생략!!!!! 자동으로 처리됨 ~~~^^
					//    ==> so, EL 표현식 사용해서 호출하면 된다~ 
		
		log.info("(♥♥♥♥♥ SampleController2_doC) /doC 주소 호출, doC() 실행 ");
		log.info("(♥♥♥♥♥ SampleController2_doC) 파라메타 변수 msg: " + msg);
		
//		return ""; 
		// 실행해보니까 결과: 404 에러 --> 메시지 파일 [/WEB-INF/views/.jsp]을(를) 찾을 수 없습니다.
		// 아하~~ 내가 리턴했던 값이 저 자리에 들어가구나^^
		
//		return "love";
		// 결과: 메시지 파일 [/WEB-INF/views/love.jsp]을(를) 찾을 수 없습니다.
		
		// 아하ㅏ~~~~ 메서드의 리턴타입이 String일 때,
		// 리턴되는 문자열.jsp 페이지를 호출하는 거구나~~~ 
		// (뷰 페이지 자동으로 연결시켜준다 했잖아욤)
		
		return "itwill";
		// == /WEB-INF/views/itwill.jsp
		// =====  http://localhost:8080/web/doC?msg=Busan  이렇게 주소줄에 써보내도 되넴~~
	}
	
	
	
	/*
	@RequestMapping("/doC1")
	public int doC1() {
		
		return 1;
		// 얜 안 됨 ㅋ double도 안 됨 
		// 500에러,, 메시지 Request processing failed; nested exception is java.lang.IllegalArgumentException: Unknown return value type: java.lang.Integer
	
	} */
	
	
	
	//   /doC1이라는 주소를 호출해서,  doA.jsp 페이지에 정보 출력을 하고 싶다~~
	//     http://localhost:8080/web/doC1?name=itwill&tel=0518030909
	@RequestMapping("/doC1")
	public String doC1(@ModelAttribute("name") String name, 
						@ModelAttribute("tel") String tel) {
		
		log.info("(♥♥♥♥♥ SampleController2_doC1) /doC1 주소 호출, doC() 실행 ");
		log.info("(♥♥♥♥♥ SampleController2_doC1) 파라메타 변수 name: " + name + " / tel: " + tel);
		
		return "doA";
	}
		
}
