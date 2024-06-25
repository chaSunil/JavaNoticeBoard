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
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit_practice/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content").replaceAll("\n","<br>");
		String pwd = request.getParameter("pwd");
		
		String ip = request.getRemoteAddr();

		VisitVo vo = new VisitVo(idx, name, title, content, pwd, ip);
		
		int res = VisitDao.getInstance().update(vo);
		
		response.sendRedirect("list.do#p_" + no);

	}

}