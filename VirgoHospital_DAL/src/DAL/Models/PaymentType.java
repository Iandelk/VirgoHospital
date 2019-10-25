package DAL.Models;
// Generated Jun 3, 2019 11:46:52 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PaymentType generated by hbm2java
 */
@Entity
@Table(name="PaymentType"
    ,schema="dbo"
    ,catalog="Virgo_Database"
)
public class PaymentType  implements java.io.Serializable {


     private int idpaymentType;
     private String type;
     private Set<Bill> bills = new HashSet<Bill>(0);

    public PaymentType() {
    }

	
    public PaymentType(int idpaymentType, String type) {
        this.idpaymentType = idpaymentType;
        this.type = type;
    }
    public PaymentType(int idpaymentType, String type, Set<Bill> bills) {
       this.idpaymentType = idpaymentType;
       this.type = type;
       this.bills = bills;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY) 

    
    @Column(name="IDPaymentType", unique=true, nullable=false)
    public int getIdpaymentType() {
        return this.idpaymentType;
    }
    
    public void setIdpaymentType(int idpaymentType) {
        this.idpaymentType = idpaymentType;
    }

    
    @Column(name="Type", nullable=false)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentType")
    public Set<Bill> getBills() {
        return this.bills;
    }
    
    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return getType(); //To change body of generated methods, choose Tools | Templates.
    }




}

