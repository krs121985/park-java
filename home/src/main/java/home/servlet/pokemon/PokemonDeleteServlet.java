package home.servlet.pokemon;

import java.io.IOException;

import home.beans.PokemonDao;
import home.service.AttachService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//서블릿(Servlet)
//- 프로그래밍 처리에 특화된 페이지
//- JSP의 프로그래밍 코드 버전
//- (장점) 정확한 디버깅과 커스텀 처리가 가능
//- (장점) 주소를 직접 지정할 수 있으며 와일드카드 가능 (핵심 처리 도구의 가능성)
//- (단점) 화면과 관련된 처리를 하기 어려움 (ex : 템플릿페이지, fmt태그, jsp태그 등 사용 불가)

//생성 방법
//1. 상속을 통해 자격 획득 (jakarta.servlet.http.HttpServlet)
//2. 필요한 메소드를 재정의
//	- init() : 최초 1회 실행되는 메소드
//	- destroy() : 소멸 직전 1회 실행되는 메소드
//	- doGet() : GET 방식의 요청에 대한 처리 메소드
//	- doPost() : POST 방식의 요청에 대한 처리 메소드
//3. 사용자의 요청 처리 코드를 작성
//4. 등록 (web.xml 또는 @WebServlet)
@WebServlet(urlPatterns = "/views/pokemon/delete.do")
public class PokemonDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, response는 JSP에서 사용하던 도구와 동일
		try {
			int pokemonNo = Integer.parseInt(request.getParameter("pokemonNo"));//전달된 번호를 받는다
			PokemonDao pokemonDao = new PokemonDao();//포켓몬 테이블 이용을 위해 전용 도구를 생성한다

			//(+추가) 파일이 있다면 제거해야 한다
			int attachNo = pokemonDao.findImage(pokemonNo);//없으면 -1 나오게 되어있음
			if(attachNo != -1) {//이미지 있음
				AttachService attachService = new AttachService();
				attachService.delete(attachNo);
			}
			
			boolean result = pokemonDao.delete(pokemonNo);//삭제를 지시하고 결과를 받는다
			
			response.sendRedirect("./list.jsp");//목록으로 강제 이동시킨다
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}
}






