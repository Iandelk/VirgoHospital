/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repo;

import DAL.Interfaces.IAppointmentsRepo;
import DAL.Models.Appointment;
import DAL.Models.Bill;
import DAL.Models.Contact;
import DAL.Models.Doctor;
import DAL.Models.HibernateUtil;
import DAL.Models.Patient;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Phyrexian
 */
public class AppointmentsRepo extends BaseRepo implements IAppointmentsRepo{
    
    @Override
    public void AddAppointment(int patientId, int doctorId, Timestamp appointmentTime){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient = (Patient) session.load(Patient.class, patientId);
            Doctor doctor = (Doctor) session.load(Doctor.class, doctorId);
            Appointment appointment = new Appointment(patient, doctor, appointmentTime);
            appointment.setClosed(false);
            session.save(appointment);
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
    public List<Appointment> getAllAppointments() {
             
         List<Appointment> allAppointments = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(Appointment.class);
             allAppointments = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return allAppointments;
         

    }
    
     public void closeAppointment(int idAppointment){
        
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Appointment appointment = (Appointment)session.get(Appointment.class, idAppointment);
          appointment.setClosed(true);
            session.update(appointment);
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
    public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId, Timestamp followUp) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Appointment appointment = (Appointment)session.get(Appointment.class, IdAppointment);
          Bill bill = (Bill)session.get(Bill.class, billId);
          Doctor doctor = (Doctor)session.get(Doctor.class, doctorId);
          appointment.setBill(bill);
          appointment.setDiagnosis(diagnosis);
          appointment.setDoctorByReference(doctor);
          appointment.setPrescription(prescription);
          appointment.setLabTests(labTests);
          appointment.setFollowUp(followUp);
          appointment.setClosed(true);
            session.update(appointment);
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
    public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId, Timestamp followUp) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Appointment appointment = (Appointment)session.get(Appointment.class, IdAppointment);
          Bill bill = (Bill)session.get(Bill.class, billId);
          appointment.setBill(bill);
          appointment.setDiagnosis(diagnosis);
          appointment.setPrescription(prescription);
          appointment.setLabTests(labTests);
          appointment.setFollowUp(followUp);
          appointment.setClosed(true);
            session.update(appointment);
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
    public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Appointment appointment = (Appointment)session.get(Appointment.class, IdAppointment);
          Bill bill = (Bill)session.get(Bill.class, billId);
          Doctor doctor = (Doctor)session.get(Doctor.class, doctorId);
          appointment.setBill(bill);
          appointment.setDiagnosis(diagnosis);
          appointment.setDoctorByReference(doctor);
          appointment.setPrescription(prescription);
          appointment.setLabTests(labTests);
          appointment.setClosed(true);
            session.update(appointment);
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
    public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Appointment appointment = (Appointment)session.get(Appointment.class, IdAppointment);
          Bill bill = (Bill)session.get(Bill.class, billId);
  
          appointment.setBill(bill);
          appointment.setDiagnosis(diagnosis);

          appointment.setPrescription(prescription);
          appointment.setLabTests(labTests);
            appointment.setClosed(true);
            session.update(appointment);
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
