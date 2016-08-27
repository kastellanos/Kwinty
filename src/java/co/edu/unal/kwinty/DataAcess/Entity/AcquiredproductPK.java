/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andres
 */
@Embeddable
public class AcquiredproductPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Client_username")
    private String clientusername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_id")
    private long productid;

    public AcquiredproductPK() {
    }

    public AcquiredproductPK(String clientusername, long productid) {
        this.clientusername = clientusername;
        this.productid = productid;
    }

    public String getClientusername() {
        return clientusername;
    }

    public void setClientusername(String clientusername) {
        this.clientusername = clientusername;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientusername != null ? clientusername.hashCode() : 0);
        hash += (int) productid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcquiredproductPK)) {
            return false;
        }
        AcquiredproductPK other = (AcquiredproductPK) object;
        if ((this.clientusername == null && other.clientusername != null) || (this.clientusername != null && !this.clientusername.equals(other.clientusername))) {
            return false;
        }
        if (this.productid != other.productid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.kwinty.DataAcess.Entity.AcquiredproductPK[ clientusername=" + clientusername + ", productid=" + productid + " ]";
    }
    
}
