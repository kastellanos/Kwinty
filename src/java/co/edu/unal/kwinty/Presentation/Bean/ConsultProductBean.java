/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebchaparr
 */

@ManagedBean
@ViewScoped

public class ConsultProductBean implements Serializable {
    private Product editProduct;
    private long id;
    private List<Product> products;
    private String message1;
    private HandleProduct productHandler;
    
    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getEditProduct() {
        return editProduct;
    }

    public void setEditProduct(Product editProduct) {
        this.editProduct = editProduct;
    }

    
    public void getProduct(long id) {
        //productHandler = new HandleProduct();
        products = productHandler.getProduct(products, id);
    }
    public void getProductById(long id) {
        //productHandler = new HandleProduct();
        editProduct = productHandler.getProductById(products, id).get(0);
        System.out.println(editProduct.getId());
    }
    public ConsultProductBean() {
        productHandler = new HandleProduct();
        products = productHandler.listAll();
    }
   /* public List<Product> listAllProducts(){
        
    }*/
    
    public void deleteProduct( Product product ){
        System.out.println("Se eliminara el usuario " + product);
        productHandler.deleteProduct(product.getId());
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "productos.xhtml");
        
    }
    public void updateProduct( Product product ){
        System.out.println("Se actualizara el usuario " + product);
        productHandler.updateProduct(product);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "productos.xhtml");
    }

    
}
