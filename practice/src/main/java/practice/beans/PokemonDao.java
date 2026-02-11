package practice.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.util.JdbcUtil;

//DAO
//- Data Access Object
//- 데이터베이스 접근 객체
//- Pokemon 테이블에 접근하기 위한 각종 코드를 메소드로 보관
public class PokemonDao {
	//등록 메소드
	//public void insert(String pokemonName, String pokemonType) {//비추천 방식
	public void insert(PokemonDto pokemonDto) throws ClassNotFoundException, SQLException {//권장하는 방식
		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type) "
								+ "values(pokemon_seq.nextval, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pokemonDto.getPokemonName());
		ps.setString(2, pokemonDto.getPokemonType());
		
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
	//삭제 메소드
}








