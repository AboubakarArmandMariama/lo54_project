/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.dao;

import fr.utbm.coursemanagercore.entity.Location;
import fr.utbm.coursemanagercore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author @arrigoni
 */
public class LocationHibernateDao {
    /*
    create
    */
    public int CreateLocationDao(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
         int savedStatusFlag=0;
           try {
           session.beginTransaction();
            session.persist(location);
            
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
    get location by id
    */
    public Location GetLocationById(int id){
         Session session = HibernateUtil.getSessionFactory().openSession();
              Location location= new Location();
              try{
            session.beginTransaction();
      
            session.getTransaction().commit();
           
         	Query q = session.createQuery("FROM Location WHERE id = :id");
			q.setParameter("id",id);
        location = (Location) q.list().get(0);
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
              
             return location;
    }
    /*
    get all locations
    */
    public List<Location> GetLocationList(){
       Session session = HibernateUtil.getSessionFactory().openSession();
     
        List<Location> locationlist =new ArrayList<Location>();
              try{
            session.beginTransaction();
      
            session.getTransaction().commit();
          
          Query query = session.createQuery("from Location");
         locationlist = query.list();
         
        // System.out.println("####  "+courselist.get(0).getTitle());
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
        
        
        
        return locationlist;
    }
    /*
    update
    */
    public void UpdateLocationDao(Location location){
         Session session = HibernateUtil.getSessionFactory().openSession();
              try {
           session.beginTransaction();
            session.merge(location);
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
    delete
    */
    public void DeleteLocationDao(Location location){
        Session session = HibernateUtil.getSessionFactory().openSession();
              try {
           session.beginTransaction();
            session.delete(location);
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
}
