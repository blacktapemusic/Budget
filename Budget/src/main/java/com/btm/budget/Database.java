/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import java.awt.Color;
import static java.awt.Color.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STEL
 */
public class Database {
    Connection connexion;
    
    public Database() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
    {
        Class.forName("org.hsqldb.jdbcDriver").newInstance();
        
        connexion = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\STEL\\Documents\\NetBeansProjects\\Budget\\db\\db2", "sa",  "");    
    }
    
    public void closeConnexion() throws SQLException
    {
        Statement statement = connexion.createStatement();
        statement.executeQuery("SHUTDOWN");
        statement.close();
    }
    
    public void initDB() throws SQLException
    {
        Statement statement = connexion.createStatement() ;

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS account (" + 
                "id INT IDENTITY, " +
                "name VARCHAR(1024), " +
                ")");
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS solde (" + 
                "id INT IDENTITY, " +
                "value DOUBLE, "+
                "date DATE, " +
                "account_id INT FOREIGN KEY REFERENCES account(id), " +
                ")");
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS category (" + 
                "id INT IDENTITY, " +
                "value VARCHAR(1024),"+
                "UNIQUE(value)"+
                ")");
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS subCategory (" + 
                "id INT IDENTITY, " +
                "value VARCHAR(1024), " +
                "UNIQUE(value)"+
                ")");
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS operation (" + 
                "id INT IDENTITY, " +
                "name VARCHAR(1024), " +
                "value DOUBLE NOT NULL, "+
                "factChecker BOOLEAN NOT NULL, " +
//                "periodic INT NOT NULL, " +
                "inOrOut BOOLEAN NOT NULL, " +
                "date DATE NOT NULL, " +
                "memo VARCHAR(1024), " +
                "category_id INT FOREIGN KEY REFERENCES category(id), " +
                "subCategory_id INT FOREIGN KEY REFERENCES subCategory(id), " +
                "account_id INT FOREIGN KEY REFERENCES account(id), " +
                "color INT," +
                ")");
        
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS forecastDeal (" + 
                "id INT IDENTITY, " +
                "name VARCHAR(1024), " +
                "value DOUBLE NOT NULL, "+
                "factChecker BOOLEAN NOT NULL, " +
//                "periodic INT NOT NULL, " +
                "inOrOut BOOLEAN NOT NULL, " +
                "date DATE NOT NULL, " +
                "memo VARCHAR(1024), " +
                "category_id INT FOREIGN KEY REFERENCES category(id), " +
                "subCategory_id INT FOREIGN KEY REFERENCES subCategory(id), " +
                "account_id INT FOREIGN KEY REFERENCES account(id), " +
                "color INT," +
                ")");
    }
//    
//    /***************************************************************************/
//    
//    public void insertOperation(Operation operation) throws SQLException
//    {
//        String sql = "INSERT INTO operation "
//                + "(value, checkOk, periodic, inOrOut, date, memo, category, subCategory, color, account) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setDouble(1, operation.getValue());
//        statement.setBoolean(2, operation.isCheck());
//        statement.setBoolean(3, operation.isPeriodic());
//        statement.setBoolean(4, operation.isInOrOut());
//        statement.setDate(5, new java.sql.Date(operation.getDate().getDate().getTime()));
//        statement.setString(6, operation.getMemo()); 
//        statement.setInt(7, operation.getCategory().getId());
//        statement.setInt(8, operation.getSubCategory().getId());
//        statement.setInt(9, colotToInt(operation.getColor()));
//        statement.setInt(10, operation.getAccount());
//        
//        statement.executeUpdate();
//        
//        operation.setId(getLastId("operation"));
//    }
//    
//    public void updateOperation(Operation operation) throws SQLException
//    {
//        String sql = "UPDATE operation "
//                + "SET "
//                + "value = ?, checkOk = ?, periodic = ?, inOrOut = ?, date = ?, memo = ?, category = ?, subCategory = ?, color = ?, account = ? "
//                + "WHERE id = ?";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setDouble(1, operation.getValue());
//        statement.setBoolean(2, operation.isCheck());
//        statement.setBoolean(3, operation.isPeriodic());
//        statement.setBoolean(4, operation.isInOrOut());
//        statement.setDate(5, new java.sql.Date(operation.getDate().getDate().getTime()));
//        statement.setString(6, operation.getMemo()); 
//        statement.setInt(7, operation.getCategory().getId());
//        statement.setInt(8, operation.getSubCategory().getId());
//        statement.setInt(9, colotToInt(operation.getColor()));
//        statement.setInt(10, operation.getAccount());
//        statement.setInt(11, operation.getId());
//        
//        
//        statement.executeUpdate();
//    }
//    
//    // TODO
//    public List<Operation> getOperationList(SmallDate date) throws SQLException
//    {
//        List<Operation> operationList =  new ArrayList<Operation>();
//        
//        String sql = "SELECT * FROM operation "
//                + "WHERE "
//                + "MONTH(date) = ? AND YEAR(DATE) = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, date.getMonth());
//        statement.setInt(2, date.getYear());
//        
//        ResultSet result = statement.executeQuery();
//        Operation operation;
//        while(result.next())
//        {  
//            operation = new Operation(
//                result.getDouble("value"),
//                result.getBoolean("checkOk"),
//                result.getBoolean("periodic"),
//                result.getBoolean("inOrOut"),
//                new SmallDate(result.getDate("date")),
//                result.getString("memo"),
//                null,
//                null,
//                intToColor(result.getInt("color")),
//                result.getInt("id"),
//                result.getInt("account")
//            );
//            
//            operation.setCategory(getCategory(result.getInt("category")));
//            operation.setSubCategory(getSubCategory(result.getInt("subCategory")));
//            
//            operationList.add(operation);           
//        }
//        
//        return operationList;
//    }
//    
//    public void deleteOperation(Operation operation) throws SQLException
//    {
//        String sql = "DELETE FROM operation "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, operation.getId());
//        
//        statement.executeUpdate();
//        
//        operation.setId(-1);
//    }
//    
//    /***************************************************************************/
//    
//    public void insertCategory(Category category) throws SQLException
//    {
//        String sql = "INSERT INTO category "
//                + "(value) "
//                + "VALUES (?) ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, category.getCategory());
//        
//        statement.executeUpdate();
//        
//        category.setId(getLastId("category"));
//    }
//    
//    public Category getCategory(int id) throws SQLException
//    {
//        Category category; 
//        
//        String sql = "SELECT * FROM category "
//                + "WHERE "
//                + "id = ?";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, id);
//        
//        ResultSet result = statement.executeQuery();
//        while(result.next())
//        {  
//            category = new Category(
//                result.getInt("id"),
//                result.getString("value")
//            );    
//            return category;
//        }
//        
//        return null;
//    }
//    
//    public void updateCategory(Category category) throws SQLException
//    {
//        String sql = "UPDATE category "
//                + "SET "
//                + "value = ? "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, category.getCategory());
//        statement.setInt(2, category.getId());
//        
//        statement.executeUpdate();
//    }
//    
//    public void deleteCategory(Category category) throws SQLException
//    {
//        String sql = "DELETE FROM category "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, category.getId());
//        
//        statement.executeUpdate();
//        
//        category.setId(-1);
//    }
//    
//    /***************************************************************************/
//    
//    public void insertSubCategory(SubCategory subCategory) throws SQLException
//    {
//        String sql = "INSERT INTO subCategory "
//                + "(value) "
//                + "VALUES (?) ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, subCategory.getSubCategory());
//        
//        statement.executeUpdate();
//        
//        subCategory.setId(getLastId("subCategory"));
//    }
//    
//    public SubCategory getSubCategory(int id) throws SQLException
//    {
//        SubCategory subCategory; 
//        
//        String sql = "SELECT * FROM subcategory "
//                + "WHERE "
//                + "id = ?";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, id);
//        
//        ResultSet result = statement.executeQuery();
//        while(result.next())
//        {  
//            subCategory = new SubCategory(
//                result.getInt("id"),
//                result.getString("value")
//            );    
//            return subCategory;
//        }
//        
//        return null;
//    }
//    
//    public void updateSubCategory(SubCategory subCategory) throws SQLException
//    {
//        String sql = "UPDATE subCategory "
//                + "SET "
//                + "value = ?"
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, subCategory.getSubCategory());
//        statement.setInt(2, subCategory.getId());
//        
//        statement.executeUpdate();
//    }
//    
//    public void deleteSubCategory(SubCategory subCategory) throws SQLException
//    {
//        String sql = "DELETE FROM subCategory "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, subCategory.getId());
//        
//        statement.executeUpdate();
//        
//        subCategory.setId(-1);
//    }
//    
//    /***************************************************************************/
//    
//    public void insertAccount(Account account) throws SQLException
//    {
//        String sql = "INSERT INTO account "
//                + "(name) "
//                + "VALUES (?) ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, account.getName());
//        
//        statement.executeUpdate();
//        
//        account.setId(getLastId("account"));
//    }
//    
//    public Account getAccount(int id) throws SQLException
//    {
//        Account account; 
//        
//        String sql = "SELECT * FROM account "
//                + "WHERE "
//                + "id = ?";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, id);
//        
//        ResultSet result = statement.executeQuery();
//        while(result.next())
//        {  
//            account = new Account(
//                result.getInt("id"),
//                result.getString("name")
//            );    
//            return account;
//        }
//        
//        return null;
//    }
//    
//    public void updateAccount(Account account) throws SQLException
//    {
//        String sql = "UPDATE account "
//                + "SET "
//                + "name = ?"
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setString(1, account.getName());
//        statement.setInt(2, account.getId());
//        
//        statement.executeUpdate();
//    }
//    
//    public void deleteAccount(Account account) throws SQLException
//    {
//        String sql = "DELETE FROM account "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, account.getId());
//        
//        statement.executeUpdate();
//        
//        account.setId(-1);
//    }
//      
//    /**
//     * @throws java.sql.SQLException*************************************************************************/
//    
//    public void insertSolde(Solde solde) throws SQLException
//    {
////        String sql = "INSERT INTO solde "
////                + "(value, date, account) "
////                + "VALUES (?, ?, ?) ";
////
////        PreparedStatement statement = connexion.prepareStatement(sql);
////        
////        statement.setDouble(1, solde.getValue());
////        statement.setDate(2, new java.sql.Date(solde.getDate().getDate().getTime()));
////        statement.setInt(3, solde.getAccount()); 
////        
////        statement.executeUpdate();
////        
////        solde.setId(getLastId("solde"));
//    }
//    
//    public void updateSolde(Solde solde) throws SQLException
//    {
////        String sql = "UPDATE solde "
////                + "SET "
////                + "value = ?, date = ?, account = ?"
////                + "WHERE id = ?";
////
////        PreparedStatement statement = connexion.prepareStatement(sql);
////        
////        statement.setDouble(1, solde.getValue());
////        statement.setDate(2, new java.sql.Date(solde.getDate().getDate().getTime()));
////        statement.setInt(3, solde.getAccount()); 
////        statement.setInt(4, solde.getId()); 
////        
////        statement.executeUpdate();
//    }
//    
//    // TODO
//    public Solde getSolde(SmallDate date) throws SQLException
//    {
////        String sql = "SELECT * FROM solde "
////                + "WHERE "
////                + "MONTH(date) = ? AND YEAR(DATE) = ? ";
////
////        PreparedStatement statement = connexion.prepareStatement(sql);
////        
////        statement.setInt(1, date.getMonth());
////        statement.setInt(2, date.getYear());
////        
////        ResultSet result = statement.executeQuery();
////        Solde solde;
////        while(result.next())
////        {  
////            solde = new Solde(
////                result.getInt("id"),
////                result.getDouble("value"),
////                new SmallDate(result.getDate("date")),
////                result.getInt("account")
////            );
////            
////            return solde;
////        }
//        
//        return null;
//    }
//    
//    public void deleteSolde(Solde solde) throws SQLException
//    {
//        String sql = "DELETE FROM solde "
//                + "WHERE id = ? ";
//
//        PreparedStatement statement = connexion.prepareStatement(sql);
//        
//        statement.setInt(1, solde.getId());
//        
//        statement.executeUpdate();
//        
//        solde.setId(-1);
//    }
//
//    
//    /***************************************************************************/
//    
//    
//    public int getLastId(String table) throws SQLException
//    {
//        Statement statement = connexion.createStatement() ;
//
//        ResultSet result = statement.executeQuery("SELECT TOP 1 id FROM " 
//                + table + " ORDER BY id DESC"); 
//        
//        if(result.next())
//            return result.getInt("id");
//        return -1; 
//    }
    
    public void dropAllTable() throws SQLException
    {
        Statement statement = connexion.createStatement();
        statement.executeUpdate("DROP SCHEMA PUBLIC CASCADE");
    }
    
//    public Color intToColor(int color)
//    {
//        if(color == 1)
//            return black;
//        if(color == 2) 
//            return blue;
//        if(color == 3)   
//            return gray;
//        if(color == 4)  
//            return green;
//        if(color == 5)
//            return orange;
//        if(color == 6)
//            return pink;            
//        if(color == 7)
//            return red;
//        if(color == 8)
//            return white;
//        if(color == 9)
//            return yellow;
//        return null; 
//    }
//    
//    public int colotToInt(Color color)
//    {
//        if(color == black)
//            return 1;
//        if(color == blue) 
//            return 2;
//        if(color == gray)   
//            return 3;
//        if(color == green)  
//            return 4;
//        if(color == orange)
//            return 5;
//        if(color == pink)
//            return 6;            
//        if(color == red)
//            return 7;
//        if(color == white)
//            return 8;
//        if(color == yellow)
//            return 9;
//        return 0; 
//    }
}
