/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sebchaparr
 */
@ManagedBean
@ViewScoped
public class ClientProductsBean {
    
    
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean; // +setter (no getter!)    

    public LoginBean getLoginBean() {
        return loginBean;
    }


    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    
    
    private List<Acquiredproduct> acquiredproducts;

    public List<Acquiredproduct> getAcquiredproducts() {
        return acquiredproducts;
    }

    public void setAcquiredproducts(List<Acquiredproduct> acquiredproducts) {
        this.acquiredproducts = acquiredproducts;
    }

    
    @PostConstruct
    public void init() {
        HandleAcquiredProduct handleAcquiredproduct = new HandleAcquiredProduct();
        acquiredproducts = handleAcquiredproduct.findByClient(loginBean.getUsername());
        if (acquiredproducts != null) {
            System.out.print("Es nulo");

        }
    }    
    
    public ClientProductsBean() {
        HandleAcquiredProduct handleAcquiredproduct = new HandleAcquiredProduct();
        acquiredproducts = handleAcquiredproduct.listAll();
        if (acquiredproducts != null) {
            System.out.print("Es nulo");

        }
    }

    
}
