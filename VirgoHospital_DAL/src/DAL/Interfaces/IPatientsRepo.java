/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Interfaces;


import DAL.Models.NextOfKin;
import DAL.Models.Patient;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Phyrexian
 */
public interface IPatientsRepo {
         public Integer addPatient(String name,String middleName, String surname, Integer sex, Date dateOfBirth, String briefStatementOfComplaint );
     
         public void addNextOfKin(int patientId, String name, String middleName, String surname, String relationshipToOutpatient);
      
         public List<Patient> getAllPatients();
     
         public List<NextOfKin> getAllNextOfKin();
         
         public Integer addNextOfKinFromFullForm(int patientId, String name, String middleName, String surname, String relationshipToOutpatient, String addressStreet, 
               Integer addressDoorNo, String addressArea, String addressCity, String addressState, String addressPincode);
     
         public Integer addPatientFromFullForm( int bloodType, int sexID, String opid, String name, String middleName,
            String surname, Date dateOfBirth, String briefStatementOfComplaint,
            String presentAddressStreet, Integer presentAddressDoorNo, 
            String presentAddressArea, String presentAddressCity, String presentAddressState,
            String presentAddressPincode, String permanentAddressStreet, Integer permanentAddressDoorNo, 
            String permanentAddressArea, String permanentAddressCity, String permanentAddressState, 
            String permanentAddressPincode, String maritalStatus, Integer numberOfDependents, Integer height, 
            Integer weight, String occupation, Integer grossAnnualIncome, Boolean vegetarian, Boolean smoker, 
            Integer averageNumberOfCigarettesPerDay, Boolean consumeAlcoholicBeverage, Integer averageNumberOfDrinksPerDay,
            String stimulants, Integer consumptionOfCoffeeTeaPerDay, Integer consumptionOfSoftDrinksPerDay, Boolean haveRegularMeals,
            Boolean eatHomeOutsidePredominantly, String statementOfComplaint, String historyOfPreviousTreatment,
            String physicianHospitalTreated, Boolean diabetic, Boolean hypertensive, String cardiacCondition, 
            String respiratoryCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, 
            String neurologicalCondition, String knownAlergies, String knownAdverseReactionToSpecificDrugs, String majorSurgeriesHistory);
         
         public void updatePatient(int IdPatient,int bloodType, int sexID, String opid, String name, String middleName,
            String surname, Date dateOfBirth, String briefStatementOfComplaint,
            String presentAddressStreet, Integer presentAddressDoorNo, 
            String presentAddressArea, String presentAddressCity, String presentAddressState,
            String presentAddressPincode, String permanentAddressStreet, Integer permanentAddressDoorNo, 
            String permanentAddressArea, String permanentAddressCity, String permanentAddressState, 
            String permanentAddressPincode, String maritalStatus, Integer numberOfDependents, Integer height, 
            Integer weight, String occupation, Integer grossAnnualIncome, Boolean vegetarian, Boolean smoker, 
            Integer averageNumberOfCigarettesPerDay, Boolean consumeAlcoholicBeverage, Integer averageNumberOfDrinksPerDay,
            String stimulants, Integer consumptionOfCoffeeTeaPerDay, Integer consumptionOfSoftDrinksPerDay, Boolean haveRegularMeals,
            Boolean eatHomeOutsidePredominantly, String statementOfComplaint, String historyOfPreviousTreatment,
            String physicianHospitalTreated, Boolean diabetic, Boolean hypertensive, String cardiacCondition, 
            String respiratoryCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, 
            String neurologicalCondition, String knownAlergies, String knownAdverseReactionToSpecificDrugs, String majorSurgeriesHistory);
         
         
         public void UpdateNextOfKin(int IdNextOfKin, String name, String middleName, String surname, String relationshipToOutpatient, String addressStreet, 
               Integer addressDoorNo, String addressArea, String addressCity, String addressState, String addressPincode);   
         
          public void AssignPatientToADoctor(int IdPatient, int DoctorId);
}
