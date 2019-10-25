/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Helpers;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author Phyrexian
 */
public class DataSourceHelper {
    
    public static DataSource getDataSource(){
        SQLServerDataSource source = new SQLServerDataSource();
        source.setServerName("DESKTOP-2I1FI6C");
        source.setDatabaseName("Virgo_Database");
        source.setUser("sa");
        source.setPassword("SQL");
        source.setPortNumber(1433);
        return source;
    }
    
}
