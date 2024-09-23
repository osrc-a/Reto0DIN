/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import java.util.ResourceBundle;

/**
 *
 * @author oscar
 */

//Clase que se encarga de leer el fichero de lectura y en base a lo que lea elige de donde sacar la informacion
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
