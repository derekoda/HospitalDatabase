// Derek L. Oda
// Phase 3 Project
// CS 482
// 4/16/2022
// This program provides an interactive application to manipulate databases using command line

import java.util.*;
import java.io.*;
import java.sql.*;

public class p3_Oda {
   // the main method will decide which function to run then branch to the proper method
   public static void main (String args[]) throws IOException {
      Scanner scan = new Scanner(System.in);
      System.out.println("Welcome to the Las Palmas Medical Center Database!");
      System.out.println("Please enter the function you would like to perform. Enter -1 to quit.");
      System.out.println("1: Retrieve all data\n2: Average\n3: Insert\n4: Delete");
      int answer = scan.nextInt();
      System.out.println();
      String tbl, avg;
      
      while (answer != -1) {
         switch(answer) {
            case 1:
               System.out.println("Please enter the table you wish to retrieve all data from.");
               tbl = scan.next();
               scan.nextLine();
               System.out.println();
               retrieve(tbl);
               break;
            case 2:
               System.out.println("Please enter the table name you wish to get an average from.");
               tbl = scan.next();
               scan.nextLine();
               System.out.println("Please enter the column you wish to return the average of.");
               avg = scan.next();
               scan.nextLine();
               System.out.println();
               average(tbl, avg);
               break;
            case 3:
               System.out.println("Please enter the table name you wish to insert data into.");
               tbl = scan.next();
               scan.nextLine();
               System.out.println();
               insert(tbl);
               break;
            case 4:
               System.out.println("Please enter the table name you wish to delete from.");
               tbl = scan.next();
               scan.nextLine();
               System.out.println();
               delete(tbl);
               break;
         } // end switch
         System.out.println("\n");
         System.out.println("Please enter the function you would like to perform. Enter -1 to quit.");
         System.out.println("1: Retrieve all data\n2: Average\n3: Insert\n4: Delete");
         answer = scan.nextInt();
      } // end while
   } // end main
   
   
   // the retrieve method allows the user to view all information in a specified table
   public static void retrieve(String table) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnsNumber = rsmd.getColumnCount();
         
         // print info from resultset
         System.out.println("Here is your data:");
         while (rs.next()){
            for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) 
               System.out.print(",  ");
            String columnValue = rs.getString(i);
            System.out.print(rsmd.getColumnName(i) + ": " +columnValue);
            } // end for
            System.out.println();
         } // end while
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end retrieve
   
   
   // the average method allows the user to choose a table and a column and get the average
   // of that column
   public static void average(String table, String column) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT AVG(" + column + ") FROM " + table);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnsNumber = rsmd.getColumnCount();
         
         // print info from resultset
         System.out.println("The average is:");
         while (rs.next()){
            for (int i = 1; i <= columnsNumber; i++) {
            String columnValue = rs.getString(i);
            System.out.print(columnValue);
            } // end for
            System.out.println();
         } // end while
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end average
   
   
   // the insert method allows a user to view all columns from a given table, then add
   // an entry into that table
   public static void insert(String table) {
      Scanner scan = new Scanner(System.in);
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnsNumber = rsmd.getColumnCount();
         
         // print info from resultset
         System.out.println("The names of the column in the table are:");
         for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) 
               System.out.print(",  ");
            System.out.print(rsmd.getColumnName(i));
         } // end for
         System.out.println("\n");
         stmt = con.createStatement();
         System.out.println("Please enter the record you wish to insert.");
         String insertQ = scan.nextLine();
         stmt.executeUpdate("INSERT into " + table + " values(" + insertQ + ")");
         System.out.println("Record was successfully inserted.");
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end insert
   
   
   // the delete method allows a user to view all columns from a given table, then delete
   // information within that table
   public static void delete(String table) {
      Scanner scan = new Scanner(System.in);
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnsNumber = rsmd.getColumnCount();
         
         // print info from resultset
         System.out.println("The names of the column in the table are:");
         for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) 
               System.out.print(",  ");
            System.out.print(rsmd.getColumnName(i));
         } // end for
         System.out.println("\n");
         
         stmt = con.createStatement();
         System.out.println("Please enter the record you wish to delete.");
         String insertD = scan.nextLine();
         stmt.executeUpdate("DELETE FROM " + table + " WHERE " + insertD);
         System.out.println("Record was successfully deleted.");
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch

   } // end delete
} // end P2_Oda