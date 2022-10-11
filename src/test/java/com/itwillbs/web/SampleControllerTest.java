package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 얘 추가!! 스프링 MVC 전용 테스트 파일이다~~~~ 라는 뜻,,, 
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"} 
					// ..spring/**/:   어떤 폴더라도~~~ 다 ㅇㅋ~~ 
					// .....  *.xml:  root-context.xml + servlet-context.xml 둘 다 포함하고 싶어서
		)
public class SampleControllerTest {
	// 컨트롤러 X, 컨트롤러의 역할을 하는 테스트 파일
	//  서버 stop 시키고 만들기!!!
	
	private static final Logger log = LoggerFactory.getLogger(SampleControllerTest.class);
	
	// 멤버 변수 구간 ==========================================
	
	// 객체 주입받기~ WebApplicationContext 인터페이스~~
	//   : 웹프로젝트 객체
	@Inject
	private WebApplicationContext waCTX;
	
	// 테스트 전용 객체 MockMvc:  브라우저에서 요청(request), 응답(response) 처리하는 객체 
	// 톰캣 실행 안 하고 컨트롤러 작동시키기 위한,, 셋팅값임
	private MockMvc mockMvc;
	
	// 멤버 변수 구간 끝 ==========================================
	
	
	
	
	@Before   // @Test 전에! 실행시킬 메서드
	public void setUp() {
		// this.mockMvc = new MockMvc(); 해야 하는데~~ MockMvc라는 객체가 없넹,,?? 흠~
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.waCTX).build(); 
						// 주입 받은 객체를 사용해서, 셋업하고, 이걸 mockMvc 객체에 넣겠다
		
		log.info("(♥♥♥♥♥ setUp) 테스트 전 사전 준비 완");
		
	} // setUp()
	
	
	
	@Test
	public void testDoA() {
		log.info("(♥♥♥♥♥ testDoA) Jnit이 실행하여 테스트 ");
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doB1"));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	} // testDoA()
	


}
