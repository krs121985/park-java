package home.servlet.book;

import java.io.IOException;

import home.beans.BookDao;
import home.service.AttachService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/book/delete.do")
public class BookDeleteServlet extends  HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			BookDao bookDao = new BookDao();
			
			//(+추가) 파일이 있다면 제거해야 한다
			int attachNo = bookDao.findImage(bookNo);//없으면 -1 나오게 되어있음
			if(attachNo != -1) {//이미지 있음
				AttachService attachService = new AttachService();
				attachService.delete(attachNo);
			}
			
			boolean result = bookDao.delete(bookNo); 
			resp.sendRedirect("./list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
