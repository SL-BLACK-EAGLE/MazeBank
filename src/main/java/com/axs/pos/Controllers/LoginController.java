package com.axs.pos.Controllers;

import com.axs.pos.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox account_selector;
    public Label payee_address_lbl;
    public TextField payee_address_field;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public Label password_lbl;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login_btn.setOnAction(event -> onLogin());

    }
    private void onLogin(){
        System.out.println("call onLogin");
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().showClientWindow();
        Model.getInstance().getViewFactory().closeStage(stage);

    }
}
