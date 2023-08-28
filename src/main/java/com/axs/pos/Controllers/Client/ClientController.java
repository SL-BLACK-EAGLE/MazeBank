package com.axs.pos.Controllers.Client;

import com.axs.pos.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observable, oldValue, newValue) -> {
            switch (newValue){
                case "Transactions" -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                case "Accounts" -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
