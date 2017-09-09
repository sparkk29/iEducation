package filter;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import dao.UserTypeDAO;

import vo.UserTypeVO;

 

/**
 * Servlet Filter implementation class loginController
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String logout = request.getParameter("logout");
		String reg = request.getParameter("reg");
		System.out.println("registration flag===" + reg);
		//	int i = (Integer)session.getAttribute("userID");
		//System.out.println("id = = = = =" + i);
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		
		System.out.println("link =  = = = = " + uri);
		
		if(uri.contains("Login")||uri.contains("/css") || uri.contains("/js") || uri.contains("/Homepage3.jsp")|| uri.contains("/Header3.jsp") || uri.contains("/Footer3.jsp") || uri.contains("/menu3.jsp") || uri.contains("/Contact_Us.jsp") ||uri.contains("/About_Us.jsp") &&!uri.contains("/jsp")|| uri.contains("/images")|| uri.contains("/fonts"))
		{
			
			//requestDispatcher = request.getRequestDispatcher("/user/register.jsp");  
			//requestDispatcher.forward(request,response);  
			
			chain.doFilter(request,response);
			
		}
		
		else if (logout!= null) {
			//session.removeAttribute("userID");
			System.out.println("logout in else if");
		
			session.invalidate();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			
		}
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("login") )
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			System.out.println(userName+""+password);
			
			UserTypeVO registrationMstVO = new UserTypeVO();
			registrationMstVO.setUsername(userName);
			registrationMstVO.setPassword(password);
			
			UserTypeDAO registrationMstDAO = new UserTypeDAO();
			List list =  registrationMstDAO.authentication(registrationMstVO);
			
		
			if(list != null && list.size()>=1){
				
				Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				UserTypeVO user=(UserTypeVO) itr.next();
				
				Long y = (Long)user.getUserID();
				session.setAttribute("userID",y);
				
				System.out.println(user.getUsertype());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUsertype();
				session.setAttribute("usertype",type);
				System.out.println(y);
				if(type.equals("Admin"))
				{
				requestDispatcher = request.getRequestDispatcher("/Admin/index.jsp");  
				requestDispatcher.forward(request,response);  
				}
				if(type.equals("Faculty"))
				{
					requestDispatcher = request.getRequestDispatcher("/Faculty/index.jsp");  
					requestDispatcher.forward(request,response);  
				  
				}
				if(type.equals("Student"))
				{
					requestDispatcher = request.getRequestDispatcher("/User/Homepage.jsp");  
					requestDispatcher.forward(request,response);  
				  
				}
				}
			
			else{
					requestDispatcher = request.getRequestDispatcher("/Login.jsp");  
					requestDispatcher.forward(request,response);  		
				}	
		}
		
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("logout") )
		{
			System.out.println("into logoouttttttttttttttttttttttttttttttttttttt");
				session.invalidate();
			
				requestDispatcher = request.getRequestDispatcher("/Login.jsp");  
				requestDispatcher.forward(request,response);  		
				
		}
		else if(session.getAttribute("userID") != null)
		{
			
			chain.doFilter(request,response);
		}
		else{
			
		
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");  
			rd.forward(request,response);  
			
			}
		
		
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
