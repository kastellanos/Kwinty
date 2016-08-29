/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.CredentialsDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author franco
 */
public class CredentialsDAOImpl extends GenericDAOImpl<Credentials, String> implements CredentialsDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("KwintyPU");
    
    @Override
    public Credentials searchByUsername(String uname) {

        EntityManager em = emf1.createEntityManager();
        Credentials c = null;

        try {
            c = em.find(Credentials.class, uname);
        } catch (Exception e){
               e.printStackTrace();
               
        } finally {
            em.close();
        }
        return c;
    }
    
}
