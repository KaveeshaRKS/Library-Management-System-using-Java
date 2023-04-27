package model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.FogotPassword;
import view.Home;
import view.login;

public class Dbsearch {
	 ResultSet rs;
	 Statement stmt;
	
    public ResultSet searchLogin(String usName){
       try{
           stmt= DBConnection.getStatementConnection();
           String name = usName;
           //execute the query
           rs =stmt.executeQuery("SELECT * FROM login WHERE username='" + name+"'");
       } catch(Exception e){
           e.printStackTrace();
       }
       return rs;
    }
      public static void searchLoginone(String usName, String pw, String pw1){
       try{
           Statement stmt= DBConnection.getStatementConnection();
           String name = usName;
           //execute the query
            stmt.executeUpdate(" UPDATE login"
                    + " SET password='"+pw+"'"
                    + " WHERE username='"+name+"'");
            JOptionPane.showMessageDialog(null, "Password updated!", "Alert!!", JOptionPane.ERROR_MESSAGE);
            FogotPassword.getFrames()[0].dispose();
            new login().setVisible(true);
       } catch(Exception e){
           e.printStackTrace();
       }
    }}