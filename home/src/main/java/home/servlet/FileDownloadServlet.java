package home.servlet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import home.beans.AttachDao;
import home.beans.AttachDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download.do")
public class FileDownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//목표 : 전달되는 파일번호(attachNo)를 이용하여 파일정보를 불러오고 다운로드 받도록 처리
			//- 필요한 라이브러리 : apache commons io
			
			//파라미터 수신
			int attachNo = Integer.parseInt(req.getParameter("attachNo"));
			
			//파일 정보 불러오기
			AttachDao attachDao = new AttachDao();
			AttachDto attachDto = attachDao.selectOne(attachNo);
			
			//사용자에게 정보(header)를 알려주고 파일을 불러와서 본문(body) 전송
			resp.setHeader("Content-Encoding", "UTF-8");
			resp.setHeader("Content-Length", String.valueOf(attachDto.getAttachSize()));
			resp.setHeader("Content-Type", attachDto.getAttachType());//알면
			//resp.setHeader("Content-Type", "application/octet-stream");//모르면
			resp.setHeader("Content-Disposition", 
							"attachment; filename="+attachDto.getAttachName());
			
			//파일 불러오기
			String userHome = System.getProperty("user.home");
			File dir = new File(userHome, "upload");//읽어올 파일이 있는 폴더
			File target = new File(dir, String.valueOf(attachNo));//읽어올 파일
			byte[] data = FileUtils.readFileToByteArray(target);//전부다 읽어라!
			resp.getOutputStream().write(data);//사용자에게 전부다 전송
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}









