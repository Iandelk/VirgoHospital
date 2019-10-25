/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Interfaces;

import DAL.Models.Doctor;
import DAL.Models.Specialization;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Phyrexian
 */
public interface IDoctorsRepo {
    public boolean addDoctor(String name, String surname, int specializationId);
    public List<Specialization> getSpecializations();
    public List<Doctor> getDoctors();
    public void UpdateDoctors(int doctorId, String name, String surname, int specializationId);   
}
