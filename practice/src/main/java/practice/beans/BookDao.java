package practice.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.util.JdbcUtil;

//Book 테이블에 각종 처리를 하기 위한 메소드를 가진 클래스
public class BookDao {
	//조회 메소드
	public List<BookDto> selectList() throws ClassNotFoundException, SQLException {
		String sql = "select * from book order by book_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		
		ResultSet rs = ps.executeQuery();
		
		//ResultSet을 List<BookDto>에 옮겨담는 코드
		List<BookDto> list = new ArrayList<>();
		while(rs.next()) {
			BookDto bookDto = new BookDto();
			bookDto.setBookNo(rs.getInt("book_no"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setBookPagecount(rs.getInt("book_pagecount"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookStatus(rs.getString("book_status"));
			list.add(bookDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//검색 메소드
	public List<BookDto> selectList(String keyword) throws ClassNotFoundException, SQLException {
		//검색어가 없으면 아무것도 안나오게 하는 코드
		//if(keyword == null) return new ArrayList<>();
		
		//검색어가 없으면 목록이 나오도록 하는 코드
		if(keyword == null) return selectList();
		
		String sql = "select * from book "
						+ "where book_title = ? "
						+ "order by book_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		//ResultSet을 List<BookDto>에 옮겨담는 코드
		List<BookDto> list = new ArrayList<>();
		while(rs.next()) {
			BookDto bookDto = new BookDto();
			bookDto.setBookNo(rs.getInt("book_no"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setBookPagecount(rs.getInt("book_pagecount"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookStatus(rs.getString("book_status"));
			list.add(bookDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//컬럼 키워드 검색 메소드
	public List<BookDto> selectList(String column, String keyword) throws ClassNotFoundException, SQLException {
		if(column == null || keyword == null) return selectList();
//		if(column == null || keyword == null) return new ArrayList<>();
		
		String sql = "select * from book where instr("+column+", ?) > 0 order by book_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		//ResultSet을 List<BookDto>에 옮겨담는 코드
		List<BookDto> list = new ArrayList<>();
		while(rs.next()) {
			BookDto bookDto = new BookDto();
			bookDto.setBookNo(rs.getInt("book_no"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setBookPagecount(rs.getInt("book_pagecount"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookStatus(rs.getString("book_status"));
			list.add(bookDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//상세 메소드
	public BookDto selectOne(int bookNo) throws ClassNotFoundException, SQLException {
		String sql = "select * from book where book_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		BookDto bookDto;
		if(rs.next()) {
			bookDto = new BookDto();
			bookDto.setBookNo(rs.getInt("book_no"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setBookPagecount(rs.getInt("book_pagecount"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookStatus(rs.getString("book_status"));
		}
		else {
			bookDto = null;
		}
		JdbcUtil.close(ps);
		return bookDto;
	}
}






















