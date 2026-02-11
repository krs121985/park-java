package home.servlet.book;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import home.beans.BookDao;
import home.beans.BookDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/book/edit.do")
public class BookEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			사용자 화면에는 보이지 않는 수정 처리 페이지
//			BookDto bookDto = new BookDto();
//			bookDto.setBookNo(Integer.parseInt(req.getParameter("bookNo")));
//			bookDto.setBookTitle(req.getParameter("bookTitle"));
//			bookDto.setBookGenre(req.getParameter("bookGenre"));
//			bookDto.setBookPagecount(Integer.parseInt(req.getParameter("bookPagecount")));
//			bookDto.setBookPrice(Integer.parseInt(req.getParameter("bookPrice")));
//			bookDto.setBookStatus(req.getParameter("bookStatus"));
			
//			Apache BeanUtils 사용하여 자동 수신
			BookDto bookDto = new BookDto();//<jsp:useBean> 역할
			BeanUtils.populate(bookDto, req.getParameterMap());//<jsp:setProperty> 역할
			
			BookDao bookDao = new BookDao();
			boolean result = bookDao.update(bookDto); 
			
			resp.sendRedirect("./detail.jsp?bookNo="+bookDto.getBookNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}







