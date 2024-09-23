/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class FileUserDataAccessor implements DataAccessible {

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
            Logger.getLogger("DataAccessTier").
                  severe(e.getLocalizedMessage());
        }
        
        return user;
    }

    
}
