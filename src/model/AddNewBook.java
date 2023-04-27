/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VENUSHA
 */
public class AddNewBook {
    public static String x="Kavi";
    public static String v="Jug";
    public static String s="Hello";
    
    public static void AddBooks(String bname, String isbn, String author, String category, String copies){
        try{
            Statement stmt=DBConnection.getStatementConnection();
            stmt.execute("INSERT INTO books VALUES ('"+bname+"','"+isbn+"', '"+author+"', '"+category+"', '"+copies+"')");
            JOptionPane.showMessageDialog(null,"New book was added successfully!", "Alert", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void AddBorrowBooks(String bname, String isbn, String cat, String user, String status){
        try{
            Statement stmt=DBConnection.getStatementConnection();
            ResultSet r;
            r=stmt.executeQuery("SELECT status,user_name,isbn_no FROM borrow_book WHERE user_name='"+user+"'");
            if(r.next()){
                String jk=r.getString("status");
                String us=r.getString("user_name");
                String is=r.getString("isbn_no");
                if(jk.equals(status)){
                    if(us.equals(user)){
                        if(is.equals(isbn)){
                    JOptionPane.showMessageDialog(null,"You have already borrowed this book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    s="";
                }else{
                     JOptionPane.showMessageDialog(null,"You can not borrow morethan one book!", "Alert", JOptionPane.ERROR_MESSAGE);
                     s="";
                     v="";
                        }
                    }else{
                      JOptionPane.showMessageDialog(null,"The selected book is borrowed by someone!", "Alert", JOptionPane.ERROR_MESSAGE);
                      s="";  
                    }
                }
                else{
                    if(us.equals(user)){
                        if(is.equals(isbn)){
                            r=stmt.executeQuery("SELECT status FROM borrow_book WHERE isbn_no='"+isbn+"'");
                            if(r.next()){
                                String st=r.getString("status");
                                if(st.equals("Borrowed")){
                                    JOptionPane.showMessageDialog(null,"The book you selected is borrowed by someone!", "Alert", JOptionPane.ERROR_MESSAGE);
                                    s="";
                                }else{
                                    stmt.execute("DELETE FROM borrow_book WHERE user_name='"+user+"' AND status='Reserved' AND isbn_no='"+isbn+"'");
                                    s="Hello";
                                }
                            }
                }
                    }
                }x="";
            }
            r=stmt.executeQuery("SELECT isbn_no,user_name FROM borrow_book WHERE status='Borrowed'");
            while(r.next() && x.equals("Kavi")){
                String isb=r.getString("isbn_no");
                String un=r.getString("user_name");
                if(isb.equals(isbn) && un!=user){
                JOptionPane.showMessageDialog(null,"The book you selected is borrowed by someone!", "Alert", JOptionPane.ERROR_MESSAGE);
                s="";
            }else if(isb!=isbn && un.equals(user) && v.equals("Jug")){
                JOptionPane.showMessageDialog(null,"You can not borrow morethan one book!", "Alert", JOptionPane.ERROR_MESSAGE);
                s="";
            }
            }
            if(s.equals("Hello")){
                    stmt.execute("INSERT INTO borrow_book VALUES ('"+bname+"','"+isbn+"', '"+cat+"', '"+user+"', '"+status+"')");
                    JOptionPane.showMessageDialog(null,"You borrowed a book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    x="";
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void AddReserveBooks(String bname, String isbn, String cat, String user, String status){
        try{
            Statement stmt=DBConnection.getStatementConnection();
            ResultSet r;
            r=stmt.executeQuery("SELECT status,user_name,isbn_no FROM borrow_book WHERE user_name='"+user+"'");
            while(r.next()){
                String j=r.getString("status");
                String u=r.getString("user_name");
                String i=r.getString("isbn_no");
                if(j.equals(status)){
                    if(u.equals(user)){
                        if(i.equals(isbn)){
                    JOptionPane.showMessageDialog(null,"You have already reserved this book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    s="";
                }else{
                    JOptionPane.showMessageDialog(null,"You can not reserve morethan one book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    s="";        
                        }
                    }else{
                    JOptionPane.showMessageDialog(null,"The book you selected is reserved by someone!", "Alert", JOptionPane.ERROR_MESSAGE);
                    s="";   
                    }
                }
                else{
                    if(u.equals(user)){
                        if(i.equals(isbn)){
                    JOptionPane.showMessageDialog(null,"You have already borrowed this book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    s="";
                }}else{
                        if(j.equals("Reserved")){
                            JOptionPane.showMessageDialog(null,"You can not reserve morethan one book!", "Alert", JOptionPane.ERROR_MESSAGE);
                    }}
                }
                x="";
            }
            r=stmt.executeQuery("SELECT isbn_no,user_name FROM borrow_book WHERE status='Reserved'");
            while(r.next() && x.equals("Kavi")){
                String isb=r.getString("isbn_no");
                String un=r.getString("user_name");
                if(isb.equals(isbn) && un!=user){
                JOptionPane.showMessageDialog(null,"The book you selected is reserved by someone!", "Alert", JOptionPane.ERROR_MESSAGE);
                s="";
            }}
            if(s.equals("Hello")){
            stmt.execute("INSERT INTO borrow_book VALUES ('"+bname+"','"+isbn+"', '"+cat+"', '"+user+"', '"+status+"')");
            JOptionPane.showMessageDialog(null,"You reserved a book!", "Alert", JOptionPane.ERROR_MESSAGE);
            x="";
        }}catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void AddReturnBooks(String bname, String isbn, String cat, String user, String status){
        try{
            Statement stmt=DBConnection.getStatementConnection();
            ResultSet r;
            String j="";
            r=stmt.executeQuery("SELECT status,user_name FROM borrow_book WHERE isbn_no='"+isbn+"'");
            if(r.next()){
                j=r.getString("status");
                String u=r.getString("user_name");
                if(j.equals("Borrowed")  && u.equals(user)){
                   stmt.execute("DELETE FROM borrow_book WHERE isbn_no= '"+isbn+"' AND user_name='"+user+"'");
                   stmt.execute("INSERT INTO returned_books VALUES('"+bname+"', '"+isbn+"', '"+cat+"', '"+user+"')");
                   JOptionPane.showMessageDialog(null,"You returned a book!", "Alert", JOptionPane.ERROR_MESSAGE); 
                }else{
                   JOptionPane.showMessageDialog(null,"You can not return a book before borrow!", "Alert", JOptionPane.ERROR_MESSAGE); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"You can not return a book before borrow!", "Alert", JOptionPane.ERROR_MESSAGE);
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     public static void AddBBooks(String bname, String isbn, String cat, String user, String status){
     }
      public static void AddRBooks(String bname, String isbn, String cat, String user, String status){
     }
}
