package database;

import entities.account.type.Depozit;
import entities.account.type.Economii;
import entities.Client;
import entities.account.Account;
import entities.account.AccountType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbService {

    String url = "jdbc:mysql://localhost:3306/bancadb";
    String user = "banca";
    String password = "changeit";

    private Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            connection = null;
        }
        return connection;
    }

    //Create (Add Account)
    public int addAccount(String prenume, String nume, String cnp, AccountType tip, Double sold) {
        int userId = -1;
        int accountId = -1;
        Connection connection = connect();
        try {
            connection.setAutoCommit(false);
            //Add User
            try (PreparedStatement addUser = connection.prepareStatement("INSERT INTO Users(Prenume, Nume, CNP) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                addUser.setString(1, prenume);
                addUser.setString(2, nume);
                addUser.setString(3, cnp);
                addUser.executeUpdate();
                ResultSet addUserResults = addUser.getGeneratedKeys();
                if (addUserResults.next()) {
                    userId = addUserResults.getInt(1);
                }
            }
            //Add Account
            try (PreparedStatement addAccount = connection.prepareStatement("INSERT INTO Accounts(Tip, Sold) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                addAccount.setString(1, tip.name());
                addAccount.setDouble(2, sold);
                addAccount.executeUpdate();
                ResultSet addAccountResults = addAccount.getGeneratedKeys();
                if (addAccountResults.next()) {
                    accountId = addAccountResults.getInt(1);
                }
            }
            //Link User to Account
            if (userId > 0 && accountId > 0) {
                try (PreparedStatement linkAccount = connection.prepareStatement("INSERT INTO Mappings(UserId, AccountId) VALUES(?,?)")) {
                    linkAccount.setInt(1, userId);
                    linkAccount.setInt(2, accountId);
                    linkAccount.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
            //Disconnect
            connection.close();
        } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return accountId;
    }

    //Read (Get Details)
    public Client getAccount(int accountId) {
        Client customer = null;
        Connection connection = connect();
        try {
            try (PreparedStatement findUser = connection.prepareStatement(
                    "SELECT Prenume,Nume,CNP,Tip,Sold "
                    + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
                    + "JOIN Accounts c on b.AccountId = c.ID "
                    + "WHERE c.ID = ?")) {
                findUser.setInt(1, accountId);
                ResultSet findUserResults = findUser.executeQuery();
                if (findUserResults.next()) {
                    String prenume = findUserResults.getString("Prenume");
                    String nume = findUserResults.getString("Nume");
                    String cnp = findUserResults.getString("CNP");
                    String accountType = findUserResults.getString("Tip");
                    Double sold = findUserResults.getDouble("Sold");
                    Account account;
                    if (accountType.equals(AccountType.Depozit.name())) {
                        account = new Depozit(accountId, sold);
                    } else {
                        account = new Economii(accountId, sold);
                    }
                    customer = new Client(prenume, nume, cnp, account);
                }
            }
        } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return customer;
    }

    //Update (Edit Account)
   public boolean updateAccount(int accountId, Double newBalance) {
        boolean success = false;
        Connection connection = connect();
        try {
            try (PreparedStatement updateBalance = connection.prepareStatement(
                    "UPDATE Accounts SET Sold = ? WHERE ID = ?")) {
                updateBalance.setDouble(1, newBalance);
                updateBalance.setInt(2, accountId);
                updateBalance.executeUpdate();
            }
            success = true;
        } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return success;
    }

    //Delete (Remove Account)
   public boolean deleteAccount(int accountId) {
        boolean success = false;
        Connection connection = connect();
        try {
            try (PreparedStatement deleteRecords = connection.prepareStatement(
                    "DELETE Users,Accounts FROM Users "
                    + "JOIN Mappings on Users.ID = Mappings.UserId "
                    + "JOIN Accounts on Accounts.ID = Mappings.AccountId "
                    + "WHERE Accounts.ID = ?")) {
                deleteRecords.setInt(1, accountId);
                deleteRecords.executeUpdate();
            }
            success = true;
        } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return success;
    }

    public ArrayList<Client> getAllAccounts() {
        ArrayList<Client> customers = new ArrayList<Client>();
        Connection connection = connect();
        try {
            try (PreparedStatement findUser = connection.prepareStatement(
                    "SELECT AccountId,Prenume,Nume,CNP,Tip,Sold "
                    + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
                    + "JOIN Accounts c on b.AccountId = c.ID")) {
                ResultSet findUserResults = findUser.executeQuery();
                while (findUserResults.next()) {
                    String prenume = findUserResults.getString("Prenume");
                    String nume = findUserResults.getString("Nume");
                    String cnp = findUserResults.getString("CNP");
                    String accountType = findUserResults.getString("Tip");
                    Double sold = findUserResults.getDouble("Sold");
                    int accountId = findUserResults.getInt("AccountId");
                    Account account;
                    if (accountType.equals(AccountType.Depozit.name())) {
                        account = new Depozit(accountId, sold);
                    } else {
                        account = new Economii(accountId, sold);
                    }
                    Client customer = new Client(prenume, nume, cnp, account);
                    customers.add(customer);
                }
            }
        } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
        return customers;
    }
}






















//codul pentru conectarea cu PostgreSQL
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bankapp;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//public class DbService {
//    
//    
//    
//    String url = "jdbc:postgresql://localhost:5432/bankdb";
//    String user = "postgres";
//    String password = "seif";
//
//    private Connection connect() {
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            connection = null;
//        }
//        return connection;
//    }
//
//    //Create (Add Account)
//    int addAccount(String prenume, String nume, String cnp, AccountType accountType, Double sold) {
//        int userId = -1;
//        int accountId = -1;
//        Connection connection = connect();
//        try {
//            connection.setAutoCommit(false);
//            //Add User
//            try (PreparedStatement addUser = connection.prepareStatement("INSERT INTO Users(FirstName, LastName, CNP) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
//                addUser.setString(1, prenume);
//                addUser.setString(2, nume);
//                addUser.setString(3, cnp);
//                addUser.executeUpdate();
//                ResultSet addUserResults = addUser.getGeneratedKeys();
//                if (addUserResults.next()) {
//                    userId = addUserResults.getInt(1);
//                }
//            }
//            //Add Account
//            try (PreparedStatement addAccount = connection.prepareStatement("INSERT INTO Accounts(Type, Balance) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
//                addAccount.setString(1, accountType.name());
//                addAccount.setDouble(2, sold);
//                addAccount.executeUpdate();
//                ResultSet addAccountResults = addAccount.getGeneratedKeys();
//                if (addAccountResults.next()) {
//                    accountId = addAccountResults.getInt(1);
//                }
//            }
//            //Link User to Account
//            if (userId > 0 && accountId > 0) {
//                try (PreparedStatement linkAccount = connection.prepareStatement("INSERT INTO Mappings(UserId, AccountId) VALUES(?,?)")) {
//                    linkAccount.setInt(1, userId);
//                    linkAccount.setInt(2, accountId);
//                    linkAccount.executeUpdate();
//                }
//                connection.commit();
//            } else {
//                connection.rollback();
//            }
//            //Disconnect
//            connection.close();
//        } catch (SQLException ex) {
//            System.err.println("An error has occured." + ex.getMessage());
//        }
//        return accountId;
//    }
//    //Read (Get Details)
//    Client getAccount(int accountId) {
//        Client customer = null;
//        Connection connection = connect();
//        try {
//            try (PreparedStatement findUser = connection.prepareStatement(
//                    "SELECT FirstName,LastName,CNP,Type,Balance "
//                    + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
//                    + "JOIN Accounts c on b.AccountId = c.ID "
//                    + "WHERE c.ID = ?")) {
//                findUser.setInt(1, accountId);
//                ResultSet findUserResults = findUser.executeQuery();
//                if (findUserResults.next()) {
//                    String prenume = findUserResults.getString("FirstName");
//                    String nume = findUserResults.getString("LastName");
//                    String cnp = findUserResults.getString("CNP");
//                    String accountType = findUserResults.getString("Type");
//                    Double sold = findUserResults.getDouble("Balance");
//                    Account account;
//                    if (accountType.equals(AccountType.Depozit.name())) {
//                        account = new Depozit(accountId, sold);
//                    } else {
//                        account = new Economii(accountId, sold);
//                    }
//                    customer = new Client(prenume, nume, cnp, account);
//                }
//            }
//        } catch (SQLException ex) {
//            System.err.println("An error has occured." + ex.getMessage());
//        }
//        return customer;
//    }
//    //Update (Edit Account)
//    boolean updateAccount(int accountId, Double newBalance){
//        boolean success = false;
//        Connection connection = connect();
//        try {
//            try (PreparedStatement updateBalance = connection.prepareStatement(
//                    "UPDATE Accounts SET Balance = ? WHERE ID = ?")) {
//                updateBalance.setDouble(1, newBalance);
//                updateBalance.setInt(2, accountId);
//                updateBalance.executeUpdate();
//            }
//            success = true;
//        } catch (SQLException ex) {
//            System.err.println("An error has occured." + ex.getMessage());
//        }
//        return success;
//    }
//    //Delete (Remove Account)
//    boolean deleteAccount(int accountId) { 
//        boolean success = false;
//        Connection connection = connect();
//        try {
//            try (PreparedStatement deleteRecords = connection.prepareStatement(
//                    "DELETE Users,Accounts FROM Users "
//                    + "JOIN Mappings on Users.ID = Mappings.UserId "
//                    + "JOIN Accounts on Accounts.ID = Mappings.AccountId "
//                    + "WHERE Accounts.ID = ?")) {
//                deleteRecords.setInt(1, accountId); 
//                deleteRecords.executeUpdate();
//            }
//            success = true;
//        } catch (SQLException ex) {
//            System.err.println("An error has occured1." + ex.getMessage());
//        }
//        return success;
//    }
//
//    ArrayList<Customer> getAllAccounts() {
//        ArrayList<Customer> customers = new ArrayList<Customer>();
//        Connection connection = connect();
//        try {
//            try (PreparedStatement findUser = connection.prepareStatement(
//                    "SELECT AccountId,FirstName,LastName,CNP,Type,Balance "
//                    + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
//                    + "JOIN Accounts c on b.AccountId = c.ID")) {
//                ResultSet findUserResults = findUser.executeQuery();
//                while (findUserResults.next()) {
//                    String prenume = findUserResults.getString("FirstName");
//                    String nume = findUserResults.getString("LastName");
//                    String cnp = findUserResults.getString("CNP");
//                    String accountType = findUserResults.getString("Type");
//                    Double sold = findUserResults.getDouble("Balance");
//                    int accountId = findUserResults.getInt("AccountId");
//                    Account account;
//                    if (accountType.equals(AccountType.Depozit.name())) {
//                        account = new Depozit(accountId, sold);
//                    } else {
//                        account = new Economii(accountId, sold);
//                    }
//                    Client customer = new Client(prenume, nume, cnp, account);
//                    customers.add(customer);
//                }
//            }
//        } catch (SQLException ex) {
//            System.err.println("An error has occured." + ex.getMessage());
//        }
//        return customers;
//    }
//}
