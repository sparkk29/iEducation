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
import vo.CourseVO;
import vo.StateVO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.StateDAO;

/**
 * Servlet implementation class CourseCONTROLLER
 */
@WebServlet("/CourseCONTROLLER")
public class CourseCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseCONTROLLER() {
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
		
		if(flag.equals("searchCourse"))
		{
			search(request,response);
		}
		if(flag.equals("editCourse"))
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag.equals("update"))
		{
			update(request,response);
			search(request,response);
		}
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String s=request.getParameter("courseType");
String s1=request.getParameter("courseDescription");		
 		
		CourseVO v=new CourseVO();
 		v.setCourseType(s);
 		v.setCourseDescription(s1);
 		
 		CourseDAO d=new CourseDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_Course.jsp");
 		
		
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CourseDAO d=new CourseDAO();
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Search_Course.jsp");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		CourseVO cv=new CourseVO();
		cv.setCourseID(id);
		CourseDAO cd=new CourseDAO();
		
		List lst=cd.edit(cv);
		HttpSession hs=request.getSession();
		hs.setAttribute("key", lst);
		System.out.println("Size of list::"+lst.size());
		response.sendRedirect("Admin/Edit_Course.jsp");
		}
		
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String s=request.getParameter("courseType");
		String s1=request.getParameter("courseDescription");
				CourseVO cv=new CourseVO();
		        cv.setCourseID(id);
		        cv.setCourseType(s);
		        cv.setCourseDescription(s1);
		        
		        CourseDAO cd=new CourseDAO();
		        cd.update(cv);
		}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		

		int id=Integer.parseInt(request.getParameter("id"));
		CourseVO cv=new CourseVO();
		cv.setCourseID(id);
		CourseDAO cd=new CourseDAO();
		 
		
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

}
