package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CityVO;
import vo.StateVO;

public class CityDAO {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(CityVO d) {
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
	
	public List edit(CityVO v) {
		try
		{
			Session ss=sf.openSession();
			Query q=ss.createQuery("from CityVO where cityID="+v.getCityID());
			List lst1=q.list();

			return lst1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;


	}
	
	public List search() {

		List l=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				System.out.println("Searching State Record");
				
				Query q=session.createQuery("from CityVO");
				
				l=q.list();
				
				
				System.out.println("Done = "+l.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l;
	}
	
	public void insert(CityVO r) {

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
	
	public boolean delete(CityVO del)
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
