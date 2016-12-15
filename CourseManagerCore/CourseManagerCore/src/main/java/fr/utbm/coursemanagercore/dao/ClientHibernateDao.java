/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.dao;

import fr.utbm.coursemanagercore.entity.Client;
import fr.utbm.coursemanagercore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author @aarigoni
 */
public class ClientHibernateDao {
     
      /*
      create a client 
      */
       public int create(Client client) {
          Session session = HibernateUtil.getSessionFactory().openSession();
           int savedStatusFlag=0;
           try {
           session.beginTransaction();
            session.persist(client);
            
         session.getTransaction().commit();
            session.flush();
  savedStatusFlag = 1;
        }
    catch(HibernateException he){
            
            he.printStackTrace();
            if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace();
                    }
                    
                    
	        }
         savedStatusFlag = 0;
		}
        finally {
	        if(session != null) {
	            try { 
                        session.close();
                    }
                    catch(HibernateException he){
                        he.printStackTrace();
                    }
                }
}
           return savedStatusFlag;
       }
      /*
      get clients list from db
      */
   public List<Client> GetClienListDao(){
          Session session = HibernateUtil.getSessionFactory().openSession(); 
       List<Client> ClientList =new ArrayList<Client>();
      try{
            session.beginTransaction();
      
            session.getTransaction().commit();
            Client cl=new Client();
          Query query = session.createQuery("from Client");
         ClientList = query.list();
         
          System.out.println("####  "+ClientList.get(0).getCourseSessionID().getLocationID().getCity());
        }
        catch(HibernateException he){
            
            he.printStackTrace();
            if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
     
		}
        finally {
	        if(session != null) {
	            try { 
                        session.close();
                    }
                    catch(HibernateException he){
                        he.printStackTrace();
                    }
                }
      
        }
         return ClientList;
      }
/* 
get a client from db by a given id
*/
public Client GetClientByIdDao(int id){
 Session session = HibernateUtil.getSessionFactory().openSession();
    Client client=new Client();
   try{
            session.beginTransaction();
      
            session.getTransaction().commit();
           
         	Query q = session.createQuery("FROM client WHERE id = :id");
			q.setParameter("id",id);
        client = (Client) q.list().get(0);
        }
        catch(HibernateException he){
            
            he.printStackTrace();
            if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
     
		}
        finally {
	        if(session != null) {
	            try { 
                        session.close();
                    }
                    catch(HibernateException he){
                        he.printStackTrace();
                    }
                }
      
        }
return client;
}
/*
update a client in a db
*/
 public void UpdateClientDao(Client client) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     try {
           session.beginTransaction();
            session.merge(client);
             session.getTransaction().commit();
             
        } 
        catch(HibernateException he){
            
            he.printStackTrace();
            if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
     
		}
        finally {
	        if(session != null) {
	            try { 
                        session.close();
                    }
                    catch(HibernateException he){
                        he.printStackTrace();
                    }
                }
 }












}
 /*
 delete a client from db
 */
public void DeleteClientDao(Client client){
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
           session.beginTransaction();
            session.delete(client);
         session.getTransaction().commit();
            session.flush();

        }
    catch(HibernateException he){
            
            he.printStackTrace();
            if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
     
		}
        finally {
	        if(session != null) {
	            try { 
                        session.close();
                    }
                    catch(HibernateException he){
                        he.printStackTrace();
                    }
                }
}
}
}
