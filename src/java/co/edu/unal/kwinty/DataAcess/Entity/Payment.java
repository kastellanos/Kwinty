/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "Payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.paymentPK.id = :id"),
    @NamedQuery(name = "Payment.findByClientusername", query = "SELECT p FROM Payment p WHERE p.paymentPK.clientusername = :clientusername"),
    @NamedQuery(name = "Payment.findByProductid", query = "SELECT p FROM Payment p WHERE p.paymentPK.productid = :productid"),
    @NamedQuery(name = "Payment.findByAdminusername", query = "SELECT p FROM Payment p WHERE p.paymentPK.adminusername = :adminusername"),
    @NamedQuery(name = "Payment.findByDate", query = "SELECT p FROM Payment p WHERE p.date = :date"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentPK paymentPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @JoinColumns({
        @JoinColumn(name = "Client_username", referencedColumnName = "Client_username", insertable = false, updatable = false),
        @JoinColumn(name = "Product_id", referencedColumnName = "Product_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Acquiredproduct acquiredproduct;
    @JoinColumn(name = "Admin_username", referencedColumnName = "Admin_username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Admin admin;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Payment(PaymentPK paymentPK, Date date, float amount) {
        this.paymentPK = paymentPK;
        this.date = date;
        this.amount = amount;
    }

    public Payment(long id, String clientusername, long productid, String adminusername) {
        this.paymentPK = new PaymentPK(id, clientusername, productid, adminusername);
    }

    public PaymentPK getPaymentPK() {
        return paymentPK;
    }

    public void setPaymentPK(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Acquiredproduct getAcquiredproduct() {
        return acquiredproduct;
    }

    public void setAcquiredproduct(Acquiredproduct acquiredproduct) {
        this.acquiredproduct = acquiredproduct;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentPK != null ? paymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentPK == null && other.paymentPK != null) || (this.paymentPK != null && !this.paymentPK.equals(other.paymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.kwinty.DataAcess.Entity.Payment[ paymentPK=" + paymentPK + " ]";
    }
    
}
