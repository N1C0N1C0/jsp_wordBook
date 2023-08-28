package words;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.DAO;
import model.DTO;


/**
 * Servlet implementation class EnWordWiret
 */
@WebServlet("/wordEnWirte.do")
public class WordEnWirteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordEnWirteServlet() {
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
		String word = request.getParameter("WORD");
		String mean = request.getParameter("MEAN");
		String pronunciation = request.getParameter("PRONUNCIATION");
		String k_pronunciation = request.getParameter("K_PRONUNCIATION");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		
			DTO dto = new DTO();
			DAO dao = new DAO();
			int seqno = dao.getEnMaxSeqno() + 1;
			dto.setSeqno(seqno);	// 글번호
			dto.setWord(word);	// 단어
			dto.setMean(mean);	// 단어 뜻
			dto.setPronunciation(pronunciation);
			dto.setK_pronunciation(k_pronunciation);
			dto.setId(id);	// 작성자
			String result = dao.insertEnWord(dto);	// 게시글 등록
			response.sendRedirect("index.jsp?BODY=wordEnWriteResult.jsp?R="+result);
			
	}

}
