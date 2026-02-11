package practice.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.util.JdbcUtil;

public class LectureDao {
	//조회 메소드
	public List<LectureDto> selectList() throws ClassNotFoundException, SQLException {
		String sql = "select * from lecture order by lecture_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<LectureDto> list = new ArrayList<>();
		while(rs.next()) {
			LectureDto lectureDto = new LectureDto();
			lectureDto.setLectureNo(rs.getInt("lecture_no"));
			lectureDto.setLectureSubject(rs.getString("lecture_subject"));
			lectureDto.setLectureCategory(rs.getString("lecture_category"));
			lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
			lectureDto.setLecturePrice(rs.getInt("lecture_price"));
			lectureDto.setLectureType(rs.getString("lecture_type"));
			list.add(lectureDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	//검색 메소드
	public List<LectureDto> selectList(String keyword) throws ClassNotFoundException, SQLException {
		if(keyword == null) return selectList();
		
		//String sql = "select * from lecture where lecture_subject = ? order by lecture_no asc";
		String sql = "select * from lecture where instr(lecture_subject, ?) > 0 order by lecture_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		List<LectureDto> list = new ArrayList<>();
		while(rs.next()) {
			LectureDto lectureDto = new LectureDto();
			lectureDto.setLectureNo(rs.getInt("lecture_no"));
			lectureDto.setLectureSubject(rs.getString("lecture_subject"));
			lectureDto.setLectureCategory(rs.getString("lecture_category"));
			lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
			lectureDto.setLecturePrice(rs.getInt("lecture_price"));
			lectureDto.setLectureType(rs.getString("lecture_type"));
			list.add(lectureDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	//컬럼+키워드 검색 메소드
	public List<LectureDto> selectList(String column, String keyword) throws ClassNotFoundException, SQLException {
		if(column == null || keyword == null) return selectList();
		
		String sql = "select * from lecture where instr("+column+", ?) > 0 order by lecture_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		
		List<LectureDto> list = new ArrayList<>();
		while(rs.next()) {
			LectureDto lectureDto = new LectureDto();
			lectureDto.setLectureNo(rs.getInt("lecture_no"));
			lectureDto.setLectureSubject(rs.getString("lecture_subject"));
			lectureDto.setLectureCategory(rs.getString("lecture_category"));
			lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
			lectureDto.setLecturePrice(rs.getInt("lecture_price"));
			lectureDto.setLectureType(rs.getString("lecture_type"));
			list.add(lectureDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	//상세 메소드
	public LectureDto selectOne(int lectureNo) throws ClassNotFoundException, SQLException {
		String sql = "select * from lecture where lecture_no=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, lectureNo);
		ResultSet rs = ps.executeQuery();
		
		LectureDto lectureDto;
		if(rs.next()) {//존재한다면
			lectureDto = new LectureDto();
			lectureDto.setLectureNo(rs.getInt("lecture_no"));
			lectureDto.setLectureSubject(rs.getString("lecture_subject"));
			lectureDto.setLectureCategory(rs.getString("lecture_category"));
			lectureDto.setLectureDuration(rs.getInt("lecture_duration"));
			lectureDto.setLecturePrice(rs.getInt("lecture_price"));
			lectureDto.setLectureType(rs.getString("lecture_type"));
		}
		else {//없다면
			lectureDto = null;
		}
		JdbcUtil.close(ps);
		return lectureDto;
	}
}











