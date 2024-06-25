package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.VisitVo;
import service.DBService;

public class VisitDao {

	// single-ton pattern : 객체 1개만 생성해서 사용하자
	static VisitDao single = null;

	public static VisitDao getInstance() {
		// 없으면 생성해라
		if (single == null) {
			single = new VisitDao();
		}
		return single;
	}

	private VisitDao() {

	}
	
	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit_practice_view";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. ResultSet 얻어오기(킵해놨던 sql문 출력하기)
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 1. rs가 가리키는 레코드의 값을 읽어온다

				// 2. 저장객체 생성 -> 레코드에서 읽은 값을 넣는다.
				VisitVo vo = new VisitVo();

				// rs가 가리키는 레코드값을 VO에 넣는다.
				vo.setNo(rs.getInt("no"));
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				
				// ArrayList에 추가
				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 예외 처리에서 무조건 실행되는 부분
			// 마무리 작업(열린역순으로 닫기)
			// 한 번에 잡아서 try catch 하기 : alt + shift + s
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into visit_practice values(seq_visit_idx_practice.nextVal,?,?,?,?,?,sysdate)";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getIp());

			// 4. DB insert
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 예외 처리에서 무조건 실행되는 부분
			// 마무리 작업(열린역순으로 닫기)
			// 한 번에 잡아서 try catch 하기 : alt + shift + s
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;

	}// end:insert()
	
	public int delete(int idx) {
		// TODO Auto-generated method stub

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from visit_practice where idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt parameter index 채우기
			pstmt.setInt(1, idx);

			// 4. DB delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 예외 처리에서 무조건 실행되는 부분
			// 마무리 작업(열린역순으로 닫기)
			// 한 번에 잡아서 try catch 하기 : alt + shift + s
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;

	}// end:delete()
	
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from visit_practice_view where idx=?";
		
		try {
			conn = DBService.getInstance().getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new VisitVo();
				
				vo.setNo(rs.getInt("no"));
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 처리에서 무조건 실행되는 부분
			// 마무리 작업(열린역순으로 닫기)
			// 한 번에 잡아서 try catch 하기 : alt + shift + s
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
		
	}// end:selectOne()
	
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update visit_practice set name =?, title =?, content =?, pwd =?, ip =?, regdate = sysdate where idx =? ";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getIp());
			pstmt.setInt(6, vo.getIdx());

			// 4. DB update
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 예외 처리에서 무조건 실행되는 부분
			// 마무리 작업(열린역순으로 닫기)
			// 한 번에 잡아서 try catch 하기 : alt + shift + s
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;

	}// end:update()
}