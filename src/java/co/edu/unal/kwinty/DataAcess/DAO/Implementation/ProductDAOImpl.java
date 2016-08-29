/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.ProductDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Stephanie
 */
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO{
    
    public Product findById(Long id){
        
        EntityManager em = getEmf().createEntityManager();
        Product product = null;
        Query q = em.createNamedQuery("Product.findById");
        q.setParameter("id", id);

        try {
            product = (Product) q.getSingleResult();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {

        em.close();
        }
        return product;
    }
    
    public Product findByType(String type){
        
        EntityManager em = getEmf().createEntityManager();
        Product product = null;
       
        Query q = em.createNamedQuery("Product.findByType");
        q.setParameter("type", type);

        try {
            //product = (Product) q.getSingleResult();
            List<Product> results = q.getResultList();
            if(!results.isEmpty()){
                product = results.get(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        em.close();
        }
        
        return product;
    }
    
    @Override
    public List<Product> getAll(){
        EntityManager em = getEmf().createEntityManager();
        List<Product> products = new ArrayList<>();
        Query q = em.createNamedQuery("Product.findAll");

        try {
            products = q.getResultList();
        } catch (Exception e) {

        } finally {

        em.close();
        }
        return products;
    }

   
    public void deleteProduct(Product product) {
        
        EntityManager em = getEmf().createEntityManager();
        em.getTransaction().begin();
        try{
            product = em.merge(product);
            em.remove(product);
            em.getTransaction().commit();
        }catch(Exception e){
            //em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}
