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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity(name="Client")
@Table(name = "Client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientusername", query = "SELECT c FROM Client c WHERE c.clientusername = :clientusername"),
    @NamedQuery(name = "Client.findByPhonenumber", query = "SELECT c FROM Client c WHERE c.phonenumber = :phonenumber"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.address = :address"),
    @NamedQuery(name = "Client.findByPaymentCapacity", query = "SELECT c FROM Client c WHERE c.paymentCapacity = :paymentCapacity")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Client_username")
    private String clientusername;  
    @Basic(optional = false)
    @NotNull
    @Column(name = "phonenumber")
    private int phonenumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_capacity")
    private float paymentCapacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Acquiredproduct> acquiredproductCollection;
    @JoinColumn(name = "Client_username", referencedColumnName = "username", insertable = false, updatable = false)
    @OneToOne(optional = false,cascade = CascadeType.PERSIST)
    private User user;

    public Client() {
    }

    public Client(String clientusername) {
        this.clientusername = clientusername;
    }

    public Client(String clientusername, int phonenumber, String email, float paymentCapacity) {
        this.clientusername = clientusername;
        this.phonenumber = phonenumber;
        this.email = email;
        this.paymentCapacity = paymentCapacity;
    }

    public String getClientusername() {
        return clientusername;
    }

    public void setClientusername(String clientusername) {
        this.clientusername = clientusername;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPaymentCapacity() {
        return paymentCapacity;
    }

    public void setPaymentCapacity(float paymentCapacity) {
        this.paymentCapacity = paymentCapacity;
    }

    @XmlTransient
    public Collection<Acquiredproduct> getAcquiredproductCollection() {
        return acquiredproductCollection;
    }

    public void setAcquiredproductCollection(Collection<Acquiredproduct> acquiredproductCollection) {
        this.acquiredproductCollection = acquiredproductCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientusername != null ? clientusername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientusername == null && other.clientusername != null) || (this.clientusername != null && !this.clientusername.equals(other.clientusername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.kwinty.DataAcess.Entity.Client[ clientusername=" + clientusername + " ]";
    }
    
}
