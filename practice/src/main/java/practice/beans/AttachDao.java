package practice.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.util.JdbcUtil;

public class AttachDao {
	//등록 메소드
	//- 파일명으로 번호를 써야하므로 번호 생성과 등록을 분리하여 개발
	public int sequence() throws ClassNotFoundException, SQLException {
		String sql = "select attach_seq.nextval from dual";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		int number = rs.next() ? rs.getInt("NEXTVAL") : 1;
		JdbcUtil.close(ps);
		return number;
	}
	public void insert(AttachDto attachDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into attach("
						+ "attach_no, attach_name, "
						+ "attach_type, attach_size"
					+ ") values(?, ?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, attachDto.getAttachNo());
		ps.setString(2, attachDto.getAttachName());
		ps.setString(3, attachDto.getAttachType());
		ps.setLong(4, attachDto.getAttachSize());
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	
	//전체 목록(연습용)
	public List<AttachDto> selectList() throws ClassNotFoundException, SQLException {
		String sql = "select * from attach order by attach_no asc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		List<AttachDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	private List<AttachDto> convert(ResultSet rs) throws SQLException {
		List<AttachDto> list = new ArrayList<>();
		while(rs.next()) {
			AttachDto attachDto = new AttachDto();
			attachDto.setAttachNo(rs.getInt("attach_no"));
			attachDto.setAttachName(rs.getString("attach_name"));
			attachDto.setAttachType(rs.getString("attach_type"));
			attachDto.setAttachSize(rs.getLong("attach_size"));
			list.add(attachDto);
		}
		return list;
	}
	
	//상세
	public AttachDto selectOne(int attachNo) throws ClassNotFoundException, SQLException {
		String sql = "select * from attach where attach_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, attachNo);
		ResultSet rs = ps.executeQuery();
		List<AttachDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list.isEmpty() ? null : list.get(0);//없으면 null 있으면 맨앞(0) 데이터 반환
	}
}









