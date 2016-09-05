/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.UserDAO;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO{

    public UserDAOImpl() {
        super(User.class);
    }
    
    @Override
    public String searchRoleByName(String name){
        EntityManager em = getEmf().createEntityManager();
        User u = null;
        String role = null;
        try {
            u = em.find(User.class, name);
            role = u.getRole();
        } catch (Exception e){
               e.printStackTrace();               
        } finally {
            em.close();
        }
        return role;
    }
        
}
