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
import vo.CountryVO;
import vo.CourseVO;
import vo.StateVO;
import dao.BranchDAO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.StateDAO;

/**
 * Servlet implementation class BranchCONTROLLER
 */
@WebServlet("/BranchCONTROLLER")
public class BranchCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchCONTROLLER() {
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
		
		if(flag1.equals("searchBranch"))
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
	      if(flag.equals("editBranch"))
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
		String s=request.getParameter("branchType");
		String s1=request.getParameter("branchDescription");


		CourseVO cv=new CourseVO();
		cv.setCourseID(id);	
		
 		BranchVO v=new BranchVO();
 		v.setBranchType(s);
 		v.setBranchDescription(s1);
 		v.setCourseID(cv);
 		
 		BranchDAO d=new BranchDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_Branch.jsp");
	
	
	}
	
	
	
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CourseDAO d=new CourseDAO();
		
	       // CountryVO p=new CountryVO();
	       // p.getCountryID();
	       
			List lst=d.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key",lst);
	 		System.out.println("Size Of List ::"+lst.size());
	 		response.sendRedirect("Admin/Add_Branch.jsp");
		
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			BranchDAO b=new BranchDAO();
			List ls=b.search();
	 		HttpSession session=request.getSession();
	 		session.setAttribute("key1",ls);
	 		System.out.println("Size Of List ::"+ls.size());
	 		response.sendRedirect("Admin/Search_Branch.jsp");
	 		
	}
	
protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("id"));
	BranchVO bv=new BranchVO();
	bv.setBranchID(id);
	
	BranchDAO bd=new BranchDAO();
	List ls=bd.edit(bv);
	
	CourseDAO cd=new CourseDAO();
	List lst=cd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("key", lst);
	System.out.println("Size of list::"+lst.size());
	
	hs.setAttribute("key1", ls);
	System.out.println("Size of list::"+ls.size());
	response.sendRedirect("Admin/Edit_Branch.jsp");
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseVO cv=new CourseVO();
	cv.setCourseID(Integer.parseInt(request.getParameter("id")));
	BranchDAO bd=new BranchDAO();
	BranchVO bv=new BranchVO();
	bv.setBranchID(Integer.parseInt(request.getParameter("branchID")));
	bv.setCourseID(cv);
	bv.setBranchType(request.getParameter("branchType"));	
	bv.setBranchDescription(request.getParameter("branchDescription"));
	bd.update(bv);
			
	}



private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	

	int id=Integer.parseInt(request.getParameter("id"));
	BranchVO cv=new BranchVO();
	cv.setBranchID(id);
	BranchDAO cd=new BranchDAO();
	
	 
	
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
