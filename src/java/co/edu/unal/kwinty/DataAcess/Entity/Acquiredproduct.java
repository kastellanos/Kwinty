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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Acquiredproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acquiredproduct.findAll", query = "SELECT a FROM Acquiredproduct a"),
    @NamedQuery(name = "Acquiredproduct.findById", query = "SELECT a FROM Acquiredproduct a WHERE a.id = :id"),
    @NamedQuery(name = "Acquiredproduct.findByNumberFees", query = "SELECT a FROM Acquiredproduct a WHERE a.numberFees = :numberFees"),
    @NamedQuery(name = "Acquiredproduct.findByAmount", query = "SELECT a FROM Acquiredproduct a WHERE a.amount = :amount"),
    @NamedQuery(name = "Acquiredproduct.findByFeeAmount", query = "SELECT a FROM Acquiredproduct a WHERE a.feeAmount = :feeAmount"),
    @NamedQuery(name = "Acquiredproduct.findByAmountPaid", query = "SELECT a FROM Acquiredproduct a WHERE a.amountPaid = :amountPaid"),
    @NamedQuery(name = "Acquiredproduct.findByReference", query = "SELECT a FROM Acquiredproduct a WHERE a.reference = :reference"),
    @NamedQuery(name = "Acquiredproduct.findByAcquisitionDate", query = "SELECT a FROM Acquiredproduct a WHERE a.acquisitionDate = :acquisitionDate"),
    @NamedQuery(name = "Acquiredproduct.findByFeeIncrementRate", query = "SELECT a FROM Acquiredproduct a WHERE a.feeIncrementRate = :feeIncrementRate")})
public class Acquiredproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acquiredproductid")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "username_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Client usernameId;
    @JoinColumn(name = "Product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productid;

    public Acquiredproduct() {
    }

    public Acquiredproduct(Long id) {
        this.id = id;
    }

    public Acquiredproduct(Long id, int numberFees, float amount, float feeAmount, float amountPaid, Date acquisitionDate, float feeIncrementRate) {
        this.id = id;
        this.numberFees = numberFees;
        this.amount = amount;
        this.feeAmount = feeAmount;
        this.amountPaid = amountPaid;
        this.acquisitionDate = acquisitionDate;
        this.feeIncrementRate = feeIncrementRate;
    }
public Acquiredproduct( int numberFees, float amount, float feeAmount, float amountPaid, Date acquisitionDate, float feeIncrementRate) {
        
        this.numberFees = numberFees;
        this.amount = amount;
        this.feeAmount = feeAmount;
        this.amountPaid = amountPaid;
        this.acquisitionDate = acquisitionDate;
        this.feeIncrementRate = feeIncrementRate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Client getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(Client usernameId) {
        this.usernameId = usernameId;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acquiredproduct)) {
            return false;
        }
        Acquiredproduct other = (Acquiredproduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paparazi.Acquiredproduct[ id=" + id + " ]";
    }
    
}
