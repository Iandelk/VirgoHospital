/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repo;

import DAL.Interfaces.IDoctorsRepo;
import DAL.Models.Doctor;
import DAL.Models.HibernateUtil;
import DAL.Models.Patient;
import DAL.Models.Specialization;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Phyrexian
 */
public class DoctorsRepo extends BaseRepo implements IDoctorsRepo {
    
    public boolean addDoctor(String name, String surname, int specializationId){
        int doctorID = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Doctor doctor = new Doctor(name, surname,specializationId );
            doctorID = (Integer)session.save(doctor);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return doctorID >0;
    }

    @Override
    public List<Specialization> getSpecializations() {

         List<Specialization> allSpecializations = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

             Criteria criteria = session.createCriteria(Specialization.class);
             allSpecializations = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return allSpecializations;
    }

    @Override
    public List<Doctor> getDoctors() {
         List<Doctor> allDoctors = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(Doctor.class);
             allDoctors = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return allDoctors;
         
    }


    public void UpdateDoctors(int doctorId, String name, String surname, int specializationId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Doctor doctor = (Doctor)session.get(Doctor.class, doctorId);
          doctor.setName(name);
          doctor.setSurname(surname);
          doctor.setSpecialization(specializationId);
            session.update(doctor);
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
