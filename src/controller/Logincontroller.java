package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.DBConnection;
import model.Dbsearch;
import controller.Logincontroller;
import java.sql.Statement;
import view.Home;
import view.login;
import javax.swing.*;
import view.BorrowBook;

public class Logincontroller {
	public static void login(String usName,String pass){
        try{
            Statement stmt;
            stmt=DBConnection.getStatementConnection();
            String username=null;
            String password=null;
        ResultSet rs = new Dbsearch().searchLogin(usName);
        
        while(rs.next()){
        username=rs.getString("username");
        password=rs.getString("password");
        }
        if(username !=null && password !=null){
            if(password.equals(pass)){
                System.out.println("Login Successfully!!!");
                stmt.executeUpdate("INSERT INTO login_now VALUES('"+usName+"','"+pass+"')");
                login.getFrames()[0].dispose();
                new Home().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Please check the credentials" ,"Error",JOptionPane.ERROR_MESSAGE );
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check the credentials","Error",JOptionPane.ERROR_MESSAGE);
        }
    //close the connection
    DBConnection.closeCon();
           
        }catch(SQLException ex){
        Logger.getLogger(Logincontroller.class.getName()).log(Level.SEVERE,null,ex);
    }
}
        public static void login1(String usName, String pass){
            try{
            String username=null;
            String password=null;
        ResultSet rs = new Dbsearch().searchLogin(usName);
        
        while(rs.next()){
        username=rs.getString("username");
        password=rs.getString("password");
        }
        if(username ==null && password ==null){
            if(usName!=null && pass!=null){
            new model.AddUser().login(usName, pass);
            JOptionPane.showMessageDialog(null,"New user added successfully!" ,"Alert!!",JOptionPane.ERROR_MESSAGE );
        }
            else{
               JOptionPane.showMessageDialog(null, "Please check the credentials","Error",JOptionPane.ERROR_MESSAGE); 
            }}
    //close the connection
    DBConnection.closeCon();
           
        }catch(SQLException ex){
        Logger.getLogger(Logincontroller.class.getName()).log(Level.SEVERE,null,ex);
    }
        }
}