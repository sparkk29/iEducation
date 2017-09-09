package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CityVO;
import vo.ManageExamVO;
import vo.SubjectVO;


public class ManageExamDAO {
	
	public List search() {

		List lst=new ArrayList();
			try {

				SessionFactory sf=new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				System.out.println("Searching State Record");
				Query q=session.createQuery("from ManageExamVO");
				
				lst=q.list();
				
				System.out.println("Done = "+lst.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst;
	}
	
	public boolean delete(ManageExamVO del)
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

	public void insert(ManageExamVO r) {

		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
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

	
	public void update(ManageExamVO examVO) {
		// TODO Auto-generated method stub
		
		try
		{	
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(examVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(ManageExamVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List lstexam;
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Query q=ss.createQuery("from ManageExamVO where examID="+sv.getExamID());
			lstexam=q.list();
			return lstexam;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List search1(long uid) {

		List lst=new ArrayList();
			try {

				SessionFactory sf=new Configuration().configure().buildSessionFactory();
				Session session = sf.openSession();
				System.out.println("Searching State Record");
				Query q=session.createQuery("from ManageExamVO where examID not in(select examID from ApplyExamVO where userID='"+uid+"')");
				
				lst=q.list();
				
				System.out.println("Done = "+lst.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst;
	}
	
}
