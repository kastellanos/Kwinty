/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandlePayment;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author sebchaparr
 */

@ManagedBean
@ViewScoped
public class ClientPaymentsBean {
    
    
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean; // +setter (no getter!)    

    public LoginBean getLoginBean() {
        return loginBean;
    }


    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    
    
    private List<Payment> payments;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
    @PostConstruct
    public void init() {
        HandlePayment handlePayment = new HandlePayment();
        payments = handlePayment.findByClient(loginBean.getUsername());
        if (payments != null) {
            System.out.print("Es nulo");

        }
    }    
    
    public ClientPaymentsBean() {
        HandlePayment handlePayment = new HandlePayment();
        payments = handlePayment.listAll();
        if (payments != null) {
            System.out.print("Es nulo");

        }
    }

    
}
