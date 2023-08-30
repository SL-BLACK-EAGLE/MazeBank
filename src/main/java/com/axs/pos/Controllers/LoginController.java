package com.axs.pos.Controllers;

import com.axs.pos.Models.Model;
import com.axs.pos.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> account_selector;
    public Label payee_address_lbl;
    public TextField payee_address_field;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public Label password_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        account_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        account_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        account_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(account_selector.getValue()));
        login_btn.setOnAction(event -> onLogin());
    }
    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();

        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
//            Evaluate Client Login Credentials
            Model.getInstance().evaluateClientCred(payee_address_field.getText(), password_fld.getText());
            if (Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
//                Close the Login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            }else{
                payee_address_field.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials");
            }
        }else{
            Model.getInstance().getViewFactory().showAdminWindow();
        }

    }
}
