package home.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import home.util.JdbcUtil;

public class MemberDao {
	//등록
	public void insert(MemberDto memberDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into member("
						+ "member_id, member_pw, member_nickname, member_email, "
						+ "member_birth, member_post, member_address1, member_address2"
					+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberDto.getMemberId());
		ps.setString(2, memberDto.getMemberPw());
		ps.setString(3, memberDto.getMemberNickname());
		ps.setString(4, memberDto.getMemberEmail());
		ps.setString(5, memberDto.getMemberBirth());
		ps.setString(6, memberDto.getMemberPost());
		ps.setString(7, memberDto.getMemberAddress1());
		ps.setString(8, memberDto.getMemberAddress2());
		
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//목록
	//검색(컬럼+키워드)
	//상세
	public MemberDto selectOne(String memberId) throws ClassNotFoundException, SQLException {
		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();
		
		MemberDto memberDto;
		if(rs.next()) {
			memberDto = new MemberDto();
			//14개의 데이터를 옮겨담아야 한다
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNickname(rs.getString("member_nickname"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberPost(rs.getString("member_post"));
			memberDto.setMemberAddress1(rs.getString("member_address1"));
			memberDto.setMemberAddress2(rs.getString("member_address2"));
			memberDto.setMemberLevel(rs.getString("member_level"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberLogin(rs.getDate("member_login"));
			memberDto.setMemberChange(rs.getDate("member_change"));
			memberDto.setMemberBlock(rs.getString("member_block"));
		}
		else {
			memberDto = null;
		}
		JdbcUtil.close(ps);
		return memberDto;
	}
	
	//수정
	//1. 최종로그인시각 변경
	public boolean updateMemberLogin(String memberId) throws ClassNotFoundException, SQLException {
		String sql = "update member set member_login=sysdate where member_id=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	//2. 비밀번호 변경
	public boolean updateMemberPw(String memberId, String memberPw) throws ClassNotFoundException, SQLException {
		String sql = "update member set member_pw=?, member_change=sysdate where member_id=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberPw);
		ps.setString(2, memberId);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	//3. 개인정보 변경
	public boolean update(MemberDto memberDto) throws ClassNotFoundException, SQLException {
		String sql = "update member "
					+ "set "
						+ "member_nickname=?, member_email=?, member_birth=?, "
						+ "member_post=?, member_address1=?, member_address2=? "
					+ "where member_id=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberDto.getMemberNickname());
		ps.setString(2, memberDto.getMemberEmail());
		ps.setString(3, memberDto.getMemberBirth());
		ps.setString(4, memberDto.getMemberPost());
		ps.setString(5, memberDto.getMemberAddress1());
		ps.setString(6, memberDto.getMemberAddress2());
		ps.setString(7, memberDto.getMemberId());
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//삭제
	public boolean delete(String memberId) throws ClassNotFoundException, SQLException {
		String sql = "delete member where member_id=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//시청기록(activity)과 관련된 기능들
	//1. 최초 시청 시 실행할 기능
	public void insertActivity(String memberId, int boardNo) throws ClassNotFoundException, SQLException {
		String sql = "insert into activity(activity_member, activity_board) values(?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ps.setInt(2, boardNo);
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//2. 2회 이상 시청 시 실행할 기능
	public boolean updateActivity(String memberId, int boardNo) throws ClassNotFoundException, SQLException {
		String sql = "update activity set activity_time=sysdate "
					+ "where activity_member=? and activity_board=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ps.setInt(2, boardNo);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	//3. 시청 이력이 존재하는지 확인하는 기능
	public boolean checkActivity(String memberId, int boardNo) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) cnt from activity "
					+ "where activity_member=? and activity_board=?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ps.setInt(2, boardNo);
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//첨부파일 연결
	public void connect(String memberId, int attachNo) throws ClassNotFoundException, SQLException {
		String sql = "insert into member_profile(member_id, attach_no) values(?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ps.setInt(2, attachNo);
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//첨부파일 번호찾기
	public int findImage(String memberId) throws ClassNotFoundException, SQLException {
		String sql = "select attach_no from member_profile where member_id = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, memberId);
		ResultSet rs = ps.executeQuery();
		int attachNo = rs.next() ? rs.getInt("attach_no") : -1;//없으면 -1 (정해둔 약속)
		JdbcUtil.close(ps);
		return attachNo;
	}
	
}















