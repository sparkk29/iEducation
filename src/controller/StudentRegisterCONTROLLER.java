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
import vo.RegisterVO;
import vo.SemesterVO;
import vo.StateVO;
import vo.StudentRegisterVO;
import vo.UserTypeVO;
import dao.BranchDAO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.RegisterDAO;
import dao.SemesterDAO;
import dao.StateDAO;
import dao.StudentRegisterDAO;
import dao.UserTypeDAO;

/**
 * Servlet implementation class StudentRegisterCONTROLLER
 */
@WebServlet("/StudentRegisterCONTROLLER")
public class StudentRegisterCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterCONTROLLER() {
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
		
		if(flag.equals("load"))
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
		}
	}
	
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{

		int  id=Integer.parseInt(request.getParameter("countryID"));
		int  id1=Integer.parseInt(request.getParameter("stateID"));
		int  id2=Integer.parseInt(request.getParameter("cityID"));
		int  id3=Integer.parseInt(request.getParameter("courseID"));
		int  id4=Integer.parseInt(request.getParameter("branchID"));
		int  id5=Integer.parseInt(request.getParameter("semesterID"));

		String s=request.getParameter("firstName");
		String s1=request.getParameter("lastName");
		String s2=request.getParameter("address");
		String s9=request.getParameter("phoneNo");
		   
		String s3=request.getParameter("emailID");
		String s4=request.getParameter("gender");
		String s5=request.getParameter("dob");
		String s6=request.getParameter("username");
		String s7=request.getParameter("password");
		
		
		CountryVO cv=new CountryVO();
		cv.setCountryID(id);
		
		StateVO sv=new StateVO();
		sv.setStateID(id1);
		
		CityVO civ=new CityVO();
		civ.setCityID(id2);
		
		CourseVO cv1=new CourseVO();
		cv1.setCourseID(id3);
		
		
		BranchVO br=new BranchVO();
		br.setBranchID(id4);
		
		SemesterVO sv1=new SemesterVO();
		sv1.setSemesterID(id5);
			StudentRegisterVO v=new StudentRegisterVO();
			v.setFirstName(s);
			v.setLastName(s1);
			v.setAddress(s2);
			v.setEmailID(s3);
			v.setGender(s4);
			v.setDob(s5);
			v.setUsername(s6);
			v.setPassword(s7);
			v.setPhoneNo(s9);
			v.setCountryID(cv);
			v.setStateID(sv);
			v.setCityID(civ);
			v.setCourseID(cv1);
			v.setBranchID(br);
			v.setSemesterID(sv1);
						
			StudentRegisterDAO d=new StudentRegisterDAO();		
			d.insert(v);
			
			
			
			UserTypeVO uv=new UserTypeVO();
			uv.setUsername(s6);
			uv.setPassword(s7);
			uv.setUsertype("Student");
			uv.setStudentRegisterVO(v);
			

			UserTypeDAO ud=new UserTypeDAO();
			ud.insert(uv);

			
			
			response.sendRedirect("Faculty/StudentRegistration.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			CountryDAO d=new CountryDAO();
			List lst1=d.search();
			HttpSession session=request.getSession();
			session.setAttribute("key00",lst1);
			System.out.println("Size Of List ::"+lst1.size());
				
			StateDAO x=new StateDAO();
			List ls1=x.search();
			HttpSession session1=request.getSession();
			session1.setAttribute("key11",ls1);
			System.out.println("Size Of List ::"+ls1.size());
		 		
			
			CityDAO x1=new CityDAO();
			List l1=x1.search();
			HttpSession session2=request.getSession();
			session2.setAttribute("key22",l1);
			System.out.println("Size Of List ::"+l1.size());
			
			CourseDAO cd=new CourseDAO();
			List lst=cd.search();
			HttpSession session3=request.getSession();
			session3.setAttribute("key",lst);
			System.out.println("Size Of List ::"+lst.size());
				
			BranchDAO br=new BranchDAO();
			List ls=br.search();
			HttpSession session4=request.getSession();
			session4.setAttribute("key1",ls);
			System.out.println("Size Of List ::"+ls.size());
		 		
			
			SemesterDAO sd=new SemesterDAO();
			List l=sd.search();
			HttpSession session5=request.getSession();
			session5.setAttribute("key2",l);
			System.out.println("Size Of List ::"+l.size());
		 	
			response.sendRedirect("Faculty/StudentRegistration.jsp");
				
			
			
	}


}
