/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase responsable de la creación de instancias de acceso a datos.
 * Dependiendo de la configuración, elige entre un acceso a datos 
 * desde un archivo o desde una base de datos.
 * 
 * @author oscar
 */
public class UserManagerFactory {
    
    private static final Logger LOGGER = Logger.getLogger(UserManagerFactory.class.getName());

    /**
     * Accede a los datos basándose en la configuración especificada en el archivo de propiedades.
     * 
     * @return una instancia de DataAccessible que puede ser un 
     * FileUserDataAccessor o un DBUserDataAccessor según la configuración
     */
    public static DataAccessible accederADatos() {

        String tipoDao = ResourceBundle.getBundle("resources.readData").getString("dao.implementacion");
        
        if ("archivo".equals(tipoDao)) {
            return new FileUserDataAccessor();
        } else if ("base_datos".equals(tipoDao)) {
            return new DBUserDataAccessor();
        } else {
            // Registra el error en los logs y retorna una implementación por defecto
            LOGGER.log(Level.SEVERE, "Tipo de DAO no soportado: {0}. Se usará FileUserDataAccessor como predeterminado.", tipoDao);
            return new FileUserDataAccessor(); // Valor por defecto
        }
    }
}
