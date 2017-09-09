package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CityVO;
import vo.CountryVO;
import vo.FaqVO;

public class FaqDAO {
	
	public void update(FaqVO u) {

		
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
		
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(u);
			
			tr.commit();
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	
	public List edit(FaqVO d) {

		List lst=null;
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				Transaction tr=session.beginTransaction();
				
				Query q=session.createQuery("from FaqVO where id='"+d.getFaqID()+"'");
				
				lst=q.list();
				
			
				tr.commit();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return lst;
	}
	
	public List search() {

		List lst=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				System.out.println("Inserting Record");
				
				Query q=session.createQuery("from FaqVO");
				
				lst=q.list();
				
			
				System.out.println("Done = "+lst.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst;
	}
	public void insert(FaqVO r) {

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
	
	public boolean delete(FaqVO del)
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
