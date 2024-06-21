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
	// 외부에서 객체생성하지 말아라...
	private VisitDao() {

	}
	
	
	// 테이블 목록 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit_view";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. ResultSet 얻어오기(킵해놨던 sql문 출력하기)
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				// 1. 저장객체 생성 -> 레코드에서 읽은 값을 넣는다.
				VisitVo vo = new VisitVo();

				// rs가 가리키는 레코드값을 VO에 넣는다.
				vo.setNo(rs.getInt("no"));
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				// ArrayList에 추가
				list.add(vo);

			} //end:while

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
		//                                                           1 2 3 4 <- pstmt index
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

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
		// 테이블안에 있는 데이터 삭제하는 SQL문 사용
		String sql = "delete from visit where idx=?";

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
	
	// 하나의 정보만 가져올 때 (where 사용해서 ex)deptno=10)
	public VisitVo selectOne(int idx) {
		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit_view where idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3. pstmt parameter index 채우기
			pstmt.setInt(1, idx);

			// 4. ResultSet 얻어오기(킵해놨던 sql문 출력하기)
			rs = pstmt.executeQuery();

			// while문을 사용해도 되지만, 공회전이 1회더 발생한다.
			if (rs.next()) {
				// 1. rs가 가리키는 레코드의 값을 읽어온다
				

				// 2. 저장객체 생성 -> 레코드에서 읽은 값을 넣는다.
				vo = new VisitVo();

				// rs가 가리키는 레코드값을 VO에 넣는다.// rs가 가리키는 레코드값을 VO에 넣는다.
				vo.setNo(rs.getInt("no"));
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

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

		return vo;
	}// end:selectOne()
	
}
