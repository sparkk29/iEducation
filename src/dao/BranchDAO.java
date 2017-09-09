package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.CountryVO;
import vo.StateVO;



public class BranchDAO {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public void update(BranchVO branchVO) {
		// TODO Auto-generated method stub
		
		try
		{	Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.saveOrUpdate(branchVO);
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public List edit(BranchVO sv) {
		// TODO Auto-generated method stub
		
		try
		{
			List list;
			Session ss=sf.openSession();
			Query q=ss.createQuery("from BranchVO where branchID="+sv.getBranchID());
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

		List ls=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from BranchVO");
				
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
	
	public void insert(BranchVO r) {

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
	public boolean delete(BranchVO del)
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