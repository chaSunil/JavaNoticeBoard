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
 * Servlet implementation class VisitModifyFormAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수정할 게시물의 idx 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// idx에 해당되는 게시물 1건 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		// textarer \n기능처리 : content <br> -> \n 변환
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);

		// request binding(JSP에게 vo의 데이터를 넘겨줘야 하기 때문에 setAttribute 한다)
		request.setAttribute("vo", vo);
		
		// Dispatcher형식으로 호출
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
