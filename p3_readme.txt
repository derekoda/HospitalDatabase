Derek L. Oda
Phase 3 Project
CS 482
4/16/2022

This document serves as a readme file to p3_Oda.java

Prior to running the program, ensure the database exists locally on the machine you are 
running the program from. 

Ensure the hostname, user id, database name, and password match with what is in the code. 

In my particular code, the hostname, user id, database name, and password are hardcoded 
into every method so prior to running a method, you will need to change those to match 
your own database server information.

RETRIEVE ALL DATA 
1. To use the retrieve all data function, you will select 1 at the initial prompt.
2. The program will prompt you to enter the table name you wish to view.
3. Enter the table name and you will see all data within that table.

AVERAGE
1. To use the average function, you will select 2 at the initial prompt.
2. The program will prompt you to enter the table name you wish to view, enter the table 
   name.
3. The program will then prompt you to enter the column name you wish to get the average 
   of, enter the column name.
4. The program will give you one value, the average of the column you chose.

INSERT
1. To use the insert function, you will select 3 at the initial prompt.
2. The program will prompt you to enter the table name you wish to insert values into.
3. The program will display all columns within that table.
4. The program will then prompt you to enter the data you wish to insert.
5. YOU DO NOT NEED TO WRITE THE ENTIRE QUERY. Just the data.
   Ex: If you select the Physician table, enter your data like this: 
   11111, 'Derek Oda', 'Intern', 111111111
6. The program will then either tell you your entry was successful or give you the mySQL 
   error that occured.

DELETE
1. To use the delete function, you will select 4 at the initial prompt.
2. The program will prompt you to enter the table name you wish to delete values from.
3. The program will display all columsn within that table.
4. The program will then prompt you to enter the data you wish to delete.
5. YOU DO NOT NEED TO WRITE THE ENTIRE QUERY. Just the data.
   Ex: If you select the Physician table, enter your data like this: physicianID = 11111
6. The program will then either tell you your deletion was successful or give you the 
   mySQL error that occured.

EXIT
1. The program will continue to ask you for prompts until you enter -1 at the main menu.
2. You may only exit the program from the main menu.
