package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.CityVO;
import vo.CountryVO;
import vo.StateVO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.StateDAO;

/**
 * Servlet implementation class CityCONTROLLER
 */
@WebServlet("/CityCONTROLLER")
public class CityCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityCONTROLLER() {
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
		
		if(flag.equals("loadCountry"))
		{
			load(request,response);
		}
		String flag1 = request.getParameter("flag");
		System.out.println(flag);
		
		if(flag.equals("searchCity"))
		{
			search(request,response);
		}
		String flag2 = request.getParameter("flag");
		System.out.println(flag);
		
		if(flag.equals("editCity"))
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
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		

		int id=Integer.parseInt(request.getParameter("id"));
		CityVO sv=new CityVO();
		sv.setCityID(id);
		
		CityDAO sd=new CityDAO();
				
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
		int  id1=Integer.parseInt(request.getParameter("stateID"));

		String s=request.getParameter("cityName");

		CountryVO cv=new CountryVO();
		cv.setCountryID(id);
		
		StateVO sv=new StateVO();
		sv.setStateID(id1);
		
 		CityVO v=new CityVO();
 		v.setCityName(s);
 		v.setStateID(sv);
 		v.setCountryID(cv);
 		
 		CityDAO d=new CityDAO();		
 		d.insert(v);
 		response.sendRedirect("Admin/Add_City.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CountryDAO d=new CountryDAO();
		
		List lst1=d.search();
				
 		HttpSession session=request.getSession();
 		session.setAttribute("key",lst1);
 		System.out.println("Size Of List ::"+lst1.size());
 		
 		
		StateDAO x=new StateDAO();
		
		List ls=x.search();
		
		HttpSession session1=request.getSession();
 		session1.setAttribute("key1",ls);
 		System.out.println("Size Of List ::"+ls.size());
		 		
 		//System.out.println("load complete... redirecting");
 		response.sendRedirect("Admin/Add_City.jsp");
 		//System.out.println("redirecting complete");
 		
	}
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CityDAO ci=new CityDAO();
		
	 		List l=ci.search();
	 		HttpSession session2=request.getSession();
	 		session2.setAttribute("key2",l);
	 		System.out.println("Size Of List ::"+l.size());   
	 		response.sendRedirect("Admin/Search_City.jsp");
}
private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(request.getParameter("id1"));
	CityVO cv=new CityVO();
	cv.setCityID(id);
		
	StateDAO sd=new StateDAO();
	
	List ls=sd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("loadState", ls);
	
	CountryDAO cd1=new CountryDAO();
	List lst=cd1.search();
	
	hs.setAttribute("loadCountry", lst);
	
	
	CityDAO cd=new CityDAO();
	List lst1=cd.edit(cv);

	hs.setAttribute("cityLoad", lst1);
	
	response.sendRedirect("Admin/Edit_City.jsp");
}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StateVO stateVO= new StateVO();
		CountryVO countryVO=new CountryVO();
		
		CityVO cityVO=new CityVO();
		CityDAO cityDAO=new CityDAO();
	
		stateVO.setStateID(Integer.parseInt(request.getParameter("stateID")));
		countryVO.setCountryID(Integer.parseInt(request.getParameter("countryID")));
		cityVO.setCityName(request.getParameter("cityName"));
		cityVO.setStateID(stateVO);
		cityVO.setCountryID(countryVO);
		cityVO.setCityID(Integer.parseInt(request.getParameter("id1")));
		cityDAO.update(cityVO);
	
	
	
	
	
	
}
}