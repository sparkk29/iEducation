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
import vo.SubjectVO;


public class SubjectDAO {
	public List search() {

		List l1=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from SubjectVO");
				
				l1=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+l1.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l1;
	}
	
	public void insert(SubjectVO r) {

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
	
	public void update(SubjectVO subjectVO) {
		// TODO Auto-generated method stub
		
		try
		{	Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(subjectVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(SubjectVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List l4;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from SubjectVO where subjectID="+sv.getSubjectID());
			l4=q.list();
			return l4;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public boolean delete(SubjectVO del)
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
