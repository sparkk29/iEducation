package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CityVO;
import vo.QuestionPaperVO;
import vo.SemesterVO;
import vo.SubjectVO;

public class QuestionPaperDAO {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(QuestionPaperVO d) {
		// TODO Auto-generated method stub
		try
		{
			Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(d);
			t.commit();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List edit(QuestionPaperVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List l4;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from QuestionPaperVO where questionpaperID="+sv.getQuestionpaperID());
			l4=q.list();
			return l4;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List search() {

		List ls=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Searching State Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from QuestionPaperVO");
				
				ls=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+ls.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ls;
	}
	public void insert(QuestionPaperVO r) {

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
	public boolean delete(QuestionPaperVO del)
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

	public List loadQuestion(int id)
	{
		List ls=new ArrayList();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
		
			Query q=session.createQuery("from QuestionPaperVO where examID="+id);
			
			ls=q.list();
			
			System.out.println("Done = "+ls.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ls;
	}
}
