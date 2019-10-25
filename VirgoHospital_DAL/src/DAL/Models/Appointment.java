package DAL.Models;
// Generated Jun 3, 2019 11:46:52 AM by Hibernate Tools 4.3.1


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Appointment generated by hbm2java
 */
@Entity
@Table(name="Appointment"
    ,schema="dbo"
    ,catalog="Virgo_Database"
)
public class Appointment  implements java.io.Serializable {


     private int Idappointment;
     private Bill bill;
     private Doctor doctorByDoctorId;
     private Doctor doctorByReference;
     private Patient patient;
     private Timestamp appointmentTime;
     private String diagnosis;
     private String prescription;
     private String labTests;
     private Timestamp followUp;
     private Boolean closed;

    public Appointment() {
    }

    public Appointment(Patient patient, Doctor doctorByDoctorId, Timestamp appointmentTime){
    this.patient = patient;
    this.doctorByDoctorId = doctorByDoctorId;
    this.appointmentTime = appointmentTime;
    
    }
    
    public Appointment(int IdAppointment, Boolean closed){
    this.Idappointment = IdAppointment;
    this.closed = closed;
    }
	
    public Appointment(int Idappointment, Doctor doctorByDoctorId, Patient patient, Timestamp appointmentTime) {
        this.Idappointment = Idappointment;
        this.doctorByDoctorId = doctorByDoctorId;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
    }
    public Appointment(int Idappointment, Bill bill, Doctor doctorByDoctorId, Doctor doctorByReference, Patient patient, Timestamp appointmentTime, String diagnosis, String prescription, String labTests, Timestamp followUp) {
       this.Idappointment = Idappointment;
       this.bill = bill;
       this.doctorByDoctorId = doctorByDoctorId;
       this.doctorByReference = doctorByReference;
       this.patient = patient;
       this.appointmentTime = appointmentTime;
       this.diagnosis = diagnosis;
       this.prescription = prescription;
       this.labTests = labTests;
       this.followUp = followUp;
    }
    
     public Appointment(int Idappointment, Bill bill, Doctor doctorByReference, String diagnosis, String prescription, String labTests, Timestamp followUp) {
       this.Idappointment = Idappointment;
       this.bill = bill;
       this.doctorByDoctorId = doctorByDoctorId;
       this.doctorByReference = doctorByReference;
       this.patient = patient;
       this.appointmentTime = appointmentTime;
       this.diagnosis = diagnosis;
       this.prescription = prescription;
       this.labTests = labTests;
       this.followUp = followUp;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY) 

    
    @Column(name="IDAppointment", unique=true, nullable=false)
    public int getIdappointment() {
        return this.Idappointment;
    }
    
    public void setIdappointment(int idappointment) {
        this.Idappointment = idappointment;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="BillID")
    public Bill getBill() {
        return this.bill;
    }
    
    public void setBill(Bill bill) {
        this.bill = bill;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DoctorID", nullable=false)
    public Doctor getDoctorByDoctorId() {
        return this.doctorByDoctorId;
    }
    
    public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Reference")
    public Doctor getDoctorByReference() {
        return this.doctorByReference;
    }
    
    public void setDoctorByReference(Doctor doctorByReference) {
        this.doctorByReference = doctorByReference;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PatientID", nullable=false)
    public Patient getPatient() {
        return this.patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Column(name="AppointmentTime", nullable=false, length=23)
    public Timestamp getAppointmentTime() {
        return this.appointmentTime;
    }
    
    public void setAppointmentTime(Timestamp appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    
    @Column(name="Diagnosis")
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    
    @Column(name="Prescription")
    public String getPrescription() {
        return this.prescription;
    }
    
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    
    @Column(name="LabTests")
    public String getLabTests() {
        return this.labTests;
    }
    
    public void setLabTests(String labTests) {
        this.labTests = labTests;
    }

    @Column(name="FollowUp", length=23)
    public Timestamp getFollowUp() {
        return this.followUp;
    }
    
    public void setFollowUp(Timestamp followUp) {
        this.followUp = followUp;
    }

public static String[] appointments_Previous(){
        String[] columns = {
        "Patient","Complaint","Doctor", "Time", "", "Diagnosis", "Prescription", "Lab Tests", "Reference", "FollowUp", "Bill"
        };
        return columns;
    }


public static String[] appointments_Future(){
        String[] columns = {
        "Patient","Complaint","Doctor", "Time", ""
        };
        return columns;
    }

   @Column(name="Closed")
    public Boolean getClosed() {
        return this.closed;
    }
    
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

}


