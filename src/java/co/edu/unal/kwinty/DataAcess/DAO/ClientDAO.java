package co.edu.unal.kwinty.DataAcess.DAO;

import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import java.util.List;

/**
 *
 * @author root
 */
public interface ClientDAO extends GenericDAO<Client,String>{
    public List<Acquiredproduct> getClientAdquiredProducts(String username);
    public List<Payment> findPaymentByClient(String username);
    

    
}
