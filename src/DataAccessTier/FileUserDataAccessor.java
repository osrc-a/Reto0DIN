/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase responsable de acceder a los datos del usuario desde un archivo.
 * Implementa la interfaz {@link DataAccessible}.
 * 
 * @author oscar
 */
public class FileUserDataAccessor implements DataAccessible {
    
    private static final Logger LOGGER = Logger.getLogger(FileUserDataAccessor.class.getName());

    /**
     * Obtiene la información del usuario desde un archivo de propiedades
     * y la mapea a un objeto {@link User}.
     * 
     * @return un objeto User con los datos del usuario
     */
    @Override
    public User getUser() {
        // Crea una instancia del objeto User
        User user = new User();

        // Obtén el ResourceBundle
        ResourceBundle bundle = ResourceBundle.getBundle("resources.readFile");

        // Establece los valores en el objeto User
        user.setuDni(bundle.getString("uDni"));
        user.setNombre(bundle.getString("nombre"));
        user.setApellido(bundle.getString("apellido"));
        user.setUsuario(bundle.getString("usuario"));
        user.setContraseina(bundle.getString("contraseina"));
        
        // Convertir de cadena a entero
        try {
            int edad = Integer.parseInt(bundle.getString("edad"));
            user.setEdad(edad);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error al convertir a entero", e);
        }
        
        return user;
    }
}

