/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repo;

import DAL.Interfaces.IPatientsRepo;
import DAL.Models.Doctor;
import DAL.Models.HibernateUtil;
import DAL.Models.NextOfKin;
import DAL.Models.Patient;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Phyrexian
 */
public class PatientsRepo extends BaseRepo implements IPatientsRepo{

   
    @Override
    public Integer addPatient(String name,String middleName, String surname, Integer sex, Date dateOfBirth, String briefStatementOfComplaint ){
        int patientID = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient = new Patient( name, middleName,  surname,  sex,  dateOfBirth,  briefStatementOfComplaint);
            patient.setBloodType(1);
            patient.setVegetarian(false);
            patient.setSmoker(false);
            patient.setConsumeAlcoholicBeverage(false);
            patient.setHaveRegularMeals(false);
            patient.setEatHomeOutsidePredominantly(false);
            patient.setDiabetic(false);
            patient.setHypertensive(false);
            patient.setDateAdded(Timestamp.valueOf(LocalDateTime.now()));
            patientID = (Integer)session.save(patient);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return patientID ;
    }
    
     public void addNextOfKin(int patientId, String name, String middleName, String surname, String relationshipToOutpatient){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Patient patient = (Patient) session.load(Patient.class, patientId);
            
            NextOfKin nextOfKin = new NextOfKin(patient, name, middleName, surname, relationshipToOutpatient);
           session.save(nextOfKin);
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
     public List<Patient> getAllPatients(){
         
         List<Patient> AllPatients = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(Patient.class);
             AllPatients = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return AllPatients;
         

     }

    @Override
    public Integer addPatientFromFullForm(int bloodType, int sexID, String opid, String name, String middleName, String surname, Date dateOfBirth, String briefStatementOfComplaint, String presentAddressStreet, Integer presentAddressDoorNo, String presentAddressArea, String presentAddressCity, String presentAddressState, String presentAddressPincode, String permanentAddressStreet, Integer permanentAddressDoorNo, String permanentAddressArea, String permanentAddressCity, String permanentAddressState, String permanentAddressPincode, String maritalStatus, Integer numberOfDependents, Integer height, Integer weight, String occupation, Integer grossAnnualIncome, Boolean vegetarian, Boolean smoker, Integer averageNumberOfCigarettesPerDay, Boolean consumeAlcoholicBeverage, Integer averageNumberOfDrinksPerDay, String stimulants, Integer consumptionOfCoffeeTeaPerDay, Integer consumptionOfSoftDrinksPerDay, Boolean haveRegularMeals, Boolean eatHomeOutsidePredominantly, String statementOfComplaint, String historyOfPreviousTreatment, String physicianHospitalTreated, Boolean diabetic, Boolean hypertensive, String cardiacCondition, String respiratoryCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAlergies, String knownAdverseReactionToSpecificDrugs, String majorSurgeriesHistory) {
         int patientID = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Patient patient = new Patient(bloodType, sexID, opid, name, middleName, surname, dateOfBirth, briefStatementOfComplaint, presentAddressStreet, presentAddressDoorNo, presentAddressArea, presentAddressCity, presentAddressState, presentAddressPincode, permanentAddressStreet, permanentAddressDoorNo, permanentAddressArea, permanentAddressCity, permanentAddressState, permanentAddressPincode, maritalStatus, numberOfDependents, height, weight, occupation, grossAnnualIncome, vegetarian, smoker, averageNumberOfCigarettesPerDay, consumeAlcoholicBeverage, averageNumberOfDrinksPerDay, stimulants, consumptionOfCoffeeTeaPerDay, consumptionOfSoftDrinksPerDay, haveRegularMeals, eatHomeOutsidePredominantly, statementOfComplaint, historyOfPreviousTreatment, physicianHospitalTreated, diabetic, hypertensive, cardiacCondition, respiratoryCondition, digestiveCondition, orthopedicCondition, muscularCondition, neurologicalCondition, knownAlergies, knownAdverseReactionToSpecificDrugs, majorSurgeriesHistory);
            
            patient.setDateAdded(Timestamp.valueOf(LocalDateTime.now()));
            patientID = (Integer)session.save(patient);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return patientID ;
    }

    @Override
    public Integer addNextOfKinFromFullForm(int patientId, String name, String middleName, String surname, String relationshipToOutpatient, String addressStreet, Integer addressDoorNo, String addressArea, String addressCity, String addressState, String addressPincode) {
        int IdNextOfKin = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            Patient patient = (Patient) session.load(Patient.class, patientId);
            
            NextOfKin nextOfKin = new NextOfKin(patient, name, middleName, surname, relationshipToOutpatient, addressStreet, addressDoorNo, addressArea, addressCity, addressState, addressPincode);
     
           IdNextOfKin = (Integer)session.save(nextOfKin);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        
    }
        return IdNextOfKin;
    } 

    @Override
    public List<NextOfKin> getAllNextOfKin() {
        List<NextOfKin> AllNextOfKin = new ArrayList<>();
         
             Session session = HibernateUtil.getSessionFactory().openSession();
             
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            
            
             Criteria criteria = session.createCriteria(NextOfKin.class);
             AllNextOfKin = criteria.list();
            
        
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    
         
         
         return AllNextOfKin;
    }

