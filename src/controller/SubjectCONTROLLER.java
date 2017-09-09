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
import vo.CityVO;
import vo.CountryVO;
import vo.CourseVO;
import vo.SemesterVO;
import vo.StateVO;
import vo.SubjectVO;
import dao.BranchDAO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.SemesterDAO;
import dao.StateDAO;
import dao.SubjectDAO;

/**
 * Servlet implementation class SubjectCONTROLLER
 */
@WebServlet("/SubjectCONTROLLER")
public class SubjectCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectCONTROLLER() {
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
		
		if(flag1.equals("searchSubject"))
		{
			search(request,response);
		}
		
		
		
		String flag = request.getParameter("flag");
		System.out.println(flag);
		
		if(flag.equals("loadSubject"))
		{
			load(request,response);
		}
		String flag2 = request.getParameter("flag");
		System.out.println(flag);
	      if(flag.equals("editSubject"))
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

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
	
		int  id=Integer.parseInt(request.getParameter("courseID"));
		int  id1=Integer.parseInt(request.getParameter("branchID"));
		int  id2=Integer.parseInt(request.getParameter("semesterID"));

		String s=request.getParameter("subjectName");
		String s1=request.getParameter("subjectDescription");
		
		CourseVO cv=new CourseVO();
		cv.setCourseID(id);
		
		BranchVO bv=new BranchVO();
		bv.setBranchID(id1);
		
		SemesterVO sv=new SemesterVO();
		sv.setSemesterID(id2);
		
		
 		SubjectVO v=new SubjectVO();
 		v.setSubjectName(s);
 		v.setSubjectDescription(s1);
 		v.setCourseID(cv);
 		v.setBranchID(bv);
 		v.setSemesterID(sv);
 		
 		SubjectDAO d=new SubjectDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_Subject.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CourseDAO d=new CourseDAO();
		
		List lst=d.search();
				
 		HttpSession session=request.getSession();
 		session.setAttribute("key",lst);
 		System.out.println("Size Of List ::"+lst.size());
 		
 		//response.sendRedirect("Admin/Add_Subject.jsp");}
 		
	
	//protected void load1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BranchDAO x=new BranchDAO();
		
		List ls=x.search();
		
		HttpSession session1=request.getSession();
 		session1.setAttribute("key1",ls);
 		System.out.println("Size Of List ::"+ls.size());
		 		
 		//System.out.println("load complete... redirecting");
 		//response.sendRedirect("Admin/Add_Subject.jsp");
 		//System.out.println("redirecting complete");
 		
 		
      SemesterDAO x1=new SemesterDAO();
		
		List l=x1.search();
		
		HttpSession session2=request.getSession();
 		session2.setAttribute("key2",l);
 		System.out.println("Size Of List ::"+l.size());
		 		
 		//System.out.println("load complete... redirecting");
 		response.sendRedirect("Admin/Add_Subject.jsp");
 		//System.out.println("redirecting complete");
 		
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SubjectDAO d=new SubjectDAO();
		
	       // CountryVO p=new CountryVO();
	       // p.getCountryID();
	       
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key4",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Search_Subject.jsp");
	}

protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("id"));
	SubjectVO sv=new SubjectVO();
	sv.setSubjectID(id);
	
	SubjectDAO sd=new SubjectDAO();
	List l4=sd.edit(sv);
	
	CourseDAO cd=new CourseDAO();
	List lst=cd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("key", lst);
	System.out.println("Size of list::"+lst.size());
	
	BranchDAO x=new BranchDAO();
	List ls=x.search();
	HttpSession session1=request.getSession();
	session1.setAttribute("key1",ls);
	System.out.println("Size Of List ::"+ls.size());
	 		
		
  SemesterDAO x1=new SemesterDAO();
	List list=x1.search();
	HttpSession session2=request.getSession();
	session2.setAttribute("key2",list);
	System.out.println("Size Of List ::"+list.size());
	
	
	
	hs.setAttribute("key3", l4);
	System.out.println("Size of l4::"+l4.size());
	response.sendRedirect("Admin/Edit_Subject.jsp");
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseVO cv=new CourseVO();
	cv.setCourseID(Integer.parseInt(request.getParameter("courseID")));
	
	BranchVO bv=new BranchVO();
	bv.setBranchID(Integer.parseInt(request.getParameter("branchID")));
	
	SemesterVO ssv=new SemesterVO();
	ssv.setSemesterID(Integer.parseInt(request.getParameter("semesterID")));
	
	SubjectDAO sd=new SubjectDAO();
	SubjectVO sv=new SubjectVO();
	sv.setSubjectID(Integer.parseInt(request.getParameter("subjectID")));
	
	sv.setCourseID(cv);
	sv.setBranchID(bv);
	sv.setSemesterID(ssv);
	sv.setSubjectName(request.getParameter("subjectName"));	
	sv.setSubjectDescription(request.getParameter("subjectDescription"));
	sd.update(sv);
			
	}

private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	

	int id=Integer.parseInt(request.getParameter("id"));
	SubjectVO cv=new SubjectVO();
	cv.setSubjectID(id);
	SubjectDAO cd=new SubjectDAO();
	
	 
	
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

