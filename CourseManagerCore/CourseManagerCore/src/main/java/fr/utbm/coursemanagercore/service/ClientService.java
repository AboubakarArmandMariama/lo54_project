/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.service;

import fr.utbm.coursemanagercore.entity.Client;
import fr.utbm.coursemanagercore.dao.ClientHibernateDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ClientService {
    ClientHibernateDao clientdao = new ClientHibernateDao();
    /*
  get clients list from dao layer
    */
 public List<Client> GetClientDao(){
       List<Client> ClientList =new ArrayList<Client>();
     ClientList=   clientdao.GetClienListDao();
     
        return ClientList;
 }
 /* 
 get a client by an given id
 */
 public Client GetClientbyId(int id){
     Client client = new Client();
     
     
     return client;
 }
}
