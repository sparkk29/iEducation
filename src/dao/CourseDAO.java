package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CountryVO;
import vo.CourseVO;
import vo.StateVO;

public class CourseDAO {
	
	
	public List search() {

		List lst=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from CourseVO");
				
				lst=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+lst.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst;
	}
	
	
	
	
	
	
	public void insert(CourseVO r) {

		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			// Create new instance of Contact and set values in it by reading
			// them from form object
			System.out.println("Inserting Record");
			// System.out.println(r.getCat_id());
			session.save(r);

			// session.save(a);
			tr.commit();
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			//session.flush();
			//session.close();

		}
	
	

	}
	
SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(CourseVO courseVO) {
		// TODO Auto-generated method stub
		
		try
		{	Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(courseVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(CourseVO cv) {
		// TODO Auto-generated method stub
		
		try
		{
			List list;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from CourseVO where courseID="+cv.getCourseID());
			list=q.list();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delete(CourseVO del)
	{
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(del);
			tr.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}


}
