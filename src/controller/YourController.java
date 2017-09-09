package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttachmentDAO;
import dao.AttachmentMappingDAO;
import dao.BranchDAO;
import dao.CourseDAO;
import dao.SemesterDAO;
import dao.SubjectDAO;
import vo.AttachmentMappingVO;
import vo.AttachmentVO;
import vo.BranchVO;
import vo.CourseVO;
import vo.SemesterVO;
import vo.SubjectVO;



/**
 * Servlet implementation class AttachmentController
 */
@WebServlet("/YourController")
public class YourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourController() {
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
		
		if(flag.equals("loadMaterial"))
		{
			load(request,response);
		}
			
		
		String mode = request.getParameter("mode");
		
		
		if(mode!=null && mode.equals("3")){
			edit(request, response);
				
				}else if(mode!=null && mode.equals("4")){
					    delete(request, response);	
							
						}else if(mode!=null && mode.equals("5")){
								show(request, response);	
							     
					 		}else if(flag.equals("show")){
								show(request,response);
					 			
					 			}else if(flag.equals("download")){
					 				download(request,response);
								
							}else{
									//default 
								
									response.sendRedirect(request.getContextPath()+"/Faculty/Add_Material.jsp");
									}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CourseDAO d=new CourseDAO();
		List lst=d.search();
		HttpSession session=request.getSession();
		session.setAttribute("key",lst);
		System.out.println("Size Of List ::"+lst.size());
		
		
		BranchDAO x=new BranchDAO();
		List ls=x.search();
		HttpSession session1=request.getSession();
		session1.setAttribute("key1",ls);
		System.out.println("Size Of List ::"+ls.size());
	 		
  
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
		
		//response.sendRedirect("/Faculty/Add_Material.jsp");
				
		
}
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int attachmentID = Integer.parseInt(request.getParameter("id"));
		AttachmentVO attachVO = new AttachmentVO();
		attachVO.setAttachmentID(attachmentID);
		
		AttachmentDAO attachDAO = new AttachmentDAO();
		attachDAO.delete(attachVO);
		
		
		show(request, response);
	
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int attachmentMappingID = Integer.parseInt(request.getParameter("id"));
		AttachmentMappingVO attachMPG_VO = new AttachmentMappingVO();
		attachMPG_VO.setAttachmentMappingID(attachmentMappingID);
		
		AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();
		attachMPG_DAO.delete(attachMPG_VO);
		
		show(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String mode = request.getParameter("mode");
		
		
		if(mode!=null && mode.equals("6")){
			deleteSelected(request, response);
			
			}else if(mode!=null && mode.equals("1")){
					insert(request, response);
					
					}
		
		
		
		
	}
	
protected void deleteSelected(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String[] attachmentMappingID = request.getParameterValues("list") ;
	
	AttachmentMappingVO attachMPG_VO = new AttachmentMappingVO();
	AttachmentMappingDAO attachMPG_DAO = new AttachmentMappingDAO();
	
	
	for (int i = 0; i < attachmentMappingID.length; i++) {
		
		attachMPG_VO.setAttachmentMappingID(Integer.parseInt(attachmentMappingID[i]));
		
		attachMPG_DAO.delete(attachMPG_VO);
		
	}
	
	
	show(request, response);
	
	
		
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int  id=Integer.parseInt(request.getParameter("courseID"));
		int  id1=Integer.parseInt(request.getParameter("branchID"));
		int  id2=Integer.parseInt(request.getParameter("semesterID"));
		int  id3=Integer.parseInt(request.getParameter("subjectID"));

		CourseVO cv=new CourseVO();
		cv.setCourseID(id);
		
		BranchVO bv=new BranchVO();
		bv.setBranchID(id1);
		
		SemesterVO sv=new SemesterVO();
		sv.setSemesterID(id2);
		
		SubjectVO sb= new SubjectVO();
		sb.setSubjectID(id3);
		
		
		
		String attachmentType = request.getParameter("attachmentType");
		System.out.println("attachment="+attachmentType);
		String materialType = request.getParameter("materialType");
		System.out.println("material"+materialType);
		
		AttachmentVO attachmentVO = new AttachmentVO();
		attachmentVO.setAttachmentType(attachmentType);
		attachmentVO.setMaterialType(materialType);
		attachmentVO.setCourseID(cv);
		attachmentVO.setBranchID(bv);
		attachmentVO.setSemesterID(sv);
		attachmentVO.setSubjectID(sb);

		
		AttachmentDAO attachmentDAO = new AttachmentDAO();
		attachmentDAO.insert(attachmentVO);
		
		
		AttachmentMappingVO attachMPGVO = new AttachmentMappingVO();
		
		attachMPGVO.setAttachmentID(attachmentVO);

		
		

		AttachmentMappingDAO attachMPG_DAO= new AttachmentMappingDAO();
		
		
		//getting file from Session
		
		HttpSession session =request.getSession();
		
		List myList=(List)session.getAttribute("fileList");
		System.out.println("file list size"+myList);
		
		 Iterator itr =  myList.iterator();
         
         System.out.println("Reading for session");
         int i =0;
         while (itr.hasNext()) {
     
        	 attachMPGVO.setAttachmentName("Photo"+i);
        	 attachMPGVO.setPath((String)itr.next());
        	 
        	 attachMPG_DAO.insert(attachMPGVO);
        	 
        	 i++;
			}
		

		
		session.removeAttribute("fileList");
				
		
		
		
		show(request, response);
		
		
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttachmentMappingDAO attachDAO = new AttachmentMappingDAO();
		List myList = attachDAO.showAll();
		HttpSession session = request.getSession();
		
		session.setAttribute("myList", myList);
		
		
		AttachmentDAO attDAO = new AttachmentDAO();
		List myList1 = attDAO.showAll();
		
		System.out.println("ls jj size"+myList1.size());
		session.setAttribute("myList1", myList1);
		
				
		
		
		response.sendRedirect(request.getContextPath()+"/Faculty/show.jsp");
		
		
		
	}
	
protected void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttachmentMappingDAO attachDAO = new AttachmentMappingDAO();
		List myList = attachDAO.showAll();
		HttpSession session = request.getSession();
		
		session.setAttribute("myList", myList);
		
		
		AttachmentDAO attDAO = new AttachmentDAO();
		List myList1 = attDAO.showAll();
		
		System.out.println("ls jj size"+myList1.size());
		session.setAttribute("myList1", myList1);
		
				
		
		
		response.sendRedirect(request.getContextPath()+"/User/Download.jsp");
		
		
		
	}

}
