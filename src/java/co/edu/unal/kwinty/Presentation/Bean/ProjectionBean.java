/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author franco
 */
@ManagedBean
@ApplicationScoped
public class ProjectionBean {
    private List<Float> projection;
    private String clientName;
    private int numberFees;
    private float amount;
    private long productID;
    private String message;
    private String projectionGoogle;

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    private BarChartModel barModel;
    public ProjectionBean() {
        
    }
        public void init() {
            createBarModels();
        }

    
    public List<Float> getProjection() {
        return projection;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProjectionGoogle() {
        return projectionGoogle;
    }

    public void setProjectionGoogle(String projectionGoogle) {
        this.projectionGoogle = projectionGoogle;
    }

    public int getNumberFees() {
        return numberFees;
    }

    public float getAmount() {
        return amount;
    }

    public long getProductID() {
        return productID;
    }
    
    public void setProyection(List<Float> proyection) {
        this.projection = proyection;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setNumberFees(int numberFees) {
        this.numberFees = numberFees;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
     private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        createProjection();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Meses");
        System.out.println("Holaaaa: "+productID);
        for(int i=0;i<projection.size();i++){
        boys.set((i+1), projection.get(i));
 
        }
        
        model.addSeries(boys);
         
        return model;
    }
      
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Proyeccion de pago");
        barModel.setLegendPosition("ne");
        barModel.setAnimate(true);
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Meses");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cuota");
        yAxis.setMin(0);
        float value = Math.round(Collections.max(projection));
        yAxis.setMax( value + value*.1);
    }
    
   
    public void createProjection(){
        HandleAcquiredProduct viewProjection = new HandleAcquiredProduct();
        Acquiredproduct acquierdProduct = viewProjection.findById(productID);
        projection = viewProjection.calculateFees(acquierdProduct.getNumberFees(), acquierdProduct.getAmount(), acquierdProduct.getProductid().getId());
    }

    private void createBarModels() {
        createBarModel();
    }
}
