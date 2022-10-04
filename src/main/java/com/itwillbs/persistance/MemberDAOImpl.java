package com.itwillbs.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


//  @Repository: 스프링(root-context.xml)에서 이 파일을 DAO 파일로 인식하도록 설정^^ 너가 DAO야~~ 명찰 달아주는 거
				// --> 스프링이 관리하는 애면,, 파일 옆에 S 떠야하는 거 아님???? 
				// servlet-context.xml 젤 밑에 있는 코드 <context:component-scan base-package="com.itwillbs.web" /> 복사해서
				// root-context.xml 젤 밑에 붙여넣기,, 후 web -> persistance로 변경!!! 그러면 오~~ s 뜨네~~ 
				// ㄴ 이 과정이 결국....  MemberDAO dao = new MemberDAOImpl(); 이 말임!!!!!!!!!!!!!!!! 
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// DB에 관련된 동작을 수행
	
	// DB 연결 정보 필요 => 의존 관계 있네,, DB 연결하는 애랑,, DAOImpl이랑 의존하네,,,, 수군 수군,,
	//  ㄴroot-context.xml에 있지요? 네넵 
	//    근데~~~ myBatis 쓸 거니까 sqlSession 객체를 쓰자~~
	// sqlSessionFactory 객체 필요함(생성 X 주입해봅시다 OOO)
			//	private SqlSessionFactory factory = new SqlSessionFactory();..... 이렇ㄱ ㅔ했어야 할 걸~~
	// 이미 생성된 객체 (root-context.xml 에 sqlSessionFactory 객체(Bean)) 있으니까!! 걍 이거 쓰면 됨
	@Inject
	private SqlSessionFactory factory;
	
	
	public String getTime(){
		// 1. 2. DB 연결
		
		// 3. sql 작성
		
		// 4. sql 실행
		
		// 5. 데이터 처리
		SqlSession sqlSession = factory.openSession();
		
					// 쿼리 실행 시켜서 데이터 하나만 갖고 와라~,,,
		String now // String으로 자동으로 형변환 해라,,,ㅋ
		= sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
				// 이런 패키지는,, 없어요!!! 실제 경로는 아님!! 
				// 걍 외부에서 들어갈 때 구분하기 쉽게 하려고,, 이렇게 적은 것,,,, 띠용?
				// 얘를 보고 memberMapper.xml까지 찾아갈 수 있게 해줌		
		
		log.info("(♥♥♥♥♥ MemberDAOImpl_getTime) 메서드 호출 완");
		log.info("(♥♥♥♥♥ MemberDAOImpl_getTime) now: " + now);
		
		return now;
	}
}
