/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Doctors;
import DAL.Factory.*;
import DAL.Interfaces.*;
import DAL.Models.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Phyrexian
 */
public class DoctorsBL {
    
  IDoctorsRepo repo;

    public DoctorsBL() {
        
        repo = RepoFactory.getDoctorsRepo();
    }
  
  public void addDoctor(Doctor doctor){
      
      if(repo.addDoctor(doctor.getName(), doctor.getSurname(), doctor.getSpecialization())){
          System.out.println("Doctor Added Succesfully!");
      }else{
          System.out.println("Fatal Error!");
      }
      
  }
  
  public void updateDoctor(int doctorId, Doctor doctor){
      repo.UpdateDoctors(doctorId,doctor.getName(), doctor.getSurname(), doctor.getSpecialization());
  }
    
   public List<Specialization> getSpecializations(){
       
       return repo.getSpecializations();
       
   }
   
   public List<Doctor> getAllDoctors(){
       return repo.getDoctors();
   }
    
   public List<Doctor> getAllGeneralDoctors(){
       List<Doctor> allDoctors = repo.getDoctors(); 
       
      List<Doctor> allGeneralDoctors = allDoctors.stream().filter(it -> it.getSpecialization() == 1).collect(Collectors.toList());
       
       return allGeneralDoctors;
   }

}
