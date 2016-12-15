/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.dao;

import fr.utbm.coursemanagercore.entity.Course;
import fr.utbm.coursemanagercore.entity.CourseSession;
import fr.utbm.coursemanagercore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class CourseHibernateDao {
          
          
          /*
          create a course session
          */
          public int CreateCourseDao(Course course){
              Session session = HibernateUtil.getSessionFactory().openSession();
              int savedStatusFlag=0;
           try {
           session.beginTransaction();
            session.persist(course);
            
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
          get Course by id
          */
          public Course GetCourseById(int id){
              Session session = HibernateUtil.getSessionFactory().openSession();
              Course course= new Course();
              try{
            session.beginTransaction();
      
            session.getTransaction().commit();
           
         	Query q = session.createQuery("FROM Course WHERE id = :id");
			q.setParameter("id",id);
        course = (Course) q.list().get(0);
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
              
             return course;
          }
          
          /*
          get list of course in db
          */
          public List<Course> GetCourse(){
                Session session = HibernateUtil.getSessionFactory().openSession();
              List<Course> courselist =new ArrayList<Course>();
                
                 try{
            session.beginTransaction();
      
            session.getTransaction().commit();
          
          Query query = session.createQuery("from course");
         courselist = query.list();
         
         System.out.println("####  "+courselist.get(0).getTitle());
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
                return courselist;
          }
           /*
          filter course with keywords
          */
         
    public List<CourseSession> filterByKeyword(List<String> keywords) {
    Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> course_sessions = new ArrayList<CourseSession>();
        try {
            Query q = session.createQuery("FROM CourseSession WHERE course.title in (:keys)");
            q.setParameterList("keys", keywords);
            course_sessions = q.list();
         
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException f) {
                    f.printStackTrace();
                }
            }
        }
        return course_sessions;
    }
          /*
          Update a course in a database
          */
          public void UpdateCourseDao(Course course){
            Session session = HibernateUtil.getSessionFactory().openSession();
              try {
           session.beginTransaction();
            session.merge(course);
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
          delete a course in a database
          */
          public void DeleteCourseDao(Course course){
            Session session = HibernateUtil.getSessionFactory().openSession(); 
              try {
           session.beginTransaction();
            session.delete(course);
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
