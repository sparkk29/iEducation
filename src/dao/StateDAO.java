package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import vo.CountryVO;
import vo.StateVO;

public class StateDAO {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(StateVO stateVO) {
		// TODO Auto-generated method stub
		
		try
		{	Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(stateVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(StateVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List list;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from StateVO where stateID="+sv.getStateID());
			list=q.list();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List search() {
		

		List ls1=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Searching State Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from StateVO");
				
				ls1=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+ls1.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ls1;
	}
	
	public void insert(StateVO r) {

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
	public boolean delete(StateVO del)
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
	
	public List loadState(CountryVO countryvo) {
		// TODO Auto-generated method stub
		
		
		   SessionFactory sf=new Configuration().configure().buildSessionFactory();
			List ls1=new ArrayList();
			Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			Query q=ss.createQuery("from StateVO where countryID = "+countryvo.getCountryID());
			ls1=q.list();
			return ls1;
		}

}
