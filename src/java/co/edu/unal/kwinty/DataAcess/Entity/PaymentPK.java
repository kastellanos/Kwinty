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
public class PaymentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Client_username")
    private String clientusername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_id")
    private long productid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Admin_username")
    private String adminusername;

    public PaymentPK() {
    }

    public PaymentPK(long id, String clientusername, long productid, String adminusername) {
        this.id = id;
        this.clientusername = clientusername;
        this.productid = productid;
        this.adminusername = adminusername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (clientusername != null ? clientusername.hashCode() : 0);
        hash += (int) productid;
        hash += (adminusername != null ? adminusername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPK)) {
            return false;
        }
        PaymentPK other = (PaymentPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.clientusername == null && other.clientusername != null) || (this.clientusername != null && !this.clientusername.equals(other.clientusername))) {
            return false;
        }
        if (this.productid != other.productid) {
            return false;
        }
        if ((this.adminusername == null && other.adminusername != null) || (this.adminusername != null && !this.adminusername.equals(other.adminusername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.kwinty.DataAcess.Entity.PaymentPK[ id=" + id + ", clientusername=" + clientusername + ", productid=" + productid + ", adminusername=" + adminusername + " ]";
    }
    
}
