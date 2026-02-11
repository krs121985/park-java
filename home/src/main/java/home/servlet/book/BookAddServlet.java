package home.servlet.book;

import java.io.File;
import java.io.IOException;

import home.beans.AttachDao;
import home.beans.AttachDto;
import home.beans.BookDao;
import home.beans.BookDto;
import home.service.AttachService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = "/views/book/add.do")
@MultipartConfig(maxRequestSize = 10L * 1024L * 1024L , maxFileSize = 10L * 1024L * 1024L)
public class BookAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//전송되는 데이터가 몇개인지 확인해서 모두 받아야 함
			//- 도서명, 장르, 페이지수, 판매가, 대여상태 총 5가지 (번호는 안옴)
			BookDto bookDto = new BookDto();
			BookDao bookDao = new BookDao();
			int bookNo = bookDao.sequence();
			bookDto.setBookNo(bookNo);
			bookDto.setBookTitle(req.getParameter("bookTitle"));//수신이름이 input의 name과 같아야 함
			bookDto.setBookGenre(req.getParameter("bookGenre"));
			bookDto.setBookPagecount(Integer.parseInt(req.getParameter("bookPagecount")));//숫자
			bookDto.setBookPrice(Integer.parseInt(req.getParameter("bookPrice")));
			bookDto.setBookStatus(req.getParameter("bookStatus"));
			
			bookDao.insert(bookDto); 
			
			Part attach = req.getPart("attach");
			if(attach != null && attach.getSize() > 0) {
				AttachService attachService = new AttachService();
				int attachNo = attachService.save(attach);
				
				//도서번호와 파일번호를 연결
				bookDao.connect(bookNo, attachNo);
			}
			
			resp.sendRedirect("./addResult.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
