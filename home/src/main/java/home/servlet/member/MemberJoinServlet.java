package home.servlet.member;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import home.beans.MemberDao;
import home.beans.MemberDto;
import home.service.AttachService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = "/views/member/join.do")
@MultipartConfig(maxRequestSize = 10L*1024L*1024L, maxFileSize = 10L*1024L*1024L)
public class MemberJoinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDto memberDto = new MemberDto();
			BeanUtils.populate(memberDto, req.getParameterMap());
			
			MemberDao memberDao = new MemberDao();
			memberDao.insert(memberDto);
			
			Part attach = req.getPart("attach");
			if(attach != null && attach.getSize() > 0) {
				AttachService attachService = new AttachService();
				int attachNo = attachService.save(attach);
				
				memberDao.connect(memberDto.getMemberId(), attachNo);
			}
			
			resp.sendRedirect("./joinResult.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
