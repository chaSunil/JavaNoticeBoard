package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit_practice/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 수신인코딩 설정 utf-8
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 전달인자 받기
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content").replaceAll("\n", "<br>");
		String pwd = request.getParameter("pwd");
		
		// ip 정보 받기
		String ip = request.getRemoteAddr();
		
		VisitVo vo = new VisitVo(name, title, content, pwd, ip);
		
		// DB insert
		int res = VisitDao.getInstance().insert(vo);
		
		// 글쓰고 목록보는 곳으로 보내기
		response.sendRedirect("list.do");

	}

}