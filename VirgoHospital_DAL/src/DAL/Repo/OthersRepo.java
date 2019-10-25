/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repo;

import java.util.ArrayList;
import java.util.List;
import DAL.Interfaces.IOtherRepo;
import DAL.Models.Bill;
import DAL.Models.Contact;
import DAL.Models.ContactNextOfKin;
import DAL.Models.HibernateUtil;
import DAL.Models.Item;
import DAL.Models.NextOfKin;
import DAL.Models.Patient;
import DAL.Models.PaymentType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Phyrexian
 */
public class OthersRepo extends BaseRepo implements IOtherRepo {

    @Override
    public void addPatientContact(int patientId,String contact) {
         int contactID = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient = (Patient) session.load(Patient.class, patientId);
            Contact kontakt = new Contact(patient, contact);
            session.save(kontakt);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    }
    

    @Override
    public void addNextOfKinContact(int nextOfKinId,String contact) {
         int contactID = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            NextOfKin nextOfKin = (NextOfKin) session.load(NextOfKin.class, nextOfKinId);
            ContactNextOfKin kontakt = new ContactNextOfKin(nextOfKin, contact);
            session.save(kontakt);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public List<Contact> getAllPatientContacts() {
        List<Contact> allPatientContacts = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(Contact.class);
             allPatientContacts = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return allPatientContacts;
    }

    @Override
    public List<ContactNextOfKin> getAllNextOfKinContacts() {
              List<ContactNextOfKin> allNextOfKinContacts = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(ContactNextOfKin.class);
             allNextOfKinContacts = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return allNextOfKinContacts;
    }

    @Override
    public void updatePatientContact(int IdContact, String contact) {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Contact contactContent = (Contact)session.get(Contact.class, IdContact);
          contactContent.setNumber(contact);
            session.update(contactContent);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
     
    
    }

    @Override
    public void updateNextOfKinContact(int IdNextOfKinContact, String contact) {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          ContactNextOfKin contactNextOfKin = (ContactNextOfKin)session.get(ContactNextOfKin.class, IdNextOfKinContact);
          contactNextOfKin.setNumber(contact);
            session.update(contactNextOfKin);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
     
    }

    @Override
    public List<PaymentType> getPaymentType() {
         List<PaymentType> paymentTypes = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

             Criteria criteria = session.createCriteria(PaymentType.class);
             paymentTypes = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }

         return paymentTypes;
    }

    @Override
    public List<Bill> getBills() {
        List<Bill> allBills = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

             Criteria criteria = session.createCriteria(Bill.class);
             allBills = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }

         return allBills;
    }

    @Override
    public List<Item> getItems() {
        List<Item> allItems = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

             Criteria criteria = session.createCriteria(Item.class);
             allItems = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }

         return allItems;
    }

    @Override
    public Integer addBill(Integer total, Integer paymentId) {
         Integer IdBill = 0;
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
               PaymentType paymentType = (PaymentType)session.get(PaymentType.class, paymentId);
            Bill bill = new Bill(total, paymentType);
            bill.setTime(Timestamp.valueOf(LocalDateTime.now()));
          IdBill = (Integer)session.save(bill);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
    
        return IdBill;
    }

    

    @Override
    public void addItem(Integer billId, String itemName, int price) {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Bill bill = (Bill) session.load(Bill.class, billId);
            
            Item item = new Item(bill, itemName, price);
           session.save(item);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
    
    }
 
    }


