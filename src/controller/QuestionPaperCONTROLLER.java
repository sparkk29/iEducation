package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;

import vo.ApplyExamVO;
import vo.BranchVO;
import vo.CityVO;
import vo.CourseVO;
import vo.ManageExamVO;
import vo.QuestionPaperVO;
import vo.SemesterVO;
import vo.StudentRegisterVO;
import vo.SubjectVO;
import vo.UserTypeVO;
import dao.ApplyExamDAO;
import dao.BranchDAO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.CourseDAO;
import dao.ManageExamDAO;
import dao.QuestionPaperDAO;
import dao.ResultDAO;
import dao.SemesterDAO;
import dao.StateDAO;
import dao.StudentRegisterDAO;
import dao.SubjectDAO;

/**
 * Servlet implementation class QuestionPaperCONTROLLER
 */
@WebServlet("/QuestionPaperCONTROLLER")
public class QuestionPaperCONTROLLER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionPaperCONTROLLER() {
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
		else if(flag.equals("searchQuestion"))
		{
			search(request,response);
		}
		else if(flag.equals("editQuestion"))
		{
			edit(request,response);
		}
		else if(flag.equals("delete"))
		{
				delete(request,response);
				search(request,response);
		}
		else if(flag.equals("loadQuestion"))
		{
				loadQuestion(request,response);
				
		}
		
		else if(flag.equals("loadResult"))
		{
				loadResult(request,response);
				
		}
		else if(flag.equals("viewResult"))
		{
				viewResult(request,response);
				
		}
		
	}
	

	private void viewResult(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		StudentRegisterVO sv=new StudentRegisterVO();
		StudentRegisterDAO sr=new StudentRegisterDAO();
		
		List ls=sr.search(sv);
		session.setAttribute("viewResult", ls);
		response.sendRedirect("Faculty/View_Result.jsp");
	}

	private void loadResult(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		long temp=(long) session.getAttribute("userID");
		UserTypeVO ut=new UserTypeVO();
		ut.setUserID(temp);
		
		
		ResultDAO rd= new ResultDAO();
		List ls=rd.search(ut);
		
		System.out.println("list size jj"+ls.size());
		session.setAttribute("key", ls);
		
		response.sendRedirect("User/Result.jsp");
		
		
	}

	private void loadQuestion(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String strid =request.getParameter("id");
		
		List ls=null;
		HttpSession session=request.getSession();
		
		if(strid!=null){
			Integer id=Integer.parseInt(strid);
			QuestionPaperDAO qd=new QuestionPaperDAO();
			ls=qd.loadQuestion(id);	
			session.setAttribute("loadQuestion",ls);
		
			
			
			////////////////////////////////
			
			/*ApplyExamVO ae =new ApplyExamVO();
			ae.setApplyExamID(id);
			
			UserTypeVO ut=new UserTypeVO();
			ut.setUserID(id);
			
			ApplyExamDAO aed= new ApplyExamDAO();
			aed.insert(ae);*/
			
			/////////////////////////
			
		}
		else{
			
			ls=(List)session.getAttribute("loadQuestion");
			
			
		}
		

		result(request, response);
		
		
		
 		Integer ques = (Integer)session.getAttribute("quecnt");
 		
 		System.out.println("kkkkkkkkkkkkkkkkk"+ques);
 		if(ques==null)
 		{
 			ques=0;
 			System.out.println("First Time");
 			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("examid",strid);
 			
 		}
 		else{
 			ques=ques+1;
 			
 		}
 		session.setAttribute("quecnt",ques);
 		
 		if(ls.size()!=ques)
 		{
 			session.setAttribute("quesvoobj",ls.get(ques) );
 			System.out.println("in Controller::"+ls.size());
		}
 		else
 		{
 			session.removeAttribute("loadQuestion");
 			session.removeAttribute("quecnt");
 			session.removeAttribute("quesvoobj");
 			session.setAttribute("showresult","true" );
 			////////////////////////
 			
 			int id1=Integer.parseInt((String) request.getSession().getAttribute("examid"));
 			
 			ManageExamVO manageExamVO=new ManageExamVO();
 			manageExamVO.setExamID(id1);
 			long uid=(Long) request.getSession().getAttribute("userID");
 			UserTypeVO userTypeVO=new UserTypeVO();
 			userTypeVO.setUserID(uid);
 			
 			ApplyExamVO applyExamVO=new ApplyExamVO();
 			applyExamVO.setExamID(manageExamVO);
 			applyExamVO.setUserID(userTypeVO);
 			int result=(Integer)session.getAttribute("result");
 			applyExamVO.setResult(result);
 			ApplyExamDAO applyExamDAO=new ApplyExamDAO();
 			
 			
 			System.out.println("Insert Exam Detail:::");
 			applyExamDAO.insert(applyExamVO);
 			
 			
 			//////////////////////
 			
 			
 			
 		}
 		response.sendRedirect("User/Questions.jsp");

 		
		
		
	}
	public void result (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session=request.getSession();
		if(session.getAttribute("quecnt")!=null){
		String quest =request.getParameter(session.getAttribute("quecnt").toString());
 		QuestionPaperVO questobj = (QuestionPaperVO)session.getAttribute("quesvoobj");
 		
 		if(quest!=null && questobj.getCorrectAns().equals(quest))
 		{
 			Integer result = (Integer)session.getAttribute("result");
 			if(result==null)
 			{
 				result=1;
 			}
 			else{
 				result = result+1;
 			
 			}
 			session.setAttribute("result", result);
 			System.out.println("result::::::::::::;"+result);
 		}
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

	int  id=Integer.parseInt(request.getParameter("examID"));
	

	String s=request.getParameter("question");
	String s1=request.getParameter("ans1");
	String s2=request.getParameter("ans2");
	String s3=request.getParameter("ans3");
	String s4=request.getParameter("ans4");
	String s5=request.getParameter("correctAns");
	
ManageExamVO me=new ManageExamVO();
me.setExamID(id);
	
	
		QuestionPaperVO q=new QuestionPaperVO();
		q.setQuestion(s);
		q.setAns1(s1);
		q.setAns2(s2);
		q.setAns3(s3);
		q.setAns4(s4);
		q.setCorrectAns(s5);
		q.setExamID(me);
		
		QuestionPaperDAO d=new QuestionPaperDAO();
		d.insert(q);
		response.sendRedirect("Faculty/Add_Question.jsp");

}

protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ManageExamDAO d=new ManageExamDAO();
		List lst=d.search();
		HttpSession session=request.getSession();
		session.setAttribute("key1",lst);
		System.out.println("Size Of List ::"+lst.size());
		response.sendRedirect("Faculty/Add_Question.jsp");
		
		
		
				
		
}
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	QuestionPaperDAO d=new QuestionPaperDAO();
	
 		List ls=d.search();
 		HttpSession session1=request.getSession();
 		session1.setAttribute("key",ls);
 		System.out.println("Size Of List ::"+ls.size());
 		response.sendRedirect("Faculty/Search_Question.jsp");
 		
 		
}

