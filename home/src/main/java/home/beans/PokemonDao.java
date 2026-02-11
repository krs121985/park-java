package home.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.util.JdbcUtil;

//DAO
//- Data Access Object
//- 데이터베이스 접근 객체
//- Pokemon 테이블에 접근하기 위한 각종 코드를 메소드로 보관
public class PokemonDao {
	//등록 메소드
	public int sequence() throws ClassNotFoundException, SQLException {
		String sql = "select pokemon_seq.nextval from dual";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		int number = rs.next() ? rs.getInt("NEXTVAL") : 1;
		JdbcUtil.close(ps);
		return number;
	}
	public void insert(PokemonDto pokemonDto) throws ClassNotFoundException, SQLException {//권장하는 방식
		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type) "
								+ "values(?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pokemonDto.getPokemonNo());
		ps.setString(2, pokemonDto.getPokemonName());
		ps.setString(3, pokemonDto.getPokemonType());
		
		ps.executeUpdate();
		
		JdbcUtil.close(ps);
	}
	
	//조회 메소드
	//- 데이터베이스 연결이 끊어지기 전에 ResultSet에 담긴 데이터를 List<PokemonDto>로 이동 후 반환
	public List<PokemonDto> selectList() throws ClassNotFoundException, SQLException {
		String sql = "select * from pokemon order by pokemon_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		
		//ResultSet이 사용 불가로 변하기 전에 내부에 있는 데이터를 뽑아내서 List<PokemonDto>로 만들자!
		//1.비어있는 List를 생성한다.
		List<PokemonDto> list = new ArrayList<>();
		//2.데이터가 존재한다면 계속해서 List로 옮겨담는다
		while(rs.next()) {
			PokemonDto pokemonDto = new PokemonDto();
			//rs의 데이터를 pokemonDto에 옮겨담고
			pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
			pokemonDto.setPokemonName(rs.getString("pokemon_name"));
			pokemonDto.setPokemonType(rs.getString("pokemon_type"));
			list.add(pokemonDto);
		}
		
		JdbcUtil.close(ps);
		//3.변환된 데이터를 반환한다
		return list;
	}
	
	//검색 메소드
	//- 데이터베이스 연결이 끊어지기 전에 ResultSet에 담긴 데이터를 List<PokemonDto>로 이동 후 반환
	public List<PokemonDto> selectList(String keyword) throws ClassNotFoundException, SQLException {
		//keyword가 없으면 목록을 반환해!
		if(keyword == null) return selectList();
		
		String sql = "select * from pokemon where pokemon_name = ? order by pokemon_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		//ResultSet이 사용 불가로 변하기 전에 내부에 있는 데이터를 뽑아내서 List<PokemonDto>로 만들자!
		//1.비어있는 List를 생성한다.
		List<PokemonDto> list = new ArrayList<>();
		//2.데이터가 존재한다면 계속해서 List로 옮겨담는다
		while(rs.next()) {
			PokemonDto pokemonDto = new PokemonDto();
			//rs의 데이터를 pokemonDto에 옮겨담고
			pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
			pokemonDto.setPokemonName(rs.getString("pokemon_name"));
			pokemonDto.setPokemonType(rs.getString("pokemon_type"));
			list.add(pokemonDto);
		}
		
		JdbcUtil.close(ps);
		//3.변환된 데이터를 반환한다
		return list;
	}
	
	//컬럼-키워드 검색 메소드
	//- SQL 구문 작성 시 홀더(?)는 데이터 자리에만 사용한다. 자료형이나 특수문자등을 처리해주기 때문
	//- column같은 경우는 데이터가 아니라 구문의 일부이므로 직접 넣어야 에러가 없다 (공격이 불가능)
	public List<PokemonDto> selectList(String column, String keyword) throws ClassNotFoundException, SQLException {
		//만약 컬럼, 키워드 중 하나라도 없으면 목록으로 대체한다
		if(column == null || keyword == null) return selectList();
		
		String sql = "select * from pokemon where instr("+column+", ?) > 0 order by pokemon_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		//ResultSet이 사용 불가로 변하기 전에 내부에 있는 데이터를 뽑아내서 List<PokemonDto>로 만들자!
		//1.비어있는 List를 생성한다.
		List<PokemonDto> list = new ArrayList<>();
		//2.데이터가 존재한다면 계속해서 List로 옮겨담는다
		while(rs.next()) {
			PokemonDto pokemonDto = new PokemonDto();
			//rs의 데이터를 pokemonDto에 옮겨담고
			pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
			pokemonDto.setPokemonName(rs.getString("pokemon_name"));
			pokemonDto.setPokemonType(rs.getString("pokemon_type"));
			list.add(pokemonDto);
		}
		
		JdbcUtil.close(ps);
		//3.변환된 데이터를 반환한다
		return list;
	}
	
	//상세 메소드
	//- 기본키(Primary key)를 이용하여 단 하나의 데이터를 조회하는 메소드
	//- 단, 데이터는 없을 수 있으며 없는 경우는 null을 반환한다
	public PokemonDto selectOne(int pokemonNo) throws ClassNotFoundException, SQLException {
		String sql = "select * from pokemon where pokemon_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pokemonNo);
		
		ResultSet rs = ps.executeQuery();//조회용 명령(목록과 동일), 하지만 결과는 0 또는 1개
		
		PokemonDto pokemonDto;
		if(rs.next()) {//다음 데이터가 있다면
			pokemonDto = new PokemonDto();
			//rs의 데이터를 pokemonDto에 옮겨담고
			pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
			pokemonDto.setPokemonName(rs.getString("pokemon_name"));
			pokemonDto.setPokemonType(rs.getString("pokemon_type"));
		}
		else {//다음 데이터가 없다면
			pokemonDto = null;
		}
		JdbcUtil.close(ps);
		return pokemonDto;
	}
	
	//수정 메소드
	//- 실행이 되더라도 수정이 안될 수가 있다
	//- 실행 후 적용된 행의 개수를 가져와서 실제 수정이 이루어졌는지 판정해야 한다
	//- 진짜 수정되었으면 true를 반환, 진짜 수정이 이루어지지 않았으면 false를 반환하도록 처리
	public boolean update(PokemonDto pokemonDto) throws ClassNotFoundException, SQLException {
		String sql = "update pokemon "
					+ "set pokemon_name=?, pokemon_type=? "
					+ "where pokemon_no=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pokemonDto.getPokemonName());
		ps.setString(2, pokemonDto.getPokemonType());
		ps.setInt(3, pokemonDto.getPokemonNo());
		int count = ps.executeUpdate();//적용 행 수를 실행 후 가져온다
		JdbcUtil.close(ps);//마무리 정리하고
		return count > 0;//적용 행이 존재하는지 판정해서 반환
	}
	
	//삭제 메소드
	//- 실행이 되더라도 삭제는 안될 수가 있다
	//- 실행 후 적용된 행의 개수를 가져와서 실제 삭제가 이루어졌는지 판정해야 한다
	//- 진짜 삭제가 되었으면 true를 반환, 진짜 삭제가 이루어지지 않았으면 false를 반환하도록 처리
	public boolean delete(int pokemonNo) throws ClassNotFoundException, SQLException {
		String sql = "delete pokemon where pokemon_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pokemonNo);
		int count = ps.executeUpdate();//실행 후 실제 지워진 행의 개수를 가져온다
		JdbcUtil.close(ps);//마무리 정리하고
		return count > 0;//count가 0보다 큰지 판정해서 반환! (=성공했는지 판정해서 반환)
	}
	
	//페이징을 위한 메소드
	private List<PokemonDto> convert(ResultSet rs) throws SQLException {
		//ResultSet이 사용 불가로 변하기 전에 내부에 있는 데이터를 뽑아내서 List<PokemonDto>로 만들자!
		//1.비어있는 List를 생성한다.
		List<PokemonDto> list = new ArrayList<>();
		//2.데이터가 존재한다면 계속해서 List로 옮겨담는다
		while(rs.next()) {
			PokemonDto pokemonDto = new PokemonDto();
			//rs의 데이터를 pokemonDto에 옮겨담고
			pokemonDto.setPokemonNo(rs.getInt("pokemon_no"));
			pokemonDto.setPokemonName(rs.getString("pokemon_name"));
			pokemonDto.setPokemonType(rs.getString("pokemon_type"));
			list.add(pokemonDto);
		}
		rs.close();
		return list;
	}
	private List<PokemonDto> list(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from pokemon order by pokemon_no asc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pageVO.getStartRownum());
		ps.setInt(2, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<PokemonDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	public List<PokemonDto> selectListByPaging(PageVO pageVO) throws ClassNotFoundException, SQLException {
		if(pageVO.isList()) return list(pageVO);
		
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from pokemon "
							+ "where instr("+pageVO.getColumn()+", ?) > 0 "
							+ "order by pokemon_no asc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ps.setInt(2, pageVO.getStartRownum());
		ps.setInt(3, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<PokemonDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
	private int countList(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) cnt from pokemon";
		PreparedStatement ps = JdbcUtil.getWorker(sql);		
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	public int count(PageVO pageVO) throws ClassNotFoundException, SQLException {
		if(pageVO.isList()) return countList(pageVO);
		
		String sql = "select count(*) cnt from pokemon "
					+ "where instr("+pageVO.getColumn()+", ?) > 0";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	
	//첨부파일 연결
	public void connect(int pokemonNo, int attachNo) throws ClassNotFoundException, SQLException {
		String sql = "insert into pokemon_image(pokemon_no, attach_no) values(?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pokemonNo);
		ps.setInt(2, attachNo);
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//첨부파일 번호찾기
	public int findImage(int pokemonNo) throws ClassNotFoundException, SQLException {
		String sql = "select attach_no from pokemon_image where pokemon_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pokemonNo);
		ResultSet rs = ps.executeQuery();
		int attachNo = rs.next() ? rs.getInt("attach_no") : -1;//없으면 -1 (정해둔 약속)
		JdbcUtil.close(ps);
		return attachNo;
	}
}













