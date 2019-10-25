/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Other;
import DAL.Factory.*;
import DAL.Interfaces.*;
import DAL.Models.Bill;
import DAL.Models.BloodType;
import DAL.Models.Contact;
import DAL.Models.ContactNextOfKin;
import DAL.Models.Item;
import DAL.Models.PaymentType;
import java.sql.Timestamp;
import java.util.List;
/**
 *
 * @author Phyrexian
 */
public class OthersBL {
    
  IOtherRepo repo;

    public OthersBL() {
        
        repo = RepoFactory.getOthersRepo();
    }
  
  public void addContact(int patientId, String contact){
      
     repo.addPatientContact(patientId, contact);
   
      

  }
  
   public void addNextOfKinContact(int nextOfKinId, String contact){
      
     repo.addNextOfKinContact(nextOfKinId, contact);
   
      

  }
   
     public List<Contact> getAllPatientContacts(){
   
   
   return repo.getAllPatientContacts();
   }
   
   public List<ContactNextOfKin> getAllNextOfKinContacts(){
   
   
   return repo.getAllNextOfKinContacts();
   }
  
   public void updatePatientContact(int IdContact, String contact){
       
      repo.updatePatientContact(IdContact, contact);
   }
   
    public void updateNextOfKinContact(int IdNextOfKinContact, String contact){
       
      repo.updatePatientContact(IdNextOfKinContact, contact);
   }
    
    public List<PaymentType> getPaymentType(){
       return repo.getPaymentType();
    }
    
      public List<Bill> getAllBills(){
       return repo.getBills();
    }
      
      public List<Item> getAllItems(){
          return repo.getItems();
      }
      
      public Integer addBills(Integer total, int paymentId){
  
          int billId = repo.addBill(total, paymentId);
          
          return billId;
      }
      
      public void addItem(Integer billId, String itemName, int price){
          
          repo.addItem(billId, itemName, price);
      }
  }

