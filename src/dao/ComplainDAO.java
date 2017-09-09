
package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.ComplainVO;
import vo.FaqVO;

public class ComplainDAO {
	
	public List search() {

		List list33=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				System.out.println("Inserting Record");
				
				Query q=session.createQuery("from ComplainVO");
				
				list33=q.list();
				
			
				System.out.println("Done = "+list33.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list33;
	}
	public void insert(ComplainVO r) {

		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			System.out.println("Inserting Record");
			
			session.save(r);

			
			tr.commit();
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			
		}
}
	

}
