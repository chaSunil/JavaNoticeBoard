package action;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, // client -> server로 들어오는정보 처리
			HttpServletResponse response) // server -> client로 응답처리하는 객체
			throws ServletException, IOException {
		
		// /visit/insert.do?name=홍길동&content=안녕&pwd=1234
		
		// 0. 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. parameter(전달인자) 받기
		String name = request.getParameter("name");
		String content = request.getParameter("content").replaceAll("\n", "<br>");
		String pwd = request.getParameter("pwd");
		
		// 2. ip 정보 받기
		String ip = request.getRemoteAddr();
		
		// 3. VisitVo 포장
		// vo에서 오버로드 된 생성자 새로 추가
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		// 4. DBinsert
		int res = VisitDao.getInstance().insert(vo);
		
		// 5. 목록보기
		response.sendRedirect("list.do");
	}
}