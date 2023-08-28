package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		DAO dao = new DAO();
		String result = dao.loginCheck(id,pwd);
		System.out.println(result);
		if(result.equals("OK")) {
			HttpSession session = request.getSession();
			if(id.equals("master")) {
				session.setAttribute("MASTER", id);
			}else {
				session.setAttribute("USER", id);
			}
			response.sendRedirect("index.jsp?BODY=loginResult.jsp?R=OK");
		}else {
			response.sendRedirect("index.jsp?BODY=loginResult.jsp?R=NOK");
		}
	}

}
