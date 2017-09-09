package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Example;

import vo.BranchVO;
import vo.CityVO;
import vo.CourseVO;
import vo.ManageExamVO;
import vo.SemesterVO;
import vo.SubjectVO;
import dao.BranchDAO;
import dao.CityDAO;
import dao.CourseDAO;
import dao.ManageExamDAO;
import dao.SemesterDAO;
import dao.SubjectDAO;

/**
 * Servlet implementation class ManageExamCONTROLLER
 */
@WebServlet("/ManageExamCONTROLLER")
public class ManageExamCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageExamCONTROLLER() {
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
		
		if(flag.equals("loadExam"))
		{
			load(request,response);
			
		}
				
		else if(flag.equals("searchExam"))
		{
			search(request,response);
		}
		else if(flag.equals("editExam"))
		{
			edit(request,response);
		}
		else if(flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
		}
		else if(flag.equals("loadExam1"))
	{
		applyexam(request,response);
		
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		

		int id=Integer.parseInt(request.getParameter("id"));
		ManageExamVO mv=new ManageExamVO();
		mv.setExamID(id);
		ManageExamDAO md=new ManageExamDAO();
		
		
		boolean b=md.delete(mv);
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

private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException 
{

	int  id=Integer.parseInt(request.getParameter("courseID"));
	int  id1=Integer.parseInt(request.getParameter("branchID"));
	int  id2=Integer.parseInt(request.getParameter("semesterID"));
	int  id3=Integer.parseInt(request.getParameter("subjectID"));

	String s=request.getParameter("examName");
	String s1=request.getParameter("examType");
	String s2=request.getParameter("examCode");
	String s3=request.getParameter("startTime");
   
	String s4=request.getParameter("endTime");
	String s5=request.getParameter("date");
	String s6=request.getParameter("marks");
	String s7=request.getParameter("examDescription");
	
	CourseVO cv=new CourseVO();
	cv.setCourseID(id);
	
	BranchVO bv=new BranchVO();
	bv.setBranchID(id1);
	
	SemesterVO sv=new SemesterVO();
	sv.setSemesterID(id2);
	
	SubjectVO sb=new SubjectVO();
	sb.setSubjectID(id3);
	
	
		ManageExamVO v=new ManageExamVO();
		v.setExamName(s);
		v.setExamType(s1);
		v.setExamCode(s2);
		v.setStartTime(s3);
		v.setEndTime(s4);
		v.setDate(s5);
		v.setMarks(s6);
		v.setExamDescription(s7);
		
		
		v.setCourseID(cv);
		v.setBranchID(bv);
		v.setSemesterID(sv);
		v.setSubjectID(sb);
		
		ManageExamDAO d=new ManageExamDAO();		
		d.insert(v);
		response.sendRedirect("Admin/Add_Exam.jsp");

}

protected void applyexam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	long uid=(Long) request.getSession().getAttribute("userID");
	ManageExamDAO md=new ManageExamDAO();
	List list12=md.search1(uid);
	HttpSession session=request.getSession();
	session.setAttribute("key",list12);

System.out.println("Size Of List ::"+list12.size());

response.sendRedirect("User/ApplyExam.jsp");

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
	 		
		
		
		SubjectDAO x2=new SubjectDAO();
		
		List l1=x2.search();
		
		HttpSession session3=request.getSession();
			session3.setAttribute("key3",l1);
			System.out.println("Size Of List ::"+l1.size());
		 		
			
			response.sendRedirect("Admin/Add_Exam.jsp");
			
		
		
}
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	ManageExamDAO d=new ManageExamDAO();
	
       
		List lst=d.search();
 		HttpSession session=request.getSession();
 		session.setAttribute("key4",lst);
 		System.out.println("Size Of List ::"+lst.size());
 		response.sendRedirect("Admin/Search_Exam.jsp");
}


protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("id"));
	ManageExamVO mv=new ManageExamVO();
	mv.setExamID(id);
	
	ManageExamDAO md=new ManageExamDAO();
	List lstexam=md.edit(mv);
	
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
	
	
	SubjectDAO sd=new SubjectDAO();
	List l4=sd.search();
	HttpSession session3=request.getSession();
	session3.setAttribute("key3",l4);
	System.out.println("Size Of List ::"+l4.size());
	
	
	

	hs.setAttribute("key5", lstexam);
	System.out.println("Size of lstexam::"+lstexam.size());
	response.sendRedirect("Admin/Edit_Exam.jsp");
	
	
	
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseVO cv=new CourseVO();
	cv.setCourseID(Integer.parseInt(request.getParameter("courseID")));
	
	BranchVO bv=new BranchVO();
	bv.setBranchID(Integer.parseInt(request.getParameter("branchID")));
	
	SemesterVO ssv=new SemesterVO();
	ssv.setSemesterID(Integer.parseInt(request.getParameter("semesterID")));
	
	SubjectVO sv=new SubjectVO();
	sv.setSubjectID(Integer.parseInt(request.getParameter("subjectID")));
	
	ManageExamDAO md=new ManageExamDAO();
	ManageExamVO mv=new ManageExamVO();
	mv.setExamID(Integer.parseInt(request.getParameter("examID")));
	
	mv.setCourseID(cv);
	mv.setBranchID(bv);
	mv.setSemesterID(ssv);
	mv.setSubjectID(sv);
	mv.setExamName(request.getParameter("examName"));
	mv.setExamType(request.getParameter("examType"));
	mv.setExamCode(request.getParameter("examCode"));
	mv.setStartTime(request.getParameter("startTime"));
	mv.setEndTime(request.getParameter("endTime"));
	mv.setDate(request.getParameter("date"));
	mv.setMarks(request.getParameter("marks"));
	mv.setExamDescription(request.getParameter("examDescription"));
	md.update(mv);
			
	}

}


