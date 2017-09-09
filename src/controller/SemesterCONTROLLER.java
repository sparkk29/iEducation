package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.BranchVO;
import vo.CourseVO;
import vo.SemesterVO;
import dao.BranchDAO;
import dao.CourseDAO;
import dao.SemesterDAO;

/**
 * Servlet implementation class SemesterCONTROLLER
 */
@WebServlet("/SemesterCONTROLLER")
public class SemesterCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterCONTROLLER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag1 = request.getParameter("flag");
		System.out.println(flag1);
		
		if(flag1.equals("searchSemester"))
		{
			search(request,response);
		}
		
		String flag = request.getParameter("flag");
		System.out.println(flag);
		
		if(flag.equals("loadCourse"))
		{
			load(request,response);
		}
		
		String flag2 = request.getParameter("flag");
		System.out.println(flag);
	      if(flag.equals("editSemester"))
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
String flag = request.getParameter("flag");
		
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
		
		int  id=Integer.parseInt(request.getParameter("courseID"));
		String s=request.getParameter("semesterNo");
		String s1=request.getParameter("semesterType");


		CourseVO cv=new CourseVO();
		cv.setCourseID(id);	
		
 		SemesterVO v=new SemesterVO();
 		v.setSemesterNo(s);
 		v.setSemesterType(s1);
 		v.setCourseID(cv);
 		
 		SemesterDAO d=new SemesterDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_Semester.jsp");
	
	
	}
	
	
	
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CourseDAO d=new CourseDAO();
		
	       // CountryVO p=new CountryVO();
	       // p.getCountryID();
	       
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Add_Semester.jsp");
		
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			SemesterDAO d=new SemesterDAO();
			List l=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key2",l);
	 		System.out.println("Size Of List ::"+l.size());
	 		response.sendRedirect("Admin/Search_Semester.jsp");
	}
	
protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("id"));
	SemesterVO sv=new SemesterVO();
	sv.setSemesterID(id);
	
	SemesterDAO sd=new SemesterDAO();
	List list=sd.edit(sv);
	
	CourseDAO cd=new CourseDAO();
	List lst=cd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("key", lst);
	System.out.println("Size of list::"+lst.size());
	
	hs.setAttribute("key1", list);
	System.out.println("Size of list::"+list.size());
	response.sendRedirect("Admin/Edit_Semester.jsp");
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseVO cv=new CourseVO();
	cv.setCourseID(Integer.parseInt(request.getParameter("id")));
	
	SemesterDAO sd=new SemesterDAO();
	SemesterVO sv=new SemesterVO();
	sv.setSemesterID(Integer.parseInt(request.getParameter("semesterID")));
	sv.setCourseID(cv);
	sv.setSemesterNo(request.getParameter("semesterNo"));	
	sv.setSemesterType(request.getParameter("semesterType"));
	sd.update(sv);
			
	}

private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	

	int id=Integer.parseInt(request.getParameter("id"));
	SemesterVO cv=new SemesterVO();
	cv.setSemesterID(id);
	SemesterDAO cd=new SemesterDAO();
	
	
	 
	
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
