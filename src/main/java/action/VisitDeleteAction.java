package action;

import java.io.IOException;

import dao.VisitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitDeleteAction
 */
@WebServlet("/visit_practice/delete.do")
public class VisitDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 삭제할 idx 수신(문자열 정수로 변환)
		// getParameter로 받으면 무조건 String 타입을 받아진다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		String no = request.getParameter("no"); // 삭제할 글의 순서
		
		// DB 삭제
		int res = VisitDao.getInstance().delete(idx);
		
		response.sendRedirect("list.do#p_" + no);
		

	}
}