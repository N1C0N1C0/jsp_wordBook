package words;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.DTO;

@WebServlet("/wordEnModify.do")
public class WordEnModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordEnModifyServlet() {
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
		String btn = request.getParameter("BTN");
		String seqno = request.getParameter("SEQNO");
		String word = request.getParameter("WORD");
		String mean = request.getParameter("MEAN");
		String pronunciation = request.getParameter("PRONUCTIATION");
		String k_pronunciation = request.getParameter("K_PRONUCTIATION");
		String result = "";	// 작업의 결과를 위한 변수 선언
		DAO dao = new DAO();
		
		if(btn.equals("삭제")) {
			result = dao.deleteEnWord(Integer.parseInt(seqno));
		}else if(btn.equals("수정")) {
			DTO dto = new DTO();
			dto.setSeqno(Integer.parseInt(seqno));
			dto.setWord(word);
			dto.setMean(mean);	
			dto.setPronunciation(pronunciation);
			dto.setK_pronunciation(k_pronunciation);
			result = dao.updateEnWord(dto);
		}
		response.sendRedirect("index.jsp?BODY=wordEnModifyResult.jsp?R="+result);
	}

}
