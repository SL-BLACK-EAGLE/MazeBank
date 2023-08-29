package com.axs.pos.Controllers.Admin;

import com.axs.pos.Views.AdminMenuOptions;
import com.axs.pos.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
    }

    private void addListeners(){
        create_client_btn.setOnAction(event -> onCreateClient());
        clients_btn.setOnAction(event -> onClients());
    }
    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }
    private void onClients(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }
}
