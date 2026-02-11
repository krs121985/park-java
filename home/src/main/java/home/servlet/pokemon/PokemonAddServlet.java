package home.servlet.pokemon;

import java.io.File;
import java.io.IOException;

import home.beans.AttachDao;
import home.beans.AttachDto;
import home.beans.PokemonDao;
import home.beans.PokemonDto;
import home.service.AttachService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = "/views/pokemon/add.do")
@MultipartConfig(
	maxRequestSize = 10L * 1024L * 1024L,
	maxFileSize = 10L * 1024L * 1024L
)
public class PokemonAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//사용자에게 보여주지 않는 페이지 (화면 코드가 필요없음)
			//String pokemonName = request.getParameter("pokemonName");
			//String pokemonType = request.getParameter("pokemonType");
			
			//포켓몬 등록 코드
			PokemonDto pokemonDto = new PokemonDto();
			PokemonDao pokemonDao = new PokemonDao();
			int pokemonNo = pokemonDao.sequence();//번호 생성
			pokemonDto.setPokemonNo(pokemonNo);//번호 설정
			pokemonDto.setPokemonName(request.getParameter("pokemonName"));
			pokemonDto.setPokemonType(request.getParameter("pokemonType"));
			
			pokemonDao.insert(pokemonDto);
			
			//파일 등록 코드 (존재할 경우만)
			Part attach = request.getPart("attach");
			if(attach != null && attach.getSize() > 0L) {//파일이 전송했다면
				AttachService attachService = new AttachService();
				int attachNo = attachService.save(attach);
				
				//포켓몬번호와 파일번호를 pokemon_image에 저장해서 나중에 쓸 수 있도록 연결
				pokemonDao.connect(pokemonNo, attachNo);
			}
			
			response.sendRedirect("./addResult.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}
}












