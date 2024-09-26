 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;

/**
 * Interfaz general para el acceso a datos de usuario.
 * Proporciona métodos para recuperar información del usuario.
 * 
 * @author oscar
 */
public interface DataAccessible {

    /**
     * Recupera un objeto {@link User} con la información del usuario.
     * 
     * @return un objeto User que representa al usuario
     * @throws Exception si ocurre un error durante la recuperación de datos
     */
    public User getUser() throws Exception;
}

