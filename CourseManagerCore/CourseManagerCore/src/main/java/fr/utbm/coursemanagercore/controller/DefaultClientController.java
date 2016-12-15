/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursemanagercore.controller;

import fr.utbm.coursemanagercore.entity.Client;
import fr.utbm.coursemanagercore.service.ClientService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DefaultClientController {
    ClientService clientservice=new ClientService();
    
    /* Get all registred Clients registred
    */
    public List<Client>  GetClients(){
        List<Client> ClientList =new ArrayList<Client>();
        ClientList=clientservice.GetClientDao();
        
        return ClientList;
    }
    /*
   // get a client by a given ID
    */
    public Client GetClientbyId(int id){
        Client client=new Client();
        
        // 
        
        return client;
    }
}
