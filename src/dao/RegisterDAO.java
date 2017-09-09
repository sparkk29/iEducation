package dao;

import java.util.ArrayList;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.RegisterVO;


public class RegisterDAO {
	
	public void insert(RegisterVO r) {

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

	
	public List authentication(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		String uname=registerVO.getUsername();
		String pass=registerVO.getPassword();
		List ls = null;
		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
		
			System.out.println("Inserting Record");
			Query q=session.createQuery("from RegisterVO where username='"+registerVO.getUsername()+"' AND password='"+registerVO.getPassword()+"'");
			
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
	}	
	



