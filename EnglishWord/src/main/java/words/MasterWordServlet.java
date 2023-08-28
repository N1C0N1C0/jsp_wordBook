package words;

import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.DTO;

/**
 * Servlet implementation class EnglishWord
 */
@WebServlet("/masterWord.do")
public class MasterWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MasterWordServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		int pageSize = 5;
		int wordCount = dao.getMasterWordsCount();	// 총 데이터 수
		int pageCount = wordCount/pageSize;			// 총 페이지 수
		boolean prev, next; 
		if(wordCount % pageSize != 0) pageCount++;	
		int page = 1;
		String pageNum = request.getParameter("page");	// 현재 페이지
		
		if (pageNum != null && !pageNum.equals("")) {
			page = Integer.parseInt(pageNum);
	        if (page < 1) {
	            page = 1;
	        } else if (page > pageCount) {
	            page = pageCount;
	        }
	    }
		
		int totalPage = (wordCount + pageSize - 1) / pageSize; // 페이지 종료
		int startPage = ((page - 1) / 5) * 5 + 1; // 시작 페이지 번호
		int endPage = startPage+4;	
		
		if(endPage > pageCount) {	// 끝번호 초기화
			endPage = pageCount;
		}
		
		prev = startPage > 1;		// 다음 버튼
		next = endPage < pageCount;	// 이전 버튼
		
		System.out.println(wordCount);	// 총 데이터 수
//		System.out.println(totalPage);	// 총 페이지 수
//		System.out.println(startPage);	// 시작 페이지
//		System.out.println(endPage);	// 끝 페이지	
//		System.out.println(page);		// 현재 페이지
//		System.out.println(prev);		// 다음 버튼
//		System.out.println(next);		// 이전 버튼
		ArrayList<DTO> list = dao.getMasterWords(page);
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		request.setAttribute("PAGE", page);
		request.setAttribute("TOTAL", totalPage);
		request.setAttribute("START", startPage);
		request.setAttribute("END", endPage);
		request.setAttribute("PREV", prev);
		request.setAttribute("NEXT", next);
		
	
		// 조회 결과를 bbsList.jsp로 전달한다.
		request.getRequestDispatcher("index.jsp?BODY=wordsMasterList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
