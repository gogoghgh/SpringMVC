package com.itwillbs.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	// 멤버변수 ================================
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	// 멤버변수 ================================
	
	
	// fileUploadGET()
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String fileUploadGET() {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadGET() 호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadGET() 리턴타입 String -> uploadForm.jsp로 이동");
		return "uploadForm";
	}
	// fileUploadGET() 끝
	
	
	// fileUploadPOST()
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUploadPOST(MultipartHttpServletRequest multi) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST() 호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  multi,, 뭘까?: " + multi);
		
		// 파일의 정보를 저장하는 Map
		Map map = new HashMap();
		
		Enumeration enu = multi.getParameterNames();
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  Enumeration: " + enu);
		
		while(enu.hasMoreElements()) {
			// 들어있는 다음 요소를 꺼낼 것이다 -> 꺼내서 변수 name에 담기.. (전달되는 파라메타들 들어있음)
			//  Key에 해당하는 정보
			String name = (String) enu.nextElement();
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  name: " + name); 
				// id, email 담아오네? 흠..
				// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  name: id
				// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  name: email
			
			// Value에 해당하는 정보
			String value = multi.getParameter(name);
			map.put(name, value);
		}
		
		// map 형태 { } 중괄호로 저장되어 있음.....  list는 [ ] 배열 형태!!
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  map: " + map); 
		// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileUploadPOST()  map: {id=ghgh, email=gh@gh.com}
		
		// ↑↑↑ =====  전달 정보(파라메타 값)을 --> map에 저장 완!!!!! ================ ↑↑↑
		
		// ↓↓↓ ===== 이제 업로드 파일 처리할 것임 =================================== ↓↓↓
		fileProcess(multi); // 밑에 메서드 호출
		
		return "result";
	}
	// fileUploadPOST() 끝
	
	
	
	// 전달된 첨부파일 처리 전용 메서드 fileProcess()
	public List<String> fileProcess(MultipartHttpServletRequest multi) throws Exception{
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 첨부파일 처리 시작");
		
		// 파일 정보를 저장하는 리스트(리턴)
		List<String> fileList = new ArrayList<String>();
		
		// 전달된 파일 정보를 받아서 처리 
		Iterator<String> fileNames = multi.getFileNames();

		while(fileNames.hasNext()) {
			
			String fileName = fileNames.next();
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() fileNames: " + fileNames);
					// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() fileNames: java.util.LinkedHashMap$LinkedKeyIterator@76b05e8a
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 파라메타 fileName: " + fileName);
					// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 파라메타 fileName: file1

			MultipartFile mFile = multi.getFile(fileName); // 업로드된 파일 정보 가져오기
			String originalFileName = mFile.getOriginalFilename();
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() original!! FileName: " + originalFileName);
					// (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() original!! FileName: KakaoTalk_20220902_165440289.jpg
			
			// 업로드 될! 파일의 이름들을 저장
			fileList.add(originalFileName);
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() fileList: " + fileList); // [ ]
			
			
			// 파일 생성 =====================
			File file = new File("C:\\springFile"+"\\"+originalFileName); 
				// 근데 여기로,, 파일 안 들어오네? 당연,, 아직은 빈 껍데기일 분입니다,,,,
			
			if(mFile.getSize() != 0) {
				// 첨부파일이 있을 때
				file.createNewFile();  // 이 과정 거쳐야 저 springFile 폴더에 첨부파일 생기네~
				log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 파일 업로오드 성공");
			}
			
		} // while
		
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧fileProcess() 첨부파일 처리 껏");
		return fileList;
	}
	// 전달된 파일 처리 전용 메서드 fileProcess() 끝
	
	
} // class FileController
