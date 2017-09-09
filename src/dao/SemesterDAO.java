package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.SemesterVO;


public class SemesterDAO {
	public List search() {

		List l=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from SemesterVO");
				
				l=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+l.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l;
	}
	
	public void insert(SemesterVO r) {

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
	
	public void update(SemesterVO semesterVO) {
		// TODO Auto-generated method stub
		
		try
		{	Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(semesterVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(SemesterVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List list;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from SemesterVO where semesterID="+sv.getSemesterID());
			list=q.list();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public boolean delete(SemesterVO del)
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
