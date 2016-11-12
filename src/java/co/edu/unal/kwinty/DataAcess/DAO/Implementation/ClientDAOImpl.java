
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.ClientDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import java.util.ArrayList;
import java.util.List;


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
        List<Acquiredproduct> products;
        if(super.findByPK(username).getAcquiredproductCollection() == null){
            System.err.println("Nulo!!!!!!!!!!!!!!!!");
            return new ArrayList<>();
        }
        
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

  





