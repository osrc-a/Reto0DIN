/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceTier;

import DataAccessTier.DataAccessible;
import DataAccessTier.FileUserDataAccessor;
import DataAccessTier.UserManagerFactory;
import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author oscar
 */
public class UserDataWindowController implements Initializable {
    
DataAccessible dataAccessible;
UserManagerFactory factory;

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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        dataAccessible = (DataAccessible) factory.accederADatos();
        user = dataAccessible.getUser();
        txtPrueba.setText(user.getuDni());
        //txtName.setText(user.getNombre());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
