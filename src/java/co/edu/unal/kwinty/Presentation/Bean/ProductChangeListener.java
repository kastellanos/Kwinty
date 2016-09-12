/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
/**
 *
 * @author stephanie
 */
public class ProductChangeListener implements ValueChangeListener {
   @Override
   public void processValueChange(ValueChangeEvent event)
      throws AbortProcessingException {
      //access country bean directly
      CreateAcquiredProductBean productBean = (CreateAcquiredProductBean) FacesContext.getCurrentInstance().
         getExternalContext().getSessionMap().get("userData");
      
      productBean.setSelectedProduct(event.getNewValue().toString());

   }
   
}
