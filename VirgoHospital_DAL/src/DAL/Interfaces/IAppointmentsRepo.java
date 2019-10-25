/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Interfaces;

import DAL.Models.Appointment;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Phyrexian
 */
public interface IAppointmentsRepo {
    
      public void AddAppointment(int patientId, int doctorId, Timestamp appointmentTime);
      public List<Appointment> getAllAppointments();
      public void closeAppointment(int idAppointment);
      public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId, Timestamp followUp);
      public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId, Timestamp followUp);
      public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId,int doctorId);
      public void updateAppointment(int IdAppointment, String diagnosis, String prescription, String labTests, int billId);
}
