package com.axs.pos.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox account_selector;
    public Label payee_address_lbl;
    public Label password_lbl;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public TextField payee_address_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
