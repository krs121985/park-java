package home.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import home.beans.AttachDao;
import home.beans.AttachDto;
import jakarta.servlet.http.Part;

//첨부파일은 DB와 파일 작업이 동시에 일어나니 이걸 하나로 묶어서 메소드 화 시키겠다!
public class AttachService {
	
	public int save(Part attach) throws ClassNotFoundException, SQLException, IOException {
		//DB 저장
		AttachDao attachDao = new AttachDao();
		int attachNo = attachDao.sequence();//번호 생성 (향후 파일명이 됨)
		
		//정보 설정
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo);//생성된 파일번호
		attachDto.setAttachName(attach.getSubmittedFileName());//전송된 파일명
		attachDto.setAttachType(attach.getContentType());//전송된 파일유형
		attachDto.setAttachSize(attach.getSize());//전송된 파일크기
		
		attachDao.insert(attachDto);//최종 등록
		
		//실물 파일 저장
		// - window인 경우 C:/Users/PC계정명 을 의미
		// - mac이나 리눅스인 경우 /usr/home 을 의미
		String userHome = System.getProperty("user.home");
		File dir = new File(userHome, "upload");
		dir.mkdirs();//혹시 없으면 폴더를 생성하세요!
		File target = new File(dir, String.valueOf(attachNo));//파일번호로 파일생성준비
		attach.write(target.getAbsolutePath());//target의 실제 위치에 저장하세요!
		
		return attachNo;
	}
	
	public void delete(int attachNo) throws ClassNotFoundException, SQLException {
		//DB삭제
		AttachDao attachDao = new AttachDao();
		attachDao.delete(attachNo);
		
		//파일삭제
		String userHome = System.getProperty("user.home");
		File dir = new File(userHome, "upload");
		if(dir.exists() == false) return;//폴더가 없으면 중지
		File target = new File(dir, String.valueOf(attachNo));//파일번호로 파일삭제준비
		target.delete();//파일 삭제
	}
	
}








