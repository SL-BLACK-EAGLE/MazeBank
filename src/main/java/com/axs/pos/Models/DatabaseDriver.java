package com.axs.pos.Models;

import java.sql.ResultSet;
import java.time.LocalDate;

public class DatabaseDriver {

    /*
     * Client Section
     * */

    public ResultSet getClientData(String pAddress, String password) {

        ResultSet resultSet = null;
        try {

            resultSet = MySQL.execute("SELECT * FROM `clients` WHERE `PayeeAddress`='" + pAddress + "' AND Password='" + password + "';");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getTransactions(String pAddress, int limit) {

        ResultSet resultSet = null;
        try {
            resultSet = MySQL.execute("SELECT * FROM `transactions` WHERE `Sender`='" + pAddress + "' OR Receiver='" + pAddress + "' LIMIT " + limit + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method returns savings account balance
    public double getSavingsAccountBalance(String pAddress) {

        double balance = 0;
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `savingsaccounts` WHERE Owner='" + pAddress + "' ");
            assert resultSet != null;
            balance = resultSet.getDouble("Balance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    // Method to either add or subtract from balance given operation
    public void updateBalance(String pAddress, double amount, String operation) {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `savingsaccounts` WHERE Owner='" + pAddress + "' ");
            double newBalance;
            if (operation.equals("ADD")) {
                newBalance = resultSet.getDouble("Balance") + amount;
                MySQL.execute("UPDATE `savingsaccounts` SET `Balance` =" + newBalance + " WHERE Owner='" + pAddress + "' ");
            } else {
                if (resultSet.getDouble("Balance") >= amount) {
                    newBalance = resultSet.getDouble("Balance") - amount;
                    MySQL.execute("UPDATE `savingsaccounts` SET `Balance` =" + newBalance + " WHERE Owner='" + pAddress + "' ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creates and records new transaction
    public void newTransaction(String sender, String receiver, double amount, String message) {

        try {
            LocalDate date = LocalDate.now();
            MySQL.execute("INSERT INTO " +
                    "Transactions(Sender, Receiver, Amount, Date, Message) " +
                    "VALUES ('" + sender + "', '" + receiver + "', " + amount + ", '" + date + "', '" + message + "') ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin Section
     * */

    public ResultSet getAdminData(String username, String password) {
        ResultSet resultSet = null;
        try {
            resultSet = MySQL.execute("SELECT * FROM Admins WHERE Username='" + username + "' AND Password='" + password + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void createClient(String fName, String lName, String pAddress, String password, LocalDate date) {

        try {
            MySQL.execute("INSERT INTO " +
                    "Clients (FirstName, LastName, PayeeAddress, Password, Date)" +
                    "VALUES ('" + fName + "', '" + lName + "', '" + pAddress + "', '" + password + "', '" + date.toString() + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createCheckingAccount(String owner, String number, double tLimit, double balance) {

        try {

            MySQL.execute("INSERT INTO " +
                    "CheckingAccounts (Owner, AccountNumber, TransactionLimit, Balance)" +
                    " VALUES ('" + owner + "', '" + number + "', " + tLimit + ", " + balance + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSavingsAccount(String owner, String number, double wLimit, double balance) {

        try {
            MySQL.execute("INSERT INTO " +
                    "SavingsAccounts (Owner, AccountNumber, WithdrawalLimit, Balance)" +
                    " VALUES ('" + owner + "', '" + number + "', " + wLimit + ", " + balance + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllClientsData() {
        ResultSet resultSet = null;
        try {
            resultSet = MySQL.execute("SELECT * FROM Clients ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void depositSavings(String pAddress, double amount) {
        try {
            MySQL.execute("UPDATE SavingsAccounts SET Balance=" + amount + " WHERE Owner='" + pAddress + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Utility Methods
     * */

    public ResultSet searchClient(String pAddress) {

        ResultSet resultSet = null;
        try {

            resultSet = MySQL.execute("SELECT * FROM Clients WHERE PayeeAddress='" + pAddress + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

//    public int getLastClientsId() {
//        Statement statement;
//        ResultSet resultSet;
//        int id = 0;
//        try {
//            statement = this.conn.createStatement();
//            resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name='Clients';");
//            id = resultSet.getInt("seq");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return id;
//    }

    public ResultSet getCheckingAccountData(String pAddress) {

        ResultSet resultSet = null;
        try {

            resultSet = MySQL.execute("SELECT * FROM `CheckingAccounts` WHERE `Owner`='" + pAddress + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getSavingsAccountData(String pAddress) {
        ResultSet resultSet = null;
        try {
            resultSet = MySQL.execute("SELECT * FROM `SavingsAccounts` WHERE `Owner`='" + pAddress + "' ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
