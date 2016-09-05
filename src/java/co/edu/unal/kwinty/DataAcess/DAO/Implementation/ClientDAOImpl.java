
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.ClientDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ClientDAOImpl extends GenericDAOImpl<Client, String> implements ClientDAO {

    public ClientDAOImpl() {
        super(Client.class);
    }

    
    public List<Client> getAll() {
        return super.getAll(ClientDAOImpl.FINDALL);
    }

    
    private final static String FINDALL = "Client.findAll";

    @Override
    public List<Acquiredproduct> getClientAdquiredProducts(String username) {
        return (List<Acquiredproduct>) super.findByPK(username).getAcquiredproductCollection();
    }

    @Override
    public List<Payment> findPaymentByClient(String username) {
        List<Payment> returnList = new ArrayList<>();
        List<Acquiredproduct> products = (List<Acquiredproduct>) super.findByPK(username).getAcquiredproductCollection();
        for( Acquiredproduct product: products ){
            returnList.addAll(product.getPaymentCollection());
        }
        return returnList;
    }

  



    }

  





