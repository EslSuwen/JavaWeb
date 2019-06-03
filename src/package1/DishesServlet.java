package package1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class package1.DishesServlet
 */
@WebServlet("/dishes")
public class DishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dish> dishList = new ArrayList<>();
		dishList.add(new Dish("鱼香肉丝","荤",4.00));
		dishList.add(new Dish("苦瓜炒肉","荤",4.00));
		dishList.add(new Dish("盘龙茄子","素",2.00));
		dishList.add(new Dish("刨猪汤","荤",22.00));
		
		//request.setAttribute("dishList", dishList);
		HttpSession session=request.getSession();
		session.setAttribute("dishList",dishList);
		//request.getRequestDispatcher("/dish.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/dish.jsp?message=" + URLEncoder.encode("Please login first!好吧", "utf-8"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
