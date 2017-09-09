package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.UserTypeVO;

public class UserTypeDAO {
	
	public List search() {

		List userlist=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from UserTypeVO");
				
				userlist=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+userlist.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return userlist;
	}

		public void insert(UserTypeVO r) {

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
		
		public List edit(UserTypeVO v)
		{
			List userlist=null;
			try
			{
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				
				Session session=sessionFactory.openSession();
				
				Transaction tr=session.beginTransaction();
				
				Query w=session.createQuery("from UserTypeVO where userid='"+v.getUserID()+"' ");
				
				userlist=w.list();
				
				tr.commit();
			}
			catch(Exception z)
			{
				z.printStackTrace();
			}
			return userlist;
		}


		public void update(UserTypeVO v)
		{
			try
			{
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				
				Session session=sessionFactory.openSession();
				
				Transaction tr=session.beginTransaction();
				
				session.saveOrUpdate(v);
				
				tr.commit();
			}
			catch(Exception z)
			{
				z.printStackTrace();
			}
		
		
		}	
		public boolean delete(UserTypeVO v)
		{
			try
			{
				SessionFactory sf=new Configuration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				ss.delete(v);
				Transaction t=ss.beginTransaction();
				t.commit();
				return true;
				}
			catch(Exception e)
			{
				return false;
			}
		}

		public List authentication(UserTypeVO registrationMstVO) {
			// TODO Auto-generated method stub
			String uname=registrationMstVO.getUsername();
			String pass=registrationMstVO.getPassword();
			List userlist = null;
			try {
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				System.out.println("Inserting Record");
				Query q=session.createQuery("from UserTypeVO where username='"+registrationMstVO.getUsername()+"' AND password='"+registrationMstVO.getPassword()+"'");
				
				userlist=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+userlist.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			return userlist;
		}

		public List search1() {
			// TODO Auto-generated method stub
			
			
			List lst61= new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from UserTypeVO where usertype='Student'");
				
				lst61=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+lst61.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst61;
		}

		public List search2() {
			// TODO Auto-generated method stub
			List lst62= new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				//Transaction tr = session.beginTransaction();
				// Create new instance of Contact and set values in it by reading
				// them from form object
				System.out.println("Inserting Record");
				// System.out.println(r.getCat_id());
				Query q=session.createQuery("from UserTypeVO where usertype='Faculty'");
				
				lst62=q.list();
				
				//session.save(r);

				// session.save(a);
				//tr.commit();
				System.out.println("Done = "+lst62.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lst62;
		}

}
