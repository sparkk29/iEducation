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
import vo.ManageExamVO;
import vo.RegisterVO;
import vo.SemesterVO;
import vo.StateVO;
import vo.SubjectVO;
import vo.UserTypeVO;
import dao.BranchDAO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.ManageExamDAO;
import dao.RegisterDAO;
import dao.SemesterDAO;
import dao.StateDAO;
import dao.SubjectDAO;
import dao.UserTypeDAO;

/**
 * Servlet implementation class RegisterCONTROLLER
 */
@WebServlet("/RegisterCONTROLLER")
public class RegisterCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCONTROLLER() {
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
		

		String s=request.getParameter("firstName");
		String s1=request.getParameter("lastName");
		String s2=request.getParameter("address");
		String s9=request.getParameter("phoneNo");
		   
		String s3=request.getParameter("emailID");
		String s4=request.getParameter("gender");
		String s5=request.getParameter("dob");
		String s6=request.getParameter("username");
		String s7=request.getParameter("password");
		String s8=request.getParameter("hobby");
		
		UserTypeVO uv=new UserTypeVO();
		uv.setUsername(s6);
		uv.setPassword(s7);
		uv.setUsertype("Faculty");
		
		UserTypeDAO ud=new UserTypeDAO();
		ud.insert(uv);
		
		
		CountryVO cv=new CountryVO();
		cv.setCountryID(id);
		
		StateVO sv=new StateVO();
		sv.setStateID(id1);
		
		CityVO civ=new CityVO();
		civ.setCityID(id2);
		
			RegisterVO v=new RegisterVO();
			v.setFirstName(s);
			v.setLastName(s1);
			v.setAddress(s2);
			v.setEmailID(s3);
			v.setGender(s4);
			v.setDob(s5);
			v.setUsername(s6);
			v.setPassword(s7);
			v.setHobby(s8);
			v.setPhoneNo(s9);
			v.setCountryID(cv);
			v.setStateID(sv);
			v.setCityID(civ);
			v.setUserID(uv);
						
			RegisterDAO d=new RegisterDAO();		
			d.insert(v);
			response.sendRedirect("/Admin/Register.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			CountryDAO d=new CountryDAO();
			List lst=d.search();
			HttpSession session=request.getSession();
			session.setAttribute("key",lst);
			System.out.println("Size Of List ::"+lst.size());
				
			StateDAO x=new StateDAO();
			List ls=x.search();
			HttpSession session1=request.getSession();
			session1.setAttribute("key1",ls);
			System.out.println("Size Of List ::"+ls.size());
		 		
			
			CityDAO x1=new CityDAO();
			List l=x1.search();
			HttpSession session2=request.getSession();
			session2.setAttribute("key2",l);
			System.out.println("Size Of List ::"+l.size());
		 	
			
			UserTypeDAO ud=new UserTypeDAO();
			List userlist=ud.search();
			HttpSession session3=request.getSession();
			session3.setAttribute("key21",userlist);
			System.out.println("Size Of List ::"+userlist.size());
			
			response.sendRedirect("Admin/Register.jsp");
				
			
			
	}


}
