package practice.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import practice.beans.AttachDao;
import practice.beans.AttachDto;

@WebServlet(urlPatterns = "/12.fileupload/upload.do")
//Multipart 방식의 데이터를 처리할 것이라고 명시
@MultipartConfig(
	maxRequestSize = 10L * 1024L * 1024L,//한 번에 보낼 수 있는 최대 용량 (10MB로 설정)
	maxFileSize = 5L * 1024L * 1024L//한 파일당 최대 용량 (5MB로 설정)
)
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 수신
			String uploader = req.getParameter("uploader");//그대로 사용 가능
			//String attach = req.getParameter("attach");//파일은 명령이 다름
			Part attach = req.getPart("attach");//파일 수신 명령
			
			//파일은 하드디스크의 특정 위치에 저장하고, 파일의 정보는 DB에 저장하여 기록 (분리하여 저장)
			//- 파일의 용량이 너무 크기 때문에 DB를 아끼기 위한 선택
			//- DB에 저장하는 주요 항목 : 파일명, 파일유형, 파일크기, 업로드시각, ...
			String filename = attach.getSubmittedFileName();//사용자가 선택한 파일의 이름
			String filetype = attach.getContentType();//사용자가 선택한 파일의 유형
			long filesize = attach.getSize();//사용자가 선택한 파일의 용량(크기, byte)
			//String uuid = UUID.randomUUID().toString();//겹치지 않는 시리얼 번호 생성
			
			AttachDao attachDao = new AttachDao();
			int number = attachDao.sequence();//파일 명으로 사용할 예정
			
			System.out.println("파일명 = " + filename);
			System.out.println("파일유형 = " + filetype);
			System.out.println("파일크기 = " + filesize);
			//System.out.println("UUID = " + uuid);
			System.out.println("파일번호 = " + number);
			
			//실제 저장하기 위한 코드
			//- java.io.File 클래스로 실제 하드디스크의 특정 대상을 타겟으로 설정할 수 있다
			//- 저장할 위치에 대해 File 객체를 생성한 뒤 저장 명령을 사용
			//- 모든 운영체제에 공통적으로 존재하는 사용자 폴더 (user.home)에 upload라는 폴더를 생성한 뒤 저장
			String userHome = System.getProperty("user.home");
			System.out.println("사용자 폴더 = " + userHome);
			
			File dir = new File(userHome, "upload");
			System.out.println("업로드 폴더 = " + dir.getAbsolutePath());
			
			dir.mkdirs();//없으면 해당 위치에 폴더를 생성
			
//			File target = new File(dir, "test.png");//dir 내부에 test.png라는 파일을 타겟으로 설정
//			File target = new File(dir, filename);
//			File target = new File(dir, uuid);
			File target = new File(dir, String.valueOf(number));
			System.out.println("저장될 파일 = " + target.getAbsolutePath());
			
			attach.write(target.getAbsolutePath());//target의 위치에 파일 저장
			
			//DB 저장
			AttachDto attachDto = new AttachDto();
			attachDto.setAttachNo(number);//생성한 시퀀스번호 설정
			attachDto.setAttachName(filename);//파일명 설정
			attachDto.setAttachType(filetype);//파일유형 설정
			attachDto.setAttachSize(filesize);//파일크기 설정
			
			attachDao.insert(attachDto);//DB저장!
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}





