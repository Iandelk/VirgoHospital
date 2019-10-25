/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Interfaces;

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
public interface IOtherRepo {
    public void addPatientContact(int patientId,String contact);
    public void addNextOfKinContact(int nextOfKinId,String contact);
    public void updatePatientContact(int IdContact,String contact);
    public void updateNextOfKinContact(int IdNextOfKinContact,String contact);
    public List<Contact> getAllPatientContacts();
    public List<ContactNextOfKin> getAllNextOfKinContacts();
    public List<PaymentType> getPaymentType();
    public List<Bill> getBills();
    public List<Item> getItems();
    public Integer addBill(Integer total, Integer paymentId);
    public void addItem(Integer billId, String itemName, int price);
    
}
