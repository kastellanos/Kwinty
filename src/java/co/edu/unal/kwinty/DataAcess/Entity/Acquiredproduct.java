/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "acquiredproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acquiredproduct.findAll", query = "SELECT a FROM Acquiredproduct a"),
    @NamedQuery(name = "Acquiredproduct.findByClientusername", query = "SELECT a FROM Acquiredproduct a WHERE a.acquiredproductPK.clientusername = :clientusername"),
    @NamedQuery(name = "Acquiredproduct.findByProductid", query = "SELECT a FROM Acquiredproduct a WHERE a.acquiredproductPK.productid = :productid"),
    @NamedQuery(name = "Acquiredproduct.findByNumberFees", query = "SELECT a FROM Acquiredproduct a WHERE a.numberFees = :numberFees"),
    @NamedQuery(name = "Acquiredproduct.findByAmount", query = "SELECT a FROM Acquiredproduct a WHERE a.amount = :amount"),
    @NamedQuery(name = "Acquiredproduct.findByFeeAmount", query = "SELECT a FROM Acquiredproduct a WHERE a.feeAmount = :feeAmount"),
    @NamedQuery(name = "Acquiredproduct.findByAmountPaid", query = "SELECT a FROM Acquiredproduct a WHERE a.amountPaid = :amountPaid"),
    @NamedQuery(name = "Acquiredproduct.findByReference", query = "SELECT a FROM Acquiredproduct a WHERE a.reference = :reference"),
    @NamedQuery(name = "Acquiredproduct.findByAcquisitionDate", query = "SELECT a FROM Acquiredproduct a WHERE a.acquisitionDate = :acquisitionDate"),
    @NamedQuery(name = "Acquiredproduct.findByFeeIncrementRate", query = "SELECT a FROM Acquiredproduct a WHERE a.feeIncrementRate = :feeIncrementRate")})
public class Acquiredproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcquiredproductPK acquiredproductPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_fees")
    private int numberFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee_amount")
    private float feeAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_paid")
    private float amountPaid;
    @Size(max = 50)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acquisition_date")
    @Temporal(TemporalType.DATE)
    private Date acquisitionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee_increment_rate")
    private float feeIncrementRate;
    @JoinColumn(name = "Client_username", referencedColumnName = "Client_username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "Product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acquiredproduct")
    private Collection<Payment> paymentCollection;

    public Acquiredproduct() {
    }

    public Acquiredproduct(AcquiredproductPK acquiredproductPK) {
        this.acquiredproductPK = acquiredproductPK;
    }

    public Acquiredproduct(AcquiredproductPK acquiredproductPK, int numberFees, float amount, float feeAmount, float amountPaid, Date acquisitionDate, float feeIncrementRate) {
        this.acquiredproductPK = acquiredproductPK;
        this.numberFees = numberFees;
        this.amount = amount;
        this.feeAmount = feeAmount;
        this.amountPaid = amountPaid;
        this.acquisitionDate = acquisitionDate;
        this.feeIncrementRate = feeIncrementRate;
    }

    public Acquiredproduct(String clientusername, long productid) {
        this.acquiredproductPK = new AcquiredproductPK(clientusername, productid);
    }

    public AcquiredproductPK getAcquiredproductPK() {
        return acquiredproductPK;
    }

    public void setAcquiredproductPK(AcquiredproductPK acquiredproductPK) {
        this.acquiredproductPK = acquiredproductPK;
    }

    public int getNumberFees() {
        return numberFees;
    }

    public void setNumberFees(int numberFees) {
        this.numberFees = numberFees;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(float feeAmount) {
        this.feeAmount = feeAmount;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public float getFeeIncrementRate() {
        return feeIncrementRate;
    }

    public void setFeeIncrementRate(float feeIncrementRate) {
        this.feeIncrementRate = feeIncrementRate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acquiredproductPK != null ? acquiredproductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acquiredproduct)) {
            return false;
        }
        Acquiredproduct other = (Acquiredproduct) object;
        if ((this.acquiredproductPK == null && other.acquiredproductPK != null) || (this.acquiredproductPK != null && !this.acquiredproductPK.equals(other.acquiredproductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct[ acquiredproductPK=" + acquiredproductPK + " ]";
    }
    
}
