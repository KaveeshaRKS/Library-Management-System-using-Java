/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Statement;

/**
 *
 * @author VENUSHA
 */
public class AddUser {
    Statement stmt;
    
    public void login(String name, String password){
        try{
           stmt=DBConnection.getStatementConnection();
           stmt.executeUpdate("INSERT INTO login VALUES ('"+name+"', '"+password+"')");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
