package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CountryVO;



public class CountryDAO {
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(CountryVO u) {

		
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
	
	
	public List edit(CountryVO d) {

		List lst=null;
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				Transaction tr=session.beginTransaction();
				
				Query q=session.createQuery("from CountryVO where id='"+d.getCountryID()+"'");
				
				lst=q.list();
				
			
				tr.commit();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return lst;
	}
	
	public boolean delete(CountryVO del)
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
	
	
	public List search() {

		List lst1=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				System.out.println("Inserting Record");
				
				Query q=session.createQuery("from CountryVO");
				
				lst1=q.list();
				
			
				System.out.println("Done = "+lst1.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst1;
	}
	
	
	public void insert(CountryVO r) {

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
	
	
}

