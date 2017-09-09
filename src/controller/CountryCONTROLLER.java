package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.CountryVO;
import dao.CountryDAO;


/**
 * Servlet implementation class Country
 */
@WebServlet("/CountryCONTROLLER")
public class CountryCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryCONTROLLER() {
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
		
		if(flag.equals("searchCountry"))
		{
			search(request,response);
		}
	    if(flag.equals("editCountry"))
		{
			edit(request,response);
		}
	    if(flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
		}	    
	     
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
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
		}
		
	    
		}

private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	

	int id=Integer.parseInt(request.getParameter("id"));
	CountryVO cv=new CountryVO();
	cv.setCountryID(id);
	CountryDAO cd=new CountryDAO();
	 
	
	boolean b=cd.delete(cv);
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
String s=request.getParameter("countryName");
		
 		CountryVO v=new CountryVO();
 		v.setCountryName(s);
 		
 		CountryDAO d=new CountryDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_Country.jsp");
 		
		
		
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		CountryDAO d=new CountryDAO();
		
	       // CountryVO p=new CountryVO();
	       // p.getCountryID();
	       
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Search_Country.jsp");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id1"));
		CountryDAO d=new CountryDAO();
		
	       CountryVO p=new CountryVO();
	       p.setCountryID(id);
	       
			List lst=d.edit(p);
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Edit_Country.jsp");
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id=Integer.parseInt(request.getParameter("countryID"));
	String s=request.getParameter("countryName");
	
		
		
	        CountryVO p=new CountryVO();
	        p.setCountryID(id);
	        p.setCountryName(s);
	        
	        
	        CountryDAO d=new CountryDAO();
	        d.update(p);
	     
			
	 		
	 		
	}
}


