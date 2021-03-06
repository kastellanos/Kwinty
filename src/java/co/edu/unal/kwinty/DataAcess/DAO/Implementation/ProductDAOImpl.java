/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import static co.edu.unal.kwinty.DataAcess.DAO.Implementation.GenericDAOImpl.getEntityManager;
import co.edu.unal.kwinty.DataAcess.DAO.ProductDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Stephanie
 */
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO{

    public ProductDAOImpl() {
        super(Product.class);
    }

    @Override
    public Product findByType(String type) {
        EntityManager em = getEntityManager();
        Product responseInstance = null;
        Query q = em.createNamedQuery(FINDBYTYPE);
        q.setParameter("type", type);
        try {
            responseInstance = (Product) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return responseInstance;
    }
    public List<Product> getAll(){
        return super.getAll(FINDALL);
    }
    
    private final static String FINDALL= "Product.findAll";
    private final static String FINDBYTYPE= "Product.findByType";

    
}
