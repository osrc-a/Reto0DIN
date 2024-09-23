 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;

/**
 *
 * @author oscar
 */

//Interfaz general para las recogidas de datos
public interface DataAccessible {
    
   public User getUser() throws Exception;
    
}
