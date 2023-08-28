package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.DTO;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("NAME");
		String id = request.getParameter("USER_ID");
		String phone = request.getParameter("PHONE");
		String pwd = request.getParameter("USER_PWD");
		String email = request.getParameter("EMAIL");
		DTO dto = new DTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPhone(phone);
		dto.setPwd(pwd);
		dto.setEmail(email);
		DAO dao = new DAO();
		String result = dao.register(dto);
		// userEntryResult.jsp로 화면 전환
		response.sendRedirect("index.jsp?BODY=userEntryResult.jsp?R="+result);
	}

}
