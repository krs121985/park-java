package home.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.util.JdbcUtil;

public class HistoryDao {
	//등록
	public void insert(HistoryDto historyDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into history("
						+ "history_no, history_member, "
						+ "history_origin, history_agent"
					+ ") "
					+ "values(history_seq.nextval, ?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, historyDto.getHistoryMember());
		ps.setString(2, historyDto.getHistoryOrigin());
		ps.setString(3, historyDto.getHistoryAgent());
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	//조회
	//1. 개인의 로그인 이력을 최신순으로 조회
	public List<HistoryDto> selectList(String historyMember) throws ClassNotFoundException, SQLException {
		String sql = "select * from history "
					+ "where history_member=? "
					+ "order by history_no desc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, historyMember);
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//2. 전체 회원의 로그인 이력을 최신순으로 조회
	public List<HistoryDto> selectList() throws ClassNotFoundException, SQLException {
		String sql = "select * from history order by history_no desc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//3. 컬럼 키워드 검색
	public List<HistoryDto> selectList(String column, String keyword) throws ClassNotFoundException, SQLException {
		if(column == null || column.isEmpty()) return selectList();
		if(keyword == null || keyword.isEmpty()) return selectList();
		
		String sql = "select * from history "
					+ "where instr("+column+", ?) > 0 "
					+ "order by history_no desc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//4. 날짜 검색
	public List<HistoryDto> selectListByTime(String begin, String end) throws ClassNotFoundException, SQLException {
		if(begin == null || begin.isEmpty()) return selectList();
		if(end == null || end.isEmpty()) return selectList();
		
		String sql = "select * from history "
					+ "where history_time between "
						+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
						+ "and "
						+ "to_date(?||' '||'23:59:59', 'YYYY-MM-DD HH24:MI:SS') "
					+ "order by history_no desc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, begin);
		ps.setString(2, end);
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	
	//5. 종합 검색
	public List<HistoryDto> selectList(String column, String keyword, String begin, String end) throws ClassNotFoundException, SQLException {
		if(column == null || column.isEmpty()) return selectListByTime(begin, end);
		if(keyword == null || keyword.isEmpty()) return selectListByTime(begin, end);
		
		if(begin == null || begin.isEmpty()) return selectList(column, keyword);
		if(end == null || end.isEmpty()) return selectList(column, keyword);
		
		String sql = "select * from history "
					+ "where "
						+ "instr("+column+", ?) > 0 "
						+ "and "
						+ "("
							+ "history_time between "
								+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
								+ "and "
								+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
						+ ") "
					+ "order by history_no desc";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, keyword);
		ps.setString(2, begin);
		ps.setString(3, end);
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		
		JdbcUtil.close(ps);
		return list;
	}
	//6. 페이징이 추가된 검색 (PageVO 사용)
	//- 총 네 가지 상황이 존재(목록,검색,기간,검색+기간)
	public List<HistoryDto> selectListByPaging(PageVO pageVO) throws ClassNotFoundException, SQLException {
		if(pageVO.isList()) 		return list(pageVO);
		if(pageVO.isColumnSearch())	return columnSearch(pageVO);
		if(pageVO.isPeriodSearch())	return periodSearch(pageVO);

		//종합 검색
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from history "
							+ "where instr("+pageVO.getColumn()+", ?) > 0 and "
							+ "history_time between "
							+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
							+ "and "
							+ "to_date(?||' '||'23:59:59', 'YYYY-MM-DD HH24:MI:SS') "
							+ "order by history_no desc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ps.setString(2, pageVO.getBegin());
		ps.setString(3, pageVO.getEnd());
		ps.setInt(4, pageVO.getStartRownum());
		ps.setInt(5, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<HistoryDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
	private List<HistoryDto> list(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from("
							+ "select * from history order by history_no desc"
						+ ")TMP "
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pageVO.getStartRownum());
		ps.setInt(2, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		
		List<HistoryDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	private List<HistoryDto> columnSearch(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from history "
							+ "where instr("+pageVO.getColumn()+", ?) > 0 "
							+ "order by history_no desc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ps.setInt(2, pageVO.getStartRownum());
		ps.setInt(3, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<HistoryDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	private List<HistoryDto> periodSearch(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from history "
							+ "where history_time between "
							+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
							+ "and "
							+ "to_date(?||' '||'23:59:59', 'YYYY-MM-DD HH24:MI:SS') "
							+ "order by history_no desc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getBegin());
		ps.setString(2, pageVO.getEnd());
		ps.setInt(3, pageVO.getStartRownum());
		ps.setInt(4, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<HistoryDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
	//ResultSet을 List<HistoryDto>로 변환하는 메소드
	private List<HistoryDto> convert(ResultSet rs) throws SQLException {
		List<HistoryDto> list = new ArrayList<>();
		while(rs.next()) {//rs를 list에 옮겨담는 반복문
			HistoryDto historyDto = new HistoryDto();
			historyDto.setHistoryNo(rs.getInt("history_no"));
			historyDto.setHistoryMember(rs.getString("history_member"));
			historyDto.setHistoryTime(rs.getDate("history_time"));
			historyDto.setHistoryOrigin(rs.getString("history_origin"));
			historyDto.setHistoryAgent(rs.getString("history_agent"));
			list.add(historyDto);
		}
		rs.close();//생략 가능
		return list;
	}
	
	//상황에 맞는 데이터 개수(카운트)를 구하는 메소드
	public int count(PageVO pageVO) throws ClassNotFoundException, SQLException {
		if(pageVO.isList()) 		return listCount(pageVO);
		if(pageVO.isColumnSearch())	return columnSearchCount(pageVO);
		if(pageVO.isPeriodSearch())	return periodSearchCount(pageVO);
		
		String sql = "select count(*) from history "
					+ "where instr("+pageVO.getColumn()+",?) > 0 "
						+ "and history_time between "
						+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
						+ "and "
						+ "to_date(?||' '||'23:59:59', 'YYYY-MM-DD HH24:MI:SS')";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ps.setString(2, pageVO.getBegin());
		ps.setString(3, pageVO.getEnd());
		ResultSet rs = ps.executeQuery();//count 역시 조회 명령
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	public int listCount(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) cnt from history";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();//count 역시 조회 명령
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	public int columnSearchCount(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) cnt from history "
					+ "where instr("+pageVO.getColumn()+",?) > 0";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	public int periodSearchCount(PageVO pageVO) throws ClassNotFoundException, SQLException {
		String sql = "select count(*) from history "
					+ "where history_time between "
						+ "to_date(?||' '||'00:00:00', 'YYYY-MM-DD HH24:MI:SS') "
						+ "and "
						+ "to_date(?||' '||'23:59:59', 'YYYY-MM-DD HH24:MI:SS')";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getBegin());
		ps.setString(2, pageVO.getEnd());
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
}












