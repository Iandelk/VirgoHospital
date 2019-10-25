/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Factory;

import DAL.Interfaces.*;
import DAL.Repo.*;

/**
 *
 * @author Phyrexian
 */
public class RepoFactory {
    public static IDoctorsRepo getDoctorsRepo(){
     return new DoctorsRepo();   
    }
    
      public static IPatientsRepo getPatientsRepo(){
     return new PatientsRepo();   
    }
      
        public static IOtherRepo getOthersRepo(){
     return new OthersRepo();   
    }
        
               public static IAppointmentsRepo getAppointmentsRepo(){
     return new AppointmentsRepo();   
    }
    
}
