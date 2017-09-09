package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.UserTypeVO;

public class ResultDAO {
	
	public List search(UserTypeVO ut) {

		List lstResult=new ArrayList();
			try {

				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionFactory.openSession();
			
				
				System.out.println("Inserting Record");
				
				Query q=session.createQuery("from ApplyExamVO where userID="+ut.getUserID());
				
				 lstResult=q.list();
				
			
				System.out.println("Done = "+ lstResult.size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  lstResult;
	}

}
