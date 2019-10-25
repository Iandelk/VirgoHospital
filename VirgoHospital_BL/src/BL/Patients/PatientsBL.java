/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Patients;
import BL.Doctors.*;
import DAL.Factory.*;
import DAL.Interfaces.*;
import DAL.Models.NextOfKin;
import DAL.Models.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Phyrexian
 */
public class PatientsBL {
    
  IPatientsRepo repo;

    public PatientsBL() {
        
        repo = RepoFactory.getPatientsRepo();
    }
  
  public int addPatient(String name,String middleName, String surname, Integer sex, Date dateOfBirth, String briefStatementOfComplaint){

      Integer id =repo.addPatient(name,middleName, surname, sex, dateOfBirth, briefStatementOfComplaint);
     
  
     return id;
      
  }
  
   public void addNextOfKin(int patientId, String name, String middleName, String surname, String relationshipToOutpatient){

      repo.addNextOfKin(patientId, name, middleName, surname, relationshipToOutpatient);
 
  }
    
  public List<Patient> getAllPatients(){
    
List<Patient> AllPatients = repo.getAllPatients();
      

    
      return AllPatients;
  }  
    
    public int addPatientFromFullForm(Patient patient){

      Integer id =repo.addPatientFromFullForm(patient.getBloodType(), patient.getSexId(), patient.getOpid(), patient.getName(), patient.getMiddleName(), 
              patient.getSurname(), patient.getDateOfBirth(), patient.getBriefStatementOfComplaint(), patient.getPresentAddressStreet(), 
              patient.getPresentAddressDoorNo(), patient.getPresentAddressArea(), patient.getPresentAddressCity(), patient.getPresentAddressState(), 
              patient.getPresentAddressPincode(), patient.getPermanentAddressStreet(), patient.getPermanentAddressDoorNo(), patient.getPermanentAddressArea(),
              patient.getPermanentAddressCity(), patient.getPermanentAddressState(), patient.getPermanentAddressPincode(), patient.getMaritalStatus(),
              patient.getNumberOfDependents(), patient.getHeight(), patient.getWeight(), patient.getOccupation(), patient.getGrossAnnualIncome(),
              patient.getVegetarian(), patient.getSmoker(), patient.getAverageNumberOfCigarettesPerDay(), patient.getConsumeAlcoholicBeverage(), 
              patient.getAverageNumberOfDrinksPerDay(), patient.getStimulants(), patient.getConsumptionOfCoffeeTeaPerDay(), patient.getConsumptionOfSoftDrinksPerDay(),
              patient.getHaveRegularMeals(), patient.getEatHomeOutsidePredominantly(), patient.getStatementOfComplaint(), patient.getHistoryOfPreviousTreatment(), 
              patient.getPhysicianHospitalTreated(), patient.getDiabetic(), patient.getHypertensive(), patient.getCardiacCondition(), patient.getRespiratoryCondition(),
              patient.getDigestiveCondition(), patient.getOrthopedicCondition(), patient.getMuscularCondition(), patient.getNeurologicalCondition(), patient.getKnownAlergies(),
              patient.getKnownAdverseReactionToSpecificDrugs(), patient.getMajorSurgeriesHistory());
     
  
     return id;
      
  }
    
     public int addNextOfKinFromFullForm(int patientId, NextOfKin nextOfKin){

      Integer id =repo.addNextOfKinFromFullForm(patientId, nextOfKin.getName(), nextOfKin.getMiddleName(), nextOfKin.getSurname(), nextOfKin.getRelationshipToOutpatient(),
              nextOfKin.getAddressStreet(), nextOfKin.getAddressDoorNo(), nextOfKin.getAddressArea(), nextOfKin.getAddressCity(), nextOfKin.getAddressState(), nextOfKin.getAddressPincode());
     
  
     return id;
      
  }
     
     
      public List<NextOfKin> getAllNextOfKin(){
    
List<NextOfKin> AllNextOfKin = repo.getAllNextOfKin();
      

    
      return AllNextOfKin;
  }  
      
      public void updatePatient(int IdPatient,Patient patient){
          
          repo.updatePatient(IdPatient,patient.getBloodType(), patient.getSexId(), patient.getOpid(), patient.getName(), patient.getMiddleName(), 
              patient.getSurname(), patient.getDateOfBirth(), patient.getBriefStatementOfComplaint(), patient.getPresentAddressStreet(), 
              patient.getPresentAddressDoorNo(), patient.getPresentAddressArea(), patient.getPresentAddressCity(), patient.getPresentAddressState(), 
              patient.getPresentAddressPincode(), patient.getPermanentAddressStreet(), patient.getPermanentAddressDoorNo(), patient.getPermanentAddressArea(),
              patient.getPermanentAddressCity(), patient.getPermanentAddressState(), patient.getPermanentAddressPincode(), patient.getMaritalStatus(),
              patient.getNumberOfDependents(), patient.getHeight(), patient.getWeight(), patient.getOccupation(), patient.getGrossAnnualIncome(),
              patient.getVegetarian(), patient.getSmoker(), patient.getAverageNumberOfCigarettesPerDay(), patient.getConsumeAlcoholicBeverage(), 
              patient.getAverageNumberOfDrinksPerDay(), patient.getStimulants(), patient.getConsumptionOfCoffeeTeaPerDay(), patient.getConsumptionOfSoftDrinksPerDay(),
              patient.getHaveRegularMeals(), patient.getEatHomeOutsidePredominantly(), patient.getStatementOfComplaint(), patient.getHistoryOfPreviousTreatment(), 
              patient.getPhysicianHospitalTreated(), patient.getDiabetic(), patient.getHypertensive(), patient.getCardiacCondition(), patient.getRespiratoryCondition(),
              patient.getDigestiveCondition(), patient.getOrthopedicCondition(), patient.getMuscularCondition(), patient.getNeurologicalCondition(), patient.getKnownAlergies(),
              patient.getKnownAdverseReactionToSpecificDrugs(), patient.getMajorSurgeriesHistory());
      }
      
      public void updateNextOfKin(int IdNextOfKin, NextOfKin nextOfKin){
          repo.UpdateNextOfKin(IdNextOfKin, nextOfKin.getName(), nextOfKin.getMiddleName(), nextOfKin.getSurname(), nextOfKin.getRelationshipToOutpatient(),
              nextOfKin.getAddressStreet(), nextOfKin.getAddressDoorNo(), nextOfKin.getAddressArea(), nextOfKin.getAddressCity(), nextOfKin.getAddressState(), nextOfKin.getAddressPincode());
      }
      
       public void AssignPatientToADoctor(int IdPatient, int DoctorId){
           repo.AssignPatientToADoctor(IdPatient, DoctorId);
       }
  
}
