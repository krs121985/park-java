package home.servlet.book;

import java.io.IOException;

import home.beans.BookDao;
import home.beans.PokemonDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/book/cover.do")
public class BookCoverServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//도서 번호를 받는다
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			
			//첨부파일 번호를 구한다 (없으면 -1로 처리)
			BookDao bookDao = new BookDao();
			int attachNo = bookDao.findImage(bookNo);//도서번호 → 첨부파일번호
			if(attachNo == -1) throw new Exception();//이미지가 없으면 예외처리
			
			resp.sendRedirect("/home/download.do?attachNo="+attachNo);
		}
		catch(Exception e) {
			//에러의 원인은 이미지 로딩 실패 (없을 수도 있고 기타 등등)
			resp.sendRedirect("/home/resources/images/no-image.png");
		}
	}
}
