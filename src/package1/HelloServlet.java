package package1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class package1.HelloServlet
 */
@WebServlet("/hhhh")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����û�����   http://localhost:8080/maizi/hhhh?number=30
		String number = request.getParameter("number");
		int numerInt = Integer.parseInt(number);
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>"
				+ "<head><title>Hi Servlet</title></head>"
				+ "<meta charset='utf-8'/>"
				+ "<body>"
				+ "<h1>I study Java EE today ,yeah!</h1>");
		for(int i=0;i<numerInt;i++) {
			builder.append("<span>���յ�һ��У��<img src='http://www.cqjtu.edu.cn/Content/images/logo.png'></span>");
		}
		builder.append("<package1.a href='https://baidu.com'>google</package1.a>"
				+ "<img src='http://www.cqjtu.edu.cn/images/sftsgx.jpg'/>"
				+ "Served at: <span style='color:red'>HHHHHHHHHH</span>"
				+ "</body>"
				+ "</html>");
		//�����Ӧ
		response.getWriter().append(builder.toString() ).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
