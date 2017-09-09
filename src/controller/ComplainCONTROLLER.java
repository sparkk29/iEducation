package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ComplainVO;
import vo.FaqVO;
import dao.ComplainDAO;
import dao.FaqDAO;

/**
 * Servlet implementation class ComplainCONTROLLER
 */
@WebServlet("/ComplainCONTROLLER")
public class ComplainCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		System.out.println(flag);
		
		if(flag.equals("searchComplain"))
		{
			load(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String flag = request.getParameter("flag");
		
		if(flag.equals("insert"))
		{
			insert(request,response);
			response.sendRedirect("User/Complain.jsp");
			
		} 
		
		
		}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String s=request.getParameter("complainsubject");
		String s1=request.getParameter("compose");
		
 		ComplainVO vo=new ComplainVO();
 		vo.setComplainSubject(s);
 		vo.setCompose(s1);
 		
 		ComplainDAO in=new ComplainDAO();
 		in.insert(vo);
 		
 		
	}
	
	
protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ComplainDAO d=new ComplainDAO();
		
	       
	       
			List list33=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",list33);
	 		System.out.println("Size Of List ::"+list33.size());
	 		response.sendRedirect("Admin/Search_Complain.jsp");
	 		
	}
}

