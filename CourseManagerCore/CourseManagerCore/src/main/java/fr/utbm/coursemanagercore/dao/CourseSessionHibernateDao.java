/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.dao;

import fr.utbm.coursemanagercore.entity.CourseSession;
import fr.utbm.coursemanagercore.entity.Location;
import fr.utbm.coursemanagercore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author @aarigoni
 */
public class CourseSessionHibernateDao {
    /*
    create a course session
    */
    public int CreateCourSession(CourseSession coursesession){
         Session session = HibernateUtil.getSessionFactory().openSession();
         int savedStatusFlag=0;
           try {
           session.beginTransaction();
            session.persist(coursesession);
            
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
    get a course session by an id
    */
    public CourseSession GetCourseSessionById(int id){
         Session session = HibernateUtil.getSessionFactory().openSession();
              CourseSession coursesession= new CourseSession();
              try{
            session.beginTransaction();
      
            session.getTransaction().commit();
           
         	Query q = session.createQuery("FROM CourseSession WHERE id = :id");
			q.setParameter("id",id);
        coursesession = (CourseSession) q.list().get(0);
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
              
             return coursesession;
    }
    
    /*
    get list of all course sessions 
    */
    public List<CourseSession> GetCourseSessionList(){
       Session session = HibernateUtil.getSessionFactory().openSession();
              List<CourseSession> coursesessionlist =new ArrayList<CourseSession>();
                
                 try{
            session.beginTransaction();
      
            session.getTransaction().commit();
          
          Query query = session.createQuery("from CourseSession");
         coursesessionlist = query.list();
         
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
                return coursesessionlist;  
    }
    
    /*
    get list of course sessions  by course code
    */
     public List<CourseSession> GetCourseSessionBycode(String CourseCode){
         Session session = HibernateUtil.getSessionFactory().openSession();
              List<CourseSession> coursesessionlist =new ArrayList<CourseSession>();
                
                 try{
            session.beginTransaction();
      
            session.getTransaction().commit();
          
          Query query = session.createQuery("FROM CourseSession WHERE COURSE_CODE = :code");
         query.setParameter("code", CourseCode);
          coursesessionlist = query.list();
         
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
                return coursesessionlist;  
     }
     /*
     get course session list by start date
     */
     
	public List<CourseSession> filterByStartDate(Date startDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.eq("startDate",startDate));
			course_sessions = criteria.list();
			
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
        get course session list filter by endate 
        */
        
	public List<CourseSession> filterByEndDate(Date endDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.eq("endDate",endDate));
			course_sessions = criteria.list();
			
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
        get course session between two date
        */
        public List<CourseSession> filterByDates(Date startDate, Date endDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.conjunction()
					.add(Restrictions.ge("startDate", startDate))
					.add(Restrictions.le("endDate", endDate)));
			course_sessions = criteria.list();
			
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
        get course sessions list by location
        */
         public List<CourseSession> filterByLocation(List<Location> ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> course_sessions = new ArrayList<CourseSession>();
        try {
            Query q = session.createQuery("FROM CourseSession WHERE location IN (:location)");
            q.setParameterList("location", ids);
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

    /* update
   
    */
        public void UpdateCourseSession(CourseSession coursesession){
             Session session = HibernateUtil.getSessionFactory().openSession();
              try {
           session.beginTransaction();
            session.merge(coursesession);
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
    /* delete
    
    */
        public void DeleteCourseSessionDao(CourseSession coursesession){
             Session session = HibernateUtil.getSessionFactory().openSession();
              try {
           session.beginTransaction();
            session.delete(coursesession);
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
