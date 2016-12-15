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
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name="Location")
public class Location  implements java.io.Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
@Column
     private String city;
 public Location(){
     
 }
    public Location(int id, String city) {
        this.id = id;
        this.city = city;
    }


   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


 



}


