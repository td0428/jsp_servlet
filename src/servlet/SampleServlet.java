package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberConfirm
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	static int count = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 各フォームデータを取得する
		String name = request.getParameter("name");
		int f = rand.nextInt(5);
		String fortune = null;
		switch (f) {
		case 0:
			fortune = "大吉";
			break;
		case 1:
			fortune = "中吉";
			break;
		case 2:
			fortune = "吉";
			break;
		case 3:
			fortune = "凶";
			break;
		case 4:
			fortune = "大凶";
			break;
		}
		count++;
		request.setAttribute("name", name);
		request.setAttribute("fortune", fortune);
		request.setAttribute("count", count);

		request.getRequestDispatcher("jsp/Fortune/Receipt.jsp").forward(request, response);
	}
}