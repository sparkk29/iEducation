package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vo.AttachmentMappingVO;
import lscd.*;


public class AttachmentMappingDAO {
	
	
	public void insert(AttachmentMappingVO VO_obj){
		
		Session session = null;
		
		 try{
			  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static 
			  
			  Transaction t= session.beginTransaction();
			
			  session.save(VO_obj);
			  
			  t.commit();
			
			
	    }catch(Exception e){
			  System.out.println(e.getMessage());
			  
			  }finally{
			        
				      session.close();
			  
			          }
			  
			  
		
	}
	
	
	
  public List getElementByID(AttachmentMappingVO VO_obj){
		
		Session session = null;
		List temp = null;
		
		
		try{
		  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static
		
		    Transaction tr = session.beginTransaction();
		 
		    Query q = session.createQuery("FROM AttachmentMappingVO WHERE attachmentMappingID = '"+VO_obj.getAttachmentMappingID()+"'");
		    temp = q.list();
		
		    tr.commit();
		 
		 }catch(Exception e){
			                 System.out.println(e.getMessage());
		  					}finally{
		  							
		  							session.close();
		  
		  							}
		  
		 return temp;
		
			
	}
  
  public void update(AttachmentMappingVO VO_obj){
	  
		Session session = null;
		
		  try{
		  
			  session = MyUtility.getSession();// Static Method which makes only one object as method is static
		
			  Transaction tr = session.beginTransaction();
		 
			  session.update(VO_obj);
		 
			  tr.commit();
		 
		  }catch(Exception e){
			  				
			  				System.out.println(e.getMessage());
		  					}finally{
		  						    session.close();
		  							}
		  
		}
  
  
  public void deleteCustom(AttachmentMappingVO VO_obj){
		
		Session session = null;
		
		 try{
			  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static
			 
			  Transaction t= session.beginTransaction();
			  String hql = "DELETE FROM AttachmentMappingVO "  + 
			             "WHERE attachmentID = :attachmentID";
			  
			  Query query = session.createQuery(hql);
			  query.setParameter("attachmentID", VO_obj.getAttachmentID());
			  
			  query.executeUpdate();
			
			  t.commit();
			
			
			  }catch(Exception e){
				  	
				  				System.out.println(e.getMessage());
			  					}finally{
			  							session.close();
			  
			  							}
			  
			  
		
	}
	

  
	public void delete(AttachmentMappingVO VO_obj){
		
		Session session = null;
		
		 try{
			  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static
			 
			  Transaction t= session.beginTransaction();

			  session.delete(VO_obj);
			
			  t.commit();
			
			
			  }catch(Exception e){
				  	
				  				System.out.println(e.getMessage());
			  					}finally{
			  							session.close();
			  
			  							}
			  
			  
		
	}
	
  public List showAll(){
		
		Session session = null;
		List temp = null;
		  try{
		  
			  session = MyUtility.getSession();// Static Method which makes only one object as method is static
		
			  Query q = session.createQuery("FROM AttachmentMappingVO ");
		 
			  temp = q.list();
		  	
		  }catch(Exception e){
			  				  System.out.println(e.getMessage());
		  					 }finally{
		  						     session.close();
		  					 		 }
		 return temp;
		
		}	
  
  public List  search(AttachmentMappingVO VO_obj){
		
		Session session = null;
	    List temp = null;
	 
	    try{
	 
	    	session = MyUtility.getSession();// Static Method which makes only one object as method is static
			

	    	Query q = session.createQuery("FROM AttachmentMappingVO WHERE attachmentName like '%"+VO_obj.getAttachmentName() +"%' ");

	    	temp = q.list();
	
	    }catch(Exception e){
	 		    	System.out.println(e.getMessage());
	    		}finally{
	    				session.close();
	    				}
	return temp;
}
	
	
	

}
