package com.axs.pos.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label login_date;
    public Label checking_balance;
    public Label checking_acc_number;
    public Label savings_balance;
    public Label savings_acc_number;
    public Label income_lbl;
    public ListView transaction_listview;
    public TextField payee_fld;
    public TextArea message_fld;
    public TextField amount_fld;
    public Button send_money_btn;
    public Label expense_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
