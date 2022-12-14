package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check.do")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그1 ["+request.getParameter("mid")+"]");
		
		TestDAO dao=new TestDAO();
		TestVO vo=new TestVO();
		vo.setMid(request.getParameter("mid"));
		int result=dao.check(vo);
		
		// 요청했던 곳으로 result값을 보낼 예정
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result+""); // 문자열을 더함으로써 String으로 변환
	}

}
