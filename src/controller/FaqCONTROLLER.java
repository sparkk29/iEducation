package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.CityVO;
import vo.CountryVO;
import vo.FaqVO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.FaqDAO;

/**
 * Servlet implementation class FaqCONTROLLER
 */
@WebServlet("/FaqCONTROLLER")
public class FaqCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqCONTROLLER() {
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
		
		if(flag.equals("searchFaq"))
		{
			search(request,response);
			response.sendRedirect("Admin/Search_FAQ.jsp");
		}
		else if(flag.equals("facultyFaq"))
		{
			search(request,response);
			response.sendRedirect("Faculty/View_FAQ.jsp");
		}
		else if(flag.equals("studentsearchFaq"))
		{
			search(request,response);
			response.sendRedirect("User/FAQ.jsp");
		}
		
		String flag1 = request.getParameter("flag");
		System.out.println(flag);
	      if(flag.equals("editFaq"))
		{
			edit(request,response);
		}
	      if(flag.equals("delete"))
	      {
	    	  delete(request,response);
	    	  search(request,response);
	    	  response.sendRedirect("Admin/Search_FAQ.jsp");
	    	  
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
		} 
		else if(flag.equals("update"))
		{
			update(request,response);
			search(request,response);
			response.sendRedirect("Admin/Search_FAQ.jsp");
		}
		
		}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		

		int id=Integer.parseInt(request.getParameter("id"));
		FaqVO sv=new FaqVO();
		sv.setFaqID(id);
		FaqDAO sd=new FaqDAO();
		
		
		boolean b=sd.delete(sv);
		 HttpSession hs=request.getSession();
		if(b==false)
		{
			hs.setAttribute("b","false");
		}
		else
		{
			hs.setAttribute("b","true");
		}
	}

		
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String s=request.getParameter("faqQuestion");
String s1=request.getParameter("faqAnswer");
		
 		FaqVO vo=new FaqVO();
 		vo.setFaqQuestion(s);
 		vo.setFaqAnswer(s1);
 		
 		FaqDAO in=new FaqDAO();
 		in.insert(vo);
 		
 		response.sendRedirect("Admin/Add_FAQ.jsp");
 		
		
		
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FaqDAO d=new FaqDAO();
		
	       
	       
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		
	}

protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id1"));
		FaqDAO d=new FaqDAO();
		
	       FaqVO p=new FaqVO();
	       p.setFaqID(id);
	       
			List lst=d.edit(p);
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Edit_FAQ.jsp");
	}

protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id=Integer.parseInt(request.getParameter("faqID"));
	String s=request.getParameter("faqQuestion");
	String s1=request.getParameter("faqAnswer");
		
		
	        FaqVO p=new FaqVO();
	        p.setFaqID(id);
	        p.setFaqQuestion(s);
	        p.setFaqAnswer(s1);
	        
	        FaqDAO fd=new FaqDAO();
	        fd.update(p);
	     
		
}
}
