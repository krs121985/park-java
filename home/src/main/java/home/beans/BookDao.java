package home.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.util.JdbcUtil;

//Book 테이블에 각종 처리를 하기 위한 메소드를 가진 클래스
public class BookDao {
//	등록 메소드
	public int sequence() throws ClassNotFoundException, SQLException {
		String sql = "select book_seq.nextval from dual";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		int number = rs.next() ? rs.getInt("NEXTVAL") : 1;
		JdbcUtil.close(ps);
		return number;
	}
	public void insert(BookDto bookDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into book("
						+ "book_no, book_title, book_genre, "
						+ "book_pagecount, book_price, book_status) "
					+ "values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, bookDto.getBookNo());
		ps.setString(2, bookDto.getBookTitle());
		ps.setString(3, bookDto.getBookGenre());
		ps.setInt(4, bookDto.getBookPagecount());
		ps.setInt(5, bookDto.getBookPrice());
		ps.setString(6, bookDto.getBookStatus());
		
		ps.executeUpdate();//ps.execute();도 가능
	}
	
	
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
	
	//수정 메소드
	public boolean update(BookDto bookDto) throws ClassNotFoundException, SQLException {
		String sql = "update book "
						+ "set book_title=?, book_genre=?, "
							+ "book_pagecount=?, book_price=?, book_status=? "
						+ "where book_no=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, bookDto.getBookTitle());
		ps.setString(2, bookDto.getBookGenre());
		ps.setInt(3, bookDto.getBookPagecount());
		ps.setInt(4, bookDto.getBookPrice());
		ps.setString(5, bookDto.getBookStatus());
		ps.setInt(6, bookDto.getBookNo());
		
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//삭제 메소드
	public boolean delete(int bookNo) throws SQLException, ClassNotFoundException {
		String sql = "delete book where book_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, bookNo);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	
	//첨부파일 연결
	public void connect(int bookNo, int attachNo) throws ClassNotFoundException, SQLException {
		String sql = "insert into book_cover(book_no, attach_no) values(?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, bookNo);
		ps.setInt(2, attachNo);
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//첨부파일 번호찾기
	public int findImage(int bookNo) throws ClassNotFoundException, SQLException {
		String sql = "select attach_no from book_cover where book_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		int attachNo = rs.next() ? rs.getInt("attach_no") : -1;//없으면 -1 (정해둔 약속)
		JdbcUtil.close(ps);
		return attachNo;
	}
}






















