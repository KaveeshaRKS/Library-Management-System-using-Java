package model;

import java.sql.Connection;//to connect java application with mysql 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;//to execute queries with the database

public class DBConnection {
	static Connection conn;
    static Statement stat = null;
    
    public static Statement getStatementConnection(){
        try{
        //estabilish the connection
        String url="jdbc:mysql://localhost:3306/thefinal";
        conn = DriverManager.getConnection(url,"root","");
        
       //create the connection
       stat=conn.createStatement();
        }catch (Exception e){
          e.printStackTrace();  
    }
       return stat;
    }

//close the connection 
public static void closeCon()throws SQLException{
    conn.close();
}

}

