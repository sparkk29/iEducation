package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserTypeDAO;
import vo.UserTypeVO;

/**
 * Servlet implementation class UserTypeCONTROLLER
 */
@WebServlet("/UserTypeCONTROLLER")
public class UserTypeCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTypeCONTROLLER() {
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
		
		if(flag.equals("searchuser"))
		{
			search(request,response);
		}
		else if(flag.equals("edituser"))
		{
			edit(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
   		{
   			System.out.println("delete");
   			boolean b=delete(request,response);	
   			if(b==true)
   			{
   				List userlist= new ArrayList();
   	   			UserTypeDAO ud=new UserTypeDAO();
   	   			userlist = ud.search();
   	   			HttpSession httpSession = request.getSession();
   	   			httpSession.setAttribute("key21", userlist);
   	   			httpSession.setAttribute("b","true");
   	   			response.sendRedirect("Admin/searchuser.jsp");
   			}
   			else
   			{
   				List userlist= new ArrayList();
   	   			UserTypeDAO ud = new UserTypeDAO();
   	   			userlist = ud.search();
   	   			HttpSession httpSession1 = request.getSession();
   	   			httpSession1.setAttribute("key21", userlist);
   	   			httpSession1.setAttribute("b","false");
   	   			response.sendRedirect("Admin/searchuser.jsp");
   	   			
   			}   			
   		}
   	
   	}

	private boolean delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UserTypeVO uv=new UserTypeVO();
		int id=Integer.parseInt(request.getParameter("UserID"));
		uv.setUserID(id);
		
		UserTypeDAO ud=new UserTypeDAO();
		 boolean b=ud.delete(uv);
			 if(b==false)
				 {
					return false;
				 }
				 else
				 {
					 return true;
				 }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flag = request.getParameter("flag");
		System.out.println("value = " + flag);
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
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");
		String s3=request.getParameter("usertype");
		UserTypeVO uv=new UserTypeVO();
		uv.setUsername(s1);
		uv.setPassword(s2);
		uv.setUsertype(s3);
		
		UserTypeDAO d=new UserTypeDAO();
		d.insert(uv);
		
		response.sendRedirect("/Admin/UserTypeMaster.jsp");
	
	
	
	}
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserTypeDAO ud= new UserTypeDAO();
		List userlist=ud.search();
		HttpSession session=request.getSession();
		session.setAttribute("key21",userlist);
		System.out.println("Size Of List ::"+userlist.size());
		response.sendRedirect("Admin/searchuser.jsp");

}

protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	int id=Integer.parseInt(request.getParameter("UserID"));
	
	UserTypeVO uv=new UserTypeVO();
	uv.setUserID(id);
	
		UserTypeDAO ud=new UserTypeDAO();  
	
		List userlist=ud.edit(uv);
		HttpSession session=request.getSession();
		session.setAttribute("key21",userlist);
		System.out.println("Size Of List ::"+userlist.size());
		response.sendRedirect("Admin/edituser.jsp");

	
}


protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id=Integer.parseInt(request.getParameter("UserID"));

	System.out.println("UserID is"+id);
	String s1=request.getParameter("username");
	String s2=request.getParameter("password");
	String s3=request.getParameter("usertype");

	UserTypeVO uv=new UserTypeVO();
	uv.setUserID(id);
	uv.setUsername(s1);
	uv.setPassword(s2);
	uv.setUsertype(s3);
	
	UserTypeDAO ud =new UserTypeDAO();
	ud.update(uv);
	
	
}
}

