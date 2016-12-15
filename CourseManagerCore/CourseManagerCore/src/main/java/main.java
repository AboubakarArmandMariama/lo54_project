
import fr.utbm.coursemanagercore.entity.Client;
import fr.utbm.coursemanagercore.controller.DefaultClientController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class main {
    public static void main(String[] args) {
        
        DefaultClientController clientController= new DefaultClientController();
        List<Client> ClientList =new ArrayList<Client>();
        ClientList= clientController.GetClients();
        
        for (Iterator<Client> item = ClientList.iterator(); item.hasNext();) {
            Client next = item.next();
          ///  System.out.println("#   "+next.getFirstname());//+"  ,"+ next.getMainActorId().getFirstname());
        }
    
    }
}
