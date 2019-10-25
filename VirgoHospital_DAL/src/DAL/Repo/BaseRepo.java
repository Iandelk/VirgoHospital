/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repo;

import DAL.Helpers.DataSourceHelper;
import javax.sql.DataSource;

/**
 *
 * @author Phyrexian
 */
public class BaseRepo {
    public DataSource ds;

    public BaseRepo() {
        if(ds == null){
            ds = DataSourceHelper.getDataSource();
        }
    }
    
    
    
}
