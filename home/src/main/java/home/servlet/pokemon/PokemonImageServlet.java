package home.servlet.pokemon;

import java.io.IOException;

import home.beans.PokemonDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//포켓몬 번호를 받아서 해당하는 첨부파일 이미지를 반환하는 서블릿
@WebServlet(urlPatterns = "/views/pokemon/image.do")
public class PokemonImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//포켓몬 번호를 받는다
			int pokemonNo = Integer.parseInt(req.getParameter("pokemonNo"));
			
			//첨부파일 번호를 구한다 (없으면 -1로 처리)
			PokemonDao pokemonDao = new PokemonDao();
			int attachNo = pokemonDao.findImage(pokemonNo);//포켓몬번호 → 첨부파일번호
			if(attachNo == -1) throw new Exception();//이미지가 없으면 예외처리
			
			resp.sendRedirect("/home/download.do?attachNo="+attachNo);
		}
		catch(Exception e) {
			//에러의 원인은 이미지 로딩 실패 (없을 수도 있고 기타 등등)
			resp.sendRedirect("/home/resources/images/no-image.png");
		}
	}
}
