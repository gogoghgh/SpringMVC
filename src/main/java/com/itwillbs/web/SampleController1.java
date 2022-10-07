package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 이 주석만 달면~ httpServlet 상속받고,,  doGet, doPost,,,, 하던 거 쌉 대체!!!
			// : 해당 클래스를 컨트롤러로 처리하겠다~~~고 등록!! 어디에 등록? 스프링에 등록^^
public class SampleController1 {

	private static final Logger log = LoggerFactory.getLogger(SampleController1.class);
	
	
//	@RequestMapping("/doA") // doA라는 주소가 호출되면? 이 메서드를 실행해라~~~~~~ get, post 방식 상관 없이~~ 이 주소가 호출되면 실행
							// 특정 주소에, 특정 방식으로 호출될 때 실행하는 메서드 연결
//	@GetMapping("/doA")   // 같네~~ 단! get방식으로 실행됐을 때만~~
	@RequestMapping(value = "/doA", method = RequestMethod.GET) // 풀네임^^
	public void doA() {
		log.info("(♥♥♥♥♥ SampleController1_doA) /doA 주소 호출, doA() 실행 ");
		// 기존 MVC보다 할 게 줄어들었죠~
		// 기존: 가상 주소 주면 -> 1단계 주소 자르고 -> 2단계 매핑,, 
		// 지금: 1, 2단계 필요없고 requestmapping annotation만 붙이면,,!!! 바로 되네 와~~ 
	}
	
	
	@RequestMapping("/doB")
	public void doB() {
		log.info("(♥♥♥♥♥ SampleController1_doB) /doB 주소 호출, doB() 실행 ");
	}
	
	// 컨트롤러 안에 -> 메서드의 리턴타입이 void일 때, 
	// 호출되는 주소를 사용해서 뷰를 연결
	// /views/주소.jsp 페이지 연결 자동 호출
	
	
	
}
