/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author oscar
 */
public class UserManagerFactory {
    
    public static DataAccessible accederADatos(){

        String tipoDao = ResourceBundle.getBundle("resources.readData").getString("dao.implementacion");
        
         if ("archivo".equals(tipoDao)) {
            return new FileUserDataAccessor();
        } else if ("base_datos".equals(tipoDao)) {
            return new DBUserDataAccessor();
        } else {
            throw new IllegalArgumentException("Tipo de DAO no soportado: " + tipoDao);
        }
    }
        
    }
