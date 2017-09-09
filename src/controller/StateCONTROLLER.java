package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.persister.entity.Loadable;

import vo.CountryVO;
import vo.StateVO;
import dao.CountryDAO;
import dao.StateDAO;

/**
 * Servlet implementation class StateCONTROLLER
 */
@WebServlet("/StateCONTROLLER")
public class StateCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateCONTROLLER() {
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
		
		if(flag.equals("loadState"))
		{
			load(request,response);
		}
		
		else if(flag.equals("searchState"))
		{
			search(request,response);
		}
		
		else   if(flag.equals("editState"))
		{
			edit(request,response);
		}
		else if(flag.equals("delete"))
			{
				delete(request,response);
				search(request,response);
			}
	      
		else if(flag.equals("loadState1"))
			{
				loadState(request,response);
			}
	}

	private void loadState(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
	
		System.out.println("into loadstate11111111 jj");
		CountryVO countryvo=new CountryVO();
		countryvo.setCountryID(Integer.parseInt(request.getParameter("countryID")));
		
		
		
		StateDAO statedao=new StateDAO();
		List ls1=statedao.loadState(countryvo);
		System.out.println("ls size jj"+ls1.size());
		
		Iterator i=ls1.iterator();
		PrintWriter pw=response.getWriter();
		int i10=10;
		pw.print("[");
		while(i.hasNext())
		{
			StateVO cv=new StateVO();
			cv=(StateVO) i.next();
			
			
			pw.print("{\"id\":\""+cv.getStateID()+"\",\"value\":\""+cv.getStateName()+"\"}");
			System.out.println("{\"id\":\""+cv.getStateID()+"\",\"value\":\""+cv.getStateName()+"\"}");
			if(i.hasNext())
			{
				pw.print(",");
			}
			
		}
		pw.print("]");
		
		
		System.out.println("lissst size coun jj"+ls1.size());
		
		
		
	}
   	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
		StateVO sv=new StateVO();
		sv.setStateID(id);
		StateDAO sd=new StateDAO();
		
		
		boolean b=sd.delete(sv);
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
	
		int  id=Integer.parseInt(request.getParameter("countryID"));
		String s=request.getParameter("stateName");

		CountryVO cv=new CountryVO();
		cv.setCountryID(id);
		
 		StateVO v=new StateVO();
 		v.setStateName(s);
 		v.setCountryID(cv);
 		
 		StateDAO d=new StateDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_State.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CountryDAO d=new CountryDAO();
		
       // CountryVO p=new CountryVO();
       // p.getCountryID();
       
		List lst1=d.search();
 		HttpSession session=request.getSession();
 		session.setAttribute("key",lst1);
 		System.out.println("Size Of List ::"+lst1.size());
 		response.sendRedirect("Admin/Add_State.jsp");
		
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StateDAO d=new StateDAO();
		
	 		List ls1=d.search();
	 		HttpSession session1=request.getSession();
	 		session1.setAttribute("key1",ls1);
	 		System.out.println("Size Of List ::"+ls1.size());
	 		response.sendRedirect("Admin/Search_State.jsp");
	 		
	 		
	}
	
protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	int id=Integer.parseInt(request.getParameter("id"));
	StateVO sv=new StateVO();
	sv.setStateID(id);
	
	StateDAO sd=new StateDAO();
	List ls=sd.edit(sv);
	
	CountryDAO cd=new CountryDAO();
	List lst=cd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("loadCountry", lst);
	System.out.println("Size of list::"+lst.size());
	
	hs.setAttribute("key", ls);
	System.out.println("Size of list::"+ls.size());
	response.sendRedirect("Admin/Edit_State.jsp");
	}
	
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CountryVO cv=new CountryVO();
	cv.setCountryID(Integer.parseInt(request.getParameter("countryID")));
	StateDAO stateDAO=new StateDAO();
	StateVO sv=new StateVO();
	sv.setStateID(Integer.parseInt(request.getParameter("id")));
	sv.setCountryID(cv);
	sv.setStateName(request.getParameter("stateName"));		
	stateDAO.update(sv);
	

	 		
	 		
	}
}
	
	

