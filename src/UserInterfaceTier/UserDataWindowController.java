/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceTier;

import DataAccessTier.DataAccessible;
import DataAccessTier.UserManagerFactory;
import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author oscar
 */

//Clase que se encarga de gestiona donde se muestra la informacion del usuario
public class UserDataWindowController implements Initializable {

    User user;
    
    @FXML
    private TextField txtPrueba;
    
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPsswd;

    @FXML
    private TextField txtAge;
    
    //Evento que se ejecuta cuando el usuario presiona el boton y rellena los campos de texto con la informacion del usuario
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
        User user = UserManagerFactory.accederADatos().getUser();
        txtPrueba.setText(user.getuDni());
        txtName.setText(user.getNombre());
        txtSurname.setText(user.getApellido());
        txtUser.setText(user.getUsuario());
        txtPsswd.setText(user.getContraseina());
        txtAge.setText(user.getEdad().toString());
        } catch(Exception e){
          Logger.getLogger("UserInterfaceTier").
                  severe(e.getLocalizedMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
