package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger log = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("/doE")
//	public String doE() {
//	public String doE(Model model) { // 모델 객체 추가~~ (정보 전달 방법2)
	public String doE(Model model, RedirectAttributes rttr) { // 또 추가~ (정보 전달 방법3)
		log.info("(♥♥♥♥♥ doE) /doE 주소 호출 -> doE() 실행");
		
//		return "/doF"; 
		//이렇게 하면 doF부를 수 있을까???
		// ㄴㄴㄴ...
		// 404 에러 메시지 파일 [/WEB-INF/views/doF.jsp]을(를) 찾을 수 없습니다.
		// doE() -> doF 페이지로 이동
		// doF() -> doF 페이지로 이동이라 이렇게 나오는거지/.... doF는 호출 안 됨
		
		// doE() -> doF() -> doF.jsp 이렇게 가고 싶다고~~`
		//   주소도 바뀌고 + 화면도 바뀌고.. == sendRedirect = true!!!!!!!
//		return "redirect:/doF";
		// 주소줄에 http://localhost:8080/web/doE -> 입력해서 들어가면~~~
			// 주소줄 http://localhost:8080/web/doF로 나오고~~ 
			// 404 에러   메시지 파일 [/WEB-INF/views/doF.jsp]을(를) 찾을 수 없습니다.
		// 콘솔창
//		INFO : com.itwillbs.web.SampleController4 - (♥♥♥♥♥ doE) /doE 주소 호출 -> doE() 실행
//		INFO : com.itwillbs.web.SampleController4 - (♥♥♥♥♥ doF) /doF 주소 호출 -> doF() 실행 -> 리턴값 void니까 views/doF.jsp 호출
		// doE(), doF() 둘 다 실행된거다!!! 오우 예~~
		
		
		// forward도 되나요? ㅇㅇ
		// 주소는 변경 X, 화면은 변경 O
//		return "forward:/doF"; 
		// 콘솔창
//		INFO : com.itwillbs.web.SampleController4 - (♥♥♥♥♥ doE) /doE 주소 호출 -> doE() 실행
//		INFO : com.itwillbs.web.SampleController4 - (♥♥♥♥♥ doF) /doF 주소 호출 -> doF() 실행 -> 리턴값 void니까 views/doF.jsp 호출
//		주소 줄에는 http://localhost:8080/web/doE 그대로고
//		  404 에러는 메시지 파일 [/WEB-INF/views/doF.jsp]을(를) 찾을 수 없습니다.

		// 페이지 이동+ 정보 전달 
		// 방법1. 물음표로 주소줄에 직접 보내기
//		return "redirect:/doF?msg=itwill";
				// http://localhost:8080/web/doE?msg=itwill    E에서 -> F로 redirect로 이동할 때, msg도 함께 보내보자~~~~
		
		
		// 페이지 이동+ 정보 전달 
		// 방법2. model 객체 써서,, 파라메타에 안 붙여 보내도,,,, 전달 쌉가~~ 주소줄에는 ?msg=busan 뜨넴^^
//		model.addAttribute("msg", "busan");
//		return "redirect:/doF";
		
		
		// 페이지 이동+ 정보 전달 
		// 방법3. RedirectAttributes rttr 이 객체 써서,, 보내면? 주소줄에 ?msg=spring 안 뜨게 하면서 보낼 수 있다!!
		rttr.addFlashAttribute("msg", "spring~~🌈🌈");
		return "redirect:/doF";
		
	}// doE 끝
	
	
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) { // E에서 msg 함께 보냈으니 그거 받고~~
		log.info("(♥♥♥♥♥ doF) /doF 주소 호출 -> doF() 실행 -> 리턴값 void니까 views/doF.jsp 호출");
		log.info("(♥♥♥♥♥ doF) 전달받은 msg: " + msg);
		
	}
	
	
}
