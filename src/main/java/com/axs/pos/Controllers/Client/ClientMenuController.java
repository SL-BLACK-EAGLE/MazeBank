package com.axs.pos.Controllers.Client;

import com.axs.pos.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {

    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("From ClientMenuController");
        addListeners();
    }

    private void addListeners(){
        System.out.println("From addListener");
        dashboard_btn.setOnAction(event -> onDashboard());
        transaction_btn.setOnAction(event -> onTransactions());
    }
    private void onDashboard(){
        System.out.println("This is Dashboard");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");

    }

    private void onTransactions(){
        System.out.println("This is Transactions");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transactions");


    }
}
