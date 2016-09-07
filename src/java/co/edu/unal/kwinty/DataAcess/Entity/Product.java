/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stephanie
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByType", query = "SELECT p FROM Product p WHERE p.type = :type"),
    @NamedQuery(name = "Product.findByFeeType", query = "SELECT p FROM Product p WHERE p.feeType = :feeType"),
    @NamedQuery(name = "Product.findByInterestType", query = "SELECT p FROM Product p WHERE p.interestType = :interestType"),
    @NamedQuery(name = "Product.findByMaxNumberFees", query = "SELECT p FROM Product p WHERE p.maxNumberFees = :maxNumberFees"),
    @NamedQuery(name = "Product.findByInterestRate", query = "SELECT p FROM Product p WHERE p.interestRate = :interestRate"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "fee_type")
    private String feeType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "interest_type")
    private String interestType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_number_fees")
    private int maxNumberFees;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest_rate")
    private float interestRate;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private Collection<Acquiredproduct> acquiredproductCollection;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String type, String feeType, String interestType, int maxNumberFees, float interestRate) {
        this.id = id;
        this.type = type;
        this.feeType = feeType;
        this.interestType = interestType;
        this.maxNumberFees = maxNumberFees;
        this.interestRate = interestRate;
    }
    public Product( String type, String feeType, String interestType, int maxNumberFees, float interestRate) {
        
        this.type = type;
        this.feeType = feeType;
        this.interestType = interestType;
        this.maxNumberFees = maxNumberFees;
        this.interestRate = interestRate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public int getMaxNumberFees() {
        return maxNumberFees;
    }

    public void setMaxNumberFees(int maxNumberFees) {
        this.maxNumberFees = maxNumberFees;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Acquiredproduct> getAcquiredproductCollection() {
        return acquiredproductCollection;
    }

    public void setAcquiredproductCollection(Collection<Acquiredproduct> acquiredproductCollection) {
        this.acquiredproductCollection = acquiredproductCollection;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paparazi.Product[ id=" + id + " ]";
    }
    
}
