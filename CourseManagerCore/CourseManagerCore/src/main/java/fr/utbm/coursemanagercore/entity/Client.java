/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.entity;

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
 * @author ASUS
 */
@Entity
@Table(name="Client")
public class Client  implements java.io.Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")
     private int id;
@ManyToOne
@JoinColumn(name = "COURSE_SESSION_ID")
//@Column(name = "COURSE_SESSION_ID")

private CourseSession courseSessionID;
@Column(name ="LASTNAME")
     private String lastname;
@Column( name="FIRSTNAME")
     private String firstname;
@Column(name="ADDRESS")
     private String address;
@Column(name ="PHONE")
     private String phone;
@Column(name="EMAIL")
     private String email;
public Client(){
    
}
    public Client(int id, CourseSession courseSessionID, String lastname, String firstname, String address, String phone, String email) {
        this.id = id;
        this.courseSessionID = courseSessionID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseSession getCourseSessionID() {
        return courseSessionID;
    }

    public void setCourseSessionID(CourseSession courseSessionID) {
        this.courseSessionID = courseSessionID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

   
    }
   
    