    @Override
    public void updatePatient(int IdPatient, int bloodType, int sexID, String opid, String name, String middleName, String surname, Date dateOfBirth, String briefStatementOfComplaint, 
            String presentAddressStreet, Integer presentAddressDoorNo, String presentAddressArea, String presentAddressCity, String presentAddressState, String presentAddressPincode, 
            String permanentAddressStreet, Integer permanentAddressDoorNo, String permanentAddressArea, String permanentAddressCity, String permanentAddressState, 
            String permanentAddressPincode, String maritalStatus, Integer numberOfDependents, Integer height, Integer weight, String occupation, Integer grossAnnualIncome,
            Boolean vegetarian, Boolean smoker, Integer averageNumberOfCigarettesPerDay, Boolean consumeAlcoholicBeverage, Integer averageNumberOfDrinksPerDay, String stimulants, 
            Integer consumptionOfCoffeeTeaPerDay, Integer consumptionOfSoftDrinksPerDay, Boolean haveRegularMeals, Boolean eatHomeOutsidePredominantly, String statementOfComplaint, 
            String historyOfPreviousTreatment, String physicianHospitalTreated, Boolean diabetic, Boolean hypertensive, String cardiacCondition, String respiratoryCondition, 
            String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAlergies, String knownAdverseReactionToSpecificDrugs, 
            String majorSurgeriesHistory) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Patient patient = (Patient)session.get(Patient.class, IdPatient);
          patient.setBloodType(bloodType);patient.setSexId(sexID);patient.setOpid(opid);patient.setName(name);patient.setMiddleName(middleName);patient.setSurname(surname);
          patient.setDateOfBirth(dateOfBirth);patient.setBriefStatementOfComplaint(briefStatementOfComplaint);patient.setPresentAddressStreet(presentAddressStreet);patient.setPresentAddressDoorNo(presentAddressDoorNo);
          patient.setPresentAddressArea(presentAddressArea);patient.setPresentAddressCity(presentAddressCity);patient.setPresentAddressState(presentAddressState);patient.setPresentAddressPincode(presentAddressPincode);
          patient.setPermanentAddressStreet(permanentAddressStreet);patient.setPermanentAddressDoorNo(permanentAddressDoorNo);patient.setPermanentAddressArea(permanentAddressArea);
          patient.setPermanentAddressCity(permanentAddressCity);patient.setPermanentAddressState(permanentAddressState);patient.setPermanentAddressPincode(permanentAddressPincode);patient.setMaritalStatus(maritalStatus);
          patient.setNumberOfDependents(numberOfDependents);patient.setHeight(height);patient.setWeight(weight);patient.setOccupation(occupation);patient.setGrossAnnualIncome(grossAnnualIncome);
          patient.setVegetarian(vegetarian);patient.setSmoker(smoker);patient.setAverageNumberOfCigarettesPerDay(averageNumberOfCigarettesPerDay);patient.setConsumeAlcoholicBeverage(consumeAlcoholicBeverage);
          patient.setAverageNumberOfDrinksPerDay(averageNumberOfDrinksPerDay);patient.setStimulants(stimulants);patient.setConsumptionOfCoffeeTeaPerDay(consumptionOfCoffeeTeaPerDay);patient.setConsumptionOfSoftDrinksPerDay(consumptionOfSoftDrinksPerDay);
          patient.setHaveRegularMeals(haveRegularMeals);patient.setEatHomeOutsidePredominantly(eatHomeOutsidePredominantly);patient.setStatementOfComplaint(statementOfComplaint);patient.setHistoryOfPreviousTreatment(historyOfPreviousTreatment);
          patient.setPhysicianHospitalTreated(physicianHospitalTreated);patient.setDiabetic(diabetic);patient.setHypertensive(hypertensive);patient.setCardiacCondition(cardiacCondition);patient.setRespiratoryCondition(respiratoryCondition);
          patient.setDigestiveCondition(digestiveCondition);patient.setOrthopedicCondition(orthopedicCondition);patient.setMuscularCondition(muscularCondition);patient.setNeurologicalCondition(neurologicalCondition);
          patient.setKnownAlergies(knownAlergies);patient.setKnownAdverseReactionToSpecificDrugs(knownAdverseReactionToSpecificDrugs);patient.setMajorSurgeriesHistory(majorSurgeriesHistory);
       
            session.update(patient);
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
    public void UpdateNextOfKin(int IdNextOfKin, String name, String middleName, String surname, String relationshipToOutpatient, String addressStreet, Integer addressDoorNo, 
            String addressArea, String addressCity, String addressState, String addressPincode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
             tx = session.beginTransaction();
        
         NextOfKin nextOfKin = (NextOfKin)session.get(NextOfKin.class, IdNextOfKin);
        nextOfKin.setName(name);nextOfKin.setMiddleName(middleName);nextOfKin.setSurname(surname);nextOfKin.setRelationshipToOutpatient(relationshipToOutpatient);
        nextOfKin.setAddressStreet(addressStreet);nextOfKin.setAddressDoorNo(addressDoorNo);nextOfKin.setAddressArea(addressArea);nextOfKin.setAddressCity(addressCity);
        nextOfKin.setAddressState(addressState);nextOfKin.setAddressPincode(addressPincode);

         session.update(nextOfKin);
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
    public void AssignPatientToADoctor(int IdPatient, int DoctorId){
        
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          Patient patient = (Patient)session.get(Patient.class, IdPatient);
          patient.setDoctorId(DoctorId);
            session.update(patient);
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