private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(request.getParameter("id"));
	QuestionPaperVO cv=new QuestionPaperVO();
	cv.setQuestionpaperID(id);
		
	ManageExamDAO cd=new ManageExamDAO();
	
	List lstexam=cd.search();
	HttpSession hs=request.getSession();
	hs.setAttribute("loadExam", lstexam);
	
	
	
	
	QuestionPaperDAO qp=new QuestionPaperDAO();
	List l4=qp.edit(cv);

	hs.setAttribute("key1", l4);
	
	response.sendRedirect("Faculty/Edit_Question.jsp");

}

protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ManageExamVO cv=new ManageExamVO();
	cv.setExamID(Integer.parseInt(request.getParameter("examID")));
	
	
	QuestionPaperDAO md=new QuestionPaperDAO();
	QuestionPaperVO mv=new QuestionPaperVO();
	mv.setQuestionpaperID(Integer.parseInt(request.getParameter("id")));
	
	mv.setExamID(cv);
	
	mv.setQuestion(request.getParameter("question"));
	mv.setAns1(request.getParameter("ans1"));
	mv.setAns2(request.getParameter("ans2"));
	mv.setAns3(request.getParameter("ans3"));
	mv.setAns4(request.getParameter("ans4"));
	mv.setCorrectAns(request.getParameter("correctAns"));
	
	md.update(mv);
			
	}
private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	

	int id=Integer.parseInt(request.getParameter("id"));
	QuestionPaperVO cv=new QuestionPaperVO();
	cv.setQuestionpaperID(id);
	QuestionPaperDAO cd=new QuestionPaperDAO();
	
	
	 
	
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


