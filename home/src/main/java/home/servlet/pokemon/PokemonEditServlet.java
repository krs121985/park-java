package home.servlet.pokemon;

import java.io.IOException;

import home.beans.PokemonDao;
import home.beans.PokemonDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/views/pokemon/edit.do")
public class PokemonEditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식은 Form을 통해 전달되는 대량의 데이터를 처리할 때 사용하는 방식
		try {
			//사용자에게 표시되지 않는 수정 처리 페이지
			PokemonDto pokemonDto = new PokemonDto();//전달되는 데이터를 모아주기 위한 객체를 생성
			pokemonDto.setPokemonNo(Integer.parseInt(request.getParameter("pokemonNo")));//번호 수신
			pokemonDto.setPokemonName(request.getParameter("pokemonName"));//이름 수신
			pokemonDto.setPokemonType(request.getParameter("pokemonType"));//속성 수신
			
			PokemonDao pokemonDao = new PokemonDao();//pokemon 테이블 전담 처리 도구 생성
			boolean result = pokemonDao.update(pokemonDto);//정보를 전달하며 수정하도록 지시하고 결과를 수신
			
			response.sendRedirect("./detail.jsp?pokemonNo="+pokemonDto.getPokemonNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}
}












