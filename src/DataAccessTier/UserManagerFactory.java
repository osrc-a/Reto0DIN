/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author oscar
 */
public class UserManagerFactory {
    
    public static DataAccessible accederADatos(){
        Properties propiedades = new Properties();
        try(InputStream input = UserManagerFactory.class.getClassLoader().getResourceAsStream("readData.properties")){
                if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar el archivo de propiedades.");
                return null;
        }
                propiedades.load(input);
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
        String tipoDao = propiedades.getProperty("dao.implementacion");
        
         if ("archivo".equals(tipoDao)) {
            return new FileUserDataAccessor();
        } else if ("base_datos".equals(tipoDao)) {
            return new DBUserDataAccessor();
        } else {
            throw new IllegalArgumentException("Tipo de DAO no soportado: " + tipoDao);
        }
    }
        
    }
