/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.ClientDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author root
 */
public class ClientDAOImpl extends GenericDAOImpl<Client, String> implements ClientDAO{
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwintyPU");
     
    
   private static <T> T first(List<T> items) {
    return items == null || items.isEmpty() ? null : items.get(0);
}
   
    public Client findByUsername(String username){
        EntityManager em = emf.createEntityManager();
        Client client = null;
        //Client result = (Client) first(em.createQuery("select c from Client c where c.clientusername like :username").setParameter("username", username).getResultList());
        //if(client == null) System.err.println("cliente  nulo");           
        Query q = em.createNamedQuery("Client.findByClientusername");
        q.setParameter("clientusername", username);

        try {
            //product = (Product) q.getSingleResult();
            List<Client> results = q.getResultList();
            if(!results.isEmpty()){
                client = results.get(0);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {

        em.close();
        }
   
  return client;
  }
    
  
}
