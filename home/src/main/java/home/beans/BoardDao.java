package home.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.util.JdbcUtil;

public class BoardDao {
	
	//등록 : 시퀀스 생성과 등록을 분리하여 작성 (완료 페이지가 상세 페이지이기 때문)
	public int sequence() throws ClassNotFoundException, SQLException {
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		int number = rs.next() ? rs.getInt("nextval") : 1;
		JdbcUtil.close(ps);
		return number;
	}
	//(주의) insert에서 sequence 생성을 하면 안된다
	public void insert(BoardDto boardDto) throws ClassNotFoundException, SQLException {
		String sql = "insert into board("
						+ "board_no, board_head, board_title, "
						+ "board_content, board_writer, "
						+ "board_group, board_parent, board_depth"
					+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, boardDto.getBoardNo());
		ps.setString(2, boardDto.getBoardHead());
		ps.setString(3, boardDto.getBoardTitle());
		ps.setString(4, boardDto.getBoardContent());
		ps.setString(5, boardDto.getBoardWriter());
		ps.setInt(6, boardDto.getBoardGroup());
		ps.setObject(7, boardDto.getBoardParent());
		ps.setInt(8, boardDto.getBoardDepth());
		ps.executeUpdate();
		JdbcUtil.close(ps);
	}
	
	//조회와 카운트
	private List<BoardDto> convert(ResultSet rs) throws SQLException {
		List<BoardDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHead(rs.getString("board_head"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			try {
				boardDto.setBoardContent(rs.getString("board_content"));//없을 수 있음(예외)
			}
			catch(Exception e) {/*아무것도 안함*/}
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			boardDto.setBoardWtime(rs.getDate("board_wtime"));
			boardDto.setBoardEtime(rs.getDate("board_etime"));
			//답변형 게시판 추가 항목
			boardDto.setBoardGroup(rs.getInt("board_group"));
			//boardDto.setBoardParent(rs.getInt("board_parent"));//null이 0으로 바뀌어서 나옴
			boardDto.setBoardParent(rs.getObject("board_parent", Integer.class));//null 가능
			boardDto.setBoardDepth(rs.getInt("board_depth"));
			list.add(boardDto);
		}
		rs.close();
		return list;
	}
	//(주의) 게시글 목록에서는 내용을 조회할 필요가 없으므로 이를 항목에서 제거하여 성능 향상을 노린다
	private List<BoardDto> list(PageVO pageVO) throws ClassNotFoundException, SQLException {//목록 조회
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							//+ "select * from board_list order by board_no desc"//기존 정렬
							+ "select * from board_list "
							+ "connect by prior board_no = board_parent "
							+ "start with board_parent is null "
							+ "order siblings by board_group desc, board_no asc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, pageVO.getStartRownum());
		ps.setInt(2, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<BoardDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	public List<BoardDto> selectList(PageVO pageVO) throws ClassNotFoundException, SQLException {//검색 조회
		if(pageVO.isList()) return list(pageVO);
		
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							//+ "select * from board_list "
							//+ "where instr("+pageVO.getColumn()+", ?) > 0 "
							//+ "order by board_no desc"
							+ "select * from board_list "
							+ "where instr("+pageVO.getColumn()+", ?) > 0 "
							+ "connect by prior board_no = board_parent "
							+ "start with board_parent is null "
							+ "order siblings by board_group desc, board_no asc"
						+ ")TMP"
					+ ") where rn between ? and ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ps.setInt(2, pageVO.getStartRownum());
		ps.setInt(3, pageVO.getFinishRownum());
		ResultSet rs = ps.executeQuery();
		List<BoardDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
	private int listCount(PageVO pageVO) throws ClassNotFoundException, SQLException {//목록 카운트
		String sql = "select count(*) cnt from board";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	public int count(PageVO pageVO) throws ClassNotFoundException, SQLException {//검색 카운트
		if(pageVO.isList()) return listCount(pageVO);
		
		String sql = "select count(*) cnt from board "
					+ "where instr("+pageVO.getColumn()+", ?) > 0";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, pageVO.getKeyword());
		ResultSet rs = ps.executeQuery();
		int count = rs.next() ? rs.getInt("cnt") : 0;
		JdbcUtil.close(ps);
		return count;
	}
	
	//상세조회
	public BoardDto selectOne(int boardNo) throws ClassNotFoundException, SQLException {
		String sql = "select * from board where board_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();
		//convert를 쓰고 싶은데 가능한가? 가능하지만 결과를 후가공해야함
		List<BoardDto> list = convert(rs);//목록으로 달라고 한다 (어짜피 안에는 1개 아니면 0개)
		JdbcUtil.close(ps);//정리할거 정리하고
		//return list;//이건 안되니까
		return list.isEmpty() ? null : list.get(0);//비어있으면 null, 아니면 맨 앞 데이터 반환
	}
	
	//수정
	public boolean update(BoardDto boardDto) throws ClassNotFoundException, SQLException {
		String sql = "update board set "
						+ "board_head=?, board_title=?, "
						+ "board_content=?, board_etime=sysdate "
					+ "where board_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, boardDto.getBoardHead());
		ps.setString(2, boardDto.getBoardTitle());
		ps.setString(3, boardDto.getBoardContent());
		ps.setInt(4, boardDto.getBoardNo());
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//삭제
	public boolean delete(int boardNo) throws ClassNotFoundException, SQLException {
		String sql = "delete board where board_no = ?";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, boardNo);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
	//응용 : 공지사항만 조회하는 메소드
	public List<BoardDto> selectNoticeList() throws ClassNotFoundException, SQLException {
//		뷰(view)가 없을 때
//		String sql = "select "
//						+ "board_no, board_head, board_title, board_writer, "
//						+ "board_read, board_reply, board_like, board_wtime, board_etime "
//					+ "from board "
//					+ "where board_head = '공지' "
//					+ "order by board_no desc";
		
//		뷰(view)를 생성했을 때... (데이터베이스에 뷰를 생성하고 난 이후)
		String sql = "select * from board_notice order by board_no desc";
		
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ResultSet rs = ps.executeQuery();
		List<BoardDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
//	응용 : 조회수 1증가 메소드
	public boolean updateBoardRead(int boardNo, String memberId) throws ClassNotFoundException, SQLException {
//		비회원은 조회수 증가 대상에서 제외 (주석처리하면 비회원도 증가 가능)
//		if(memberId == null) return false;
		
		String sql = "update board "
					+ "set board_read = board_read+1 "
					+ "where board_no = ? and board_writer != nvl(?, 'fake id')";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setInt(1, boardNo);
		ps.setString(2, memberId);
		int count = ps.executeUpdate();
		JdbcUtil.close(ps);
		return count > 0;
	}
	
//	특정 회원이 시청한 게시글 정보 조회
	public List<BoardDto> selectActivity(String activityMember) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from board "
							+ "where board_no in ("
								+ "select activity_board from activity "
								+ "where activity_member=?"
							+ ") "
							+ "order by board_no desc"
						+ ")TMP"
					+ ") where rn between 1 and 10";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, activityMember);
		ResultSet rs = ps.executeQuery();
		List<BoardDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
	
//	특정 회원이 작성자인 게시글 정보 조회
	public List<BoardDto> selectListByBoardWriter(String boardWriter) throws ClassNotFoundException, SQLException {
		String sql = "select * from ("
						+ "select rownum rn, TMP.* from ("
							+ "select * from board "
							+ "where board_writer=? "
							+ "order by board_no desc"
						+ ")TMP"
					+ ") where rn between 1 and 10";
		PreparedStatement ps = JdbcUtil.getWorker(sql);
		ps.setString(1, boardWriter);
		ResultSet rs = ps.executeQuery();
		List<BoardDto> list = convert(rs);
		JdbcUtil.close(ps);
		return list;
	}
}













