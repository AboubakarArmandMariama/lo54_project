/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @aarigoni
 */
@Entity
@Table(name="CourseSession")
public class CourseSession  implements java.io.Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
@ManyToOne
@JoinColumn(name = "Course_Code")

     private Course courseCode;
@ManyToOne
@JoinColumn(name = "Location_ID")
     private Location locationID;
@Column
     private Date startDate;
@Column
     private Date endDate;
 public CourseSession(){
     
 }
    public CourseSession(int id, Course courseCode, Location locationID, Date startDate, Date endDate) {
        this.id = id;
        this.courseCode = courseCode;
        this.locationID = locationID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

   
  


}


