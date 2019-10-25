/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Appointments;

import DAL.Factory.RepoFactory;
import DAL.Interfaces.IAppointmentsRepo;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import DAL.Models.*;
import java.util.stream.Collectors;

/**
 *
 * @author Phyrexian
 */
public class AppointmentsBL {
    IAppointmentsRepo repo;
    
    
     public AppointmentsBL() {
        
        repo = RepoFactory.getAppointmentsRepo();
    }
     
     public void addAppointment(int patientId, int doctorId, LocalDate appointmentDate, LocalTime appointmentTime){
      LocalDateTime appointmentDateTime = LocalDateTime.of(appointmentDate.getYear(), appointmentDate.getMonth(), appointmentDate.getDayOfMonth(),appointmentTime.getHour(), appointmentTime.getMinute());


     repo.AddAppointment(patientId, doctorId,  Timestamp.valueOf(appointmentDateTime));
     
    
}
     
     public void closeAppointment(int Idappointment){
     repo.closeAppointment(Idappointment);
     }
     
     
     
     public List<Appointment> getClosedAppointments(){
       List<Appointment> allAppointments = repo.getAllAppointments();
       List<Appointment> closedAppointments = allAppointments.stream().filter(it -> it.getClosed() == true).collect(Collectors.toList());
       
       
         return closedAppointments;
     }
     
     public List<Appointment> getOpenAppointments(){
       List<Appointment> allAppointments = repo.getAllAppointments();
       List<Appointment> openAppointments = allAppointments.stream().filter(it -> it.getClosed() == false).collect(Collectors.toList());
       
       
         return openAppointments;
     }
     
    public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId, LocalDate appointmentDate, LocalTime appointmentTime){
        LocalDateTime appointmentDateTime = LocalDateTime.of(appointmentDate.getYear(), appointmentDate.getMonth(), appointmentDate.getDayOfMonth(),appointmentTime.getHour(), appointmentTime.getMinute()); 
        
        repo.updateAppointment(IdAppointment, diagnosis, prescription, labTests, billId, doctorId, Timestamp.valueOf(appointmentDateTime));
     }
    
     public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId){
     
        
        repo.updateAppointment(IdAppointment, diagnosis, prescription, labTests, billId, doctorId);
     }
     
      public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId, LocalDate appointmentDate, LocalTime appointmentTime){
        LocalDateTime appointmentDateTime = LocalDateTime.of(appointmentDate.getYear(), appointmentDate.getMonth(), appointmentDate.getDayOfMonth(),appointmentTime.getHour(), appointmentTime.getMinute()); 
        
        repo.updateAppointment(IdAppointment, diagnosis, prescription, labTests, billId, Timestamp.valueOf(appointmentDateTime));
     }
      
       public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId){
      
        
        repo.updateAppointment(IdAppointment, diagnosis, prescription, labTests, billId);
     }
     
}
