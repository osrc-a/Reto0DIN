/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceTier;

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
 * Controlador de la ventana que gestiona la presentación de la información del usuario.
 * Implementa la interfaz {@link Initializable} para la inicialización de la interfaz gráfica.
 * 
 * @author oscar
 */
public class UserDataWindowController implements Initializable {

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
    
    /**
     * Maneja el evento cuando se presiona el botón.
     * Rellena los campos de texto con la información del usuario recuperada.
     * 
     * @param event el evento de acción del botón
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            User user = UserManagerFactory.accederADatos().getUser();
            txtPrueba.setText(user.getuDni());
            txtName.setText(user.getNombre());
            txtSurname.setText(user.getApellido());
            txtUser.setText(user.getUsuario());
            txtPsswd.setText(user.getContraseina());
            txtAge.setText(user.getEdad().toString());
        } catch (Exception e) {
            Logger.getLogger("UserInterfaceTier").severe(e.getLocalizedMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Método llamado al inicializar el controlador
    }    
}

