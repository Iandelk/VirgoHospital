/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Statistics;

import BL.Appointments.AppointmentsBL;
import BL.Doctors.DoctorsBL;
import BL.Other.OthersBL;
import BL.Patients.PatientsBL;
import DAL.Models.*;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author Phyrexian
 */


public class StatisticsBL {
static PatientsBL patientsBL;
static OthersBL othersBL;
static DoctorsBL doctorsBL;
static AppointmentsBL appointmentsBL;

    public StatisticsBL() {
          doctorsBL = new DoctorsBL();
          patientsBL = new PatientsBL();
          othersBL = new OthersBL();
          appointmentsBL = new AppointmentsBL();

    }

public int getNumberOfPatientAppointmentsToday(){
    
    List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
    
    
    return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals(LocalDate.now())).collect(Collectors.toList()).size();
}

public int getNumberOfNewPatientsToday(){
    
    List<Patient> allPatients = patientsBL.getAllPatients();
    
    return allPatients.stream().filter(it -> it.getDateAdded().toLocalDateTime().toLocalDate().equals(LocalDate.now())).collect(Collectors.toList()).size();
}
    

public int getNumberOfFolloweUpPatientsToday(){
    
    List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();

    return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.now())).collect(Collectors.toList())
            .stream().filter(it-> it.getPatient().getDateAdded().toLocalDateTime().toLocalDate().isBefore( LocalDate.now())).collect(Collectors.toList()).size();
}

public int getNumberOfTestsOrderedToday(){
    
   List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
   
  return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.now())).collect(Collectors.toList())
            .stream().filter(it -> it.getLabTests() != null).collect(Collectors.toList()).size();
}

public int getNumberOfMedicinePrescribedToday(){
    
   List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
   
   
  return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.now())).collect(Collectors.toList())
            .stream().filter(it -> it.getPrescription()!= null).collect(Collectors.toList()).size();
}

public int getTotalFeeToday(){
     List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
 
     return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.now())).collect(Collectors.toList()).stream()
         .map(x -> x.getBill().getTotal()).reduce(0, Integer::sum);         
}

public int newPatientsPerDay(int day, int year, int month){

     List<Patient> allPatients = patientsBL.getAllPatients();
    
   return allPatients.stream().filter(it -> it.getDateAdded().toLocalDateTime().toLocalDate().equals(LocalDate.of(year, month, day))).collect(Collectors.toList()).size();
    
}

public int FollowUpPatientsPerDay(int day, int year, int month){

      List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
    
   return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.of(year, month, day))).collect(Collectors.toList())
            .stream().filter(it-> it.getPatient().getDateAdded().toLocalDateTime().toLocalDate().isBefore( LocalDate.of(year, month, day))).collect(Collectors.toList()).size();
    
}

public int newPatientsPerDayForWeek(int weekNumber, int day, int year, int month){
     LocalDate dateChosen = LocalDate.of(year, month, day);

    LocalDate desiredDate = dateChosen
            .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
            .with(TemporalAdjusters.nextOrSame(DayOfWeek.of(day)));
     List<Patient> allPatients = patientsBL.getAllPatients();
    
   return allPatients.stream().filter(it -> it.getDateAdded().toLocalDateTime().toLocalDate().equals(desiredDate)).collect(Collectors.toList()).size();
    
}

public int FollowUpPatientsPerDayForWeek(int weekNumber,int day, int year, int month){
  LocalDate dateChosen = LocalDate.of(year, month, day);

    LocalDate desiredDate = dateChosen
            .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
            .with(TemporalAdjusters.nextOrSame(DayOfWeek.of(day)));
      List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
    
    
               
   return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals(desiredDate)).collect(Collectors.toList())
           .stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().isAfter(it.getPatient().getDateAdded().toLocalDateTime().toLocalDate())).collect(Collectors.toList()).size();
            
    
}

public int averagePatientsPerMonthPerDoctor(Doctor doctor,int day,int year, int month){
     List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
    
    
     return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals( LocalDate.of(year, month, day))).collect(Collectors.toList())
             .stream().filter(it -> it.getDoctorByDoctorId().getIddoctor() == doctor.getIddoctor()).collect(Collectors.toList()).size();
}


public int averagePatientsPerWeekPerDoctor(Doctor doctor,int day,int year, int month, int weekNumber){
     LocalDate dateChosen = LocalDate.of(year, month, day);

    LocalDate desiredDate = dateChosen
            .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
            .with(TemporalAdjusters.nextOrSame(DayOfWeek.of(day)));
      List<Appointment> allAppointments = appointmentsBL.getClosedAppointments();
    
    
    
     return allAppointments.stream().filter(it -> it.getAppointmentTime().toLocalDateTime().toLocalDate().equals(desiredDate)).collect(Collectors.toList())
             .stream().filter(it -> it.getDoctorByDoctorId().getIddoctor() == doctor.getIddoctor()).collect(Collectors.toList()).size();
}

}
