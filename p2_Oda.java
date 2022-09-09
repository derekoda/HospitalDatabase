// Derek L. Oda
// Phase 2 Project
// CS 482
// 3/6/2022
// This program will allow us to perfor SQL queries using java

import java.util.*;
import java.io.*;
import java.sql.*;

public class p2_Oda {
   public static void main (String args[]) throws IOException{
         // switch statement to determine with proj the user wants to run
         // if the proj has a parameter, it prints a prompt
         switch(Integer.parseInt(args[0])) {
            case 1:
               proj1(args[1]);
               break;
            case 2:
               proj2();
               break;
            case 3:
               proj3(Integer.parseInt(args[1]));
               break;
            case 4:
               proj4(args[1]);
               break;
            case 5:
               proj5(args[1]);
               break;
            case 6:
               proj6(args[1]);
               break;
            case 7:
               proj7(args[1]);
               break;
            case 8:
               proj8(args[1]);
               break;
         } // end switch
   } // end main
   
   
   // this method finds physicians that have performed a given procedure
   // parameter is given procedure name
   // returns detailed info about physician
   public static void proj1(String procedureName) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT p.physicianID, p.name, p.position, p.ssn " +
            "FROM physician p, undergoes u, `procedure` r " +
            "WHERE p.physicianID = u.physicianID and u.procedureID = r.procID and r.name = \"" + procedureName + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Physician ID: " + rs.getInt(1) + " " + "Name: " + rs.getString(2) + " " + "Position: " +
               rs.getString(3) + " " + "SSN: " + rs.getInt(4));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj1
   
   
   // this method finds appointments where a patient met with a physician other than their primary phys
   // no parameters
   // returns info about the patient and appointment
   public static void proj2() {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT p.name, y.name, a.nurseID, a.startDateTime, a.endDateTime, p.primaryPhysID " +
            "FROM appointment a, patient p, physician y " +
            "WHERE a.patientID = p.patientID and a.physicianID = y.physicianID and a.physicianID != p.primaryPhysID;");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Patient Name: " + rs.getString(1) + " " + "Physician Name: " + rs.getString(2) + " " + "Nurse ID: " +
               rs.getInt(3) + " " + "Start Date/Time: " + rs.getString(4) + " " + "End Date/Time: " + rs.getString(5) + " " + "Primary Physician ID: " + rs.getInt(6));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj2
   
   
   // this method finds patients that have undergone a procedure with a larger cost than the given cost
   // parameter is given cost
   // returns detailed info about the patient
   public static void proj3(int cost) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
        
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT p.patientID, p.ssn, p.`name`, p.address, p.dob, p.phone, p.insuranceNumber, p.primaryPhysID " +
            "FROM patient p, undergoes u, `procedure` r " +
            "WHERE p.patientID = u.patientID and u.procedureID = r.procID and r.cost < \"" + cost + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Patient ID: " + rs.getInt(1) + " " + "SSN: " + rs.getInt(2) + " " + "Name: " + rs.getString(3) + " " + "Address: " + 
               rs.getString(4) + " " + "DOB: " + rs.getString(5) + " " + "Phone: " + rs.getString(6) + " " + "Insurance Number: " + rs.getInt(7) +
               " " + "Primary Physician ID: " + rs.getInt(8));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj3
   
   
   // this method finds the patients whose primary physician is the head of a given department
   // paramter is department in question
   // returns detailed info about physician
   public static void proj4(String department) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT p.patientID, p.ssn, p.name, p.address, p.dob, p.phone, p.insuranceNumber, p.primaryPhysID " +
            "FROM patient p, department d " +
            "WHERE p.primaryPhysID = d.headID and d.name = \"" + department + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Patient ID: " + rs.getInt(1) + " " + "SSN: " + rs.getInt(2) + " " + "Name: " + rs.getString(3) + " " + "Address: " + 
               rs.getString(4) + " " + "DOB: " + rs.getString(5) + " " + "Phone: " + rs.getString(6) + " " + "Insurance Number: " + rs.getInt(7) +
               " " + "Primary Physician ID: " + rs.getInt(8));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj4
   
   
   // this method finds information about a prescribed medication
   // parameter is the name of the medication
   // returns info about the patient, physician, and prescription
   public static void proj5(String medicationName) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");

         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT a.name, y.name, p.prescribedDate " +
            "FROM medication m, prescribes p, patient a, physician y " +
            "WHERE m.medID = p.medicationID and p.patientID = a.patientID and p.physicianID = y.physicianID and m.name = \"" + medicationName + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Patient Name: " + rs.getString(1) + " " + "Physician Name: " + rs.getString(2) + " " + "Prescribed Date: " +
               rs.getString(3));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj5
   
   
   // this method finds nurses who have been on call during a given date
   // parameter is the date in question
   // returns detailed info about the nureses and when they were on call
   public static void proj6(String date) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT n.nurseID, n.name, n.position, n.ssn, o.startDate, o.endDate " +
         "FROM nurse n, oncall o " +
         "WHERE n.nurseID = o.nurseID and DATE(o.startDate) < \"" + date + "\" and DATE(o.endDate) > \"" + date + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Nurse ID: " + rs.getInt(1) + " " + "Nurse Name: " + rs.getString(2) + " " + "Position: " + rs.getString(3) + " " + "SSN: " + 
               rs.getInt(4) + " " + "On Call Start Date: " + rs.getString(5) + " " + "On Call End Date: " + rs.getString(6));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj6
   
   
   // this method finds patients who have stayed in a double room at a given date
   // paramter is the date in question
   // returns detailed info about patients and their stay for each room ID
   public static void proj7(String date) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT r.roomID, p.name, s.startDate, s.endDate " +
            "FROM patient p, stay s, room r " +
            "WHERE p.patientID = s.patientID and s.roomID = r.roomID and DATE(s.startDate) < \"" + date + "\" and DATE(s.endDate) > \"" + date + "\" and r.roomType = \"Double\"" +
            "GROUP BY r.roomType");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Room ID: " + rs.getInt(1) + " " + "Patient Name: " + rs.getString(2) + " " + "Stay Start Date: " + rs.getString(3) + " " + "Stay End Date: " + 
               rs.getString(4));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj7

   
   // this method finds all appointments with physicians associated with a given department name
   // parameter is the department in question
   // returns info about each patient and detailed info about the physician and appointment ID
   public static void proj8(String department) {
      Connection con = null;
      try {
         // create our mysql database connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_medical_center","root","rangersleadtheway");
   
         Statement stmt = con.createStatement();
         
         // this is the SQL Query
         ResultSet rs = stmt.executeQuery("SELECT p.patientID, p.ssn, p.name, p.address, p.dob, p.phone, p.insuranceNumber, p.primaryPhysID, h.physicianID, h.name, h.position, h.ssn, a.appID " +
            "FROM appointment a, affiliatedwith f, patient p, department d, physician h " +
            "WHERE a.physicianID = f.physicianID and a.patientID = p.patientID and f.departmentID = d.deptID and a.physicianID = h.physicianID and d.name = \"" + department + "\";");
         
         // print info from resultset using proper labels
         while (rs.next())
            System.out.println("Patient ID: " + rs.getInt(1) + " " + "SSN: " + rs.getInt(2) + " " + "Patient Name: " + rs.getString(3) + " " + "Address: " + 
               rs.getString(4) + " " + "DOB: " + rs.getString(5) + " " + "Phone: " + rs.getString(6) + " " + "Insurance Number: " + rs.getInt(7) + " " + "Primary Physician ID: " + 
               rs.getInt(8) + " " + "Physician ID: " + rs.getInt(9) + " " + "Physician Name: " + rs.getString(10) + " " + "Physician Position: " + rs.getString(11) + 
               " " + "Physician SSN: " + rs.getInt(12) + " " + "Appointmend ID: " + rs.getInt(13));
         con.close();
      } // end try
    
      catch (Exception e) {
      System.err.println("*--Query Failed--*");
      System.err.println(e.getMessage());
      } // end catch
   } // end proj8
} // end class