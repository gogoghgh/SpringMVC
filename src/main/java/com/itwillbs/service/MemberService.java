package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 1. 회원 가입
	public void memberJoin(MemberVO vo);
	
	// 2. 로그인 체크
	public MemberVO memberLogin(MemberVO vo);
	//public MemberVO memberLogin(String userid,String userpw);
	
	// 3. 회원 정보 조회
	public MemberVO memberGet(String userid);
	
}
