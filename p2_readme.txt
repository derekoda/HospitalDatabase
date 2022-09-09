Derek L. Oda
Phase 2 Project
CS 482
3/28/2022
This documents serves as a readme file to p2_Oda.java

Prior to running the program, ensure the database exists locally on the machine you are running the program from. 

Ensure the hostname, user id, database name, and password match with what is in the code. 

In my particular code, the hostname, user id, database name, and password are hardcoded into every method 
so prior to running a method, you will need to change those to match your own database server information.

The program can be run in command line by first compiling the code, then running it using the proj # followed 
by the parameter for that particular query (proj 2 does not have an additional parameter).

How to:

1. Compile the program in the command line using javac p2_Oda.java

2. Use java p2_Oda <proj #> <parameter for that proj>

3. Proj # for this particular program can be 1-8 since that is the number of queries we have

4. If the parameter for your query contains a space, please use quotations to contain the parameter.

Example run without quotes:
javac p2_Oda.java
java p2_Oda 1 Hysterectomy

* This query will return the detailed information for all physicians that have peformed a Hysterectomy.


Example run with quotes:
javac p2_Oda.java
java p2_Oda 1 "Hernia Repair"

*This query will return the detailed information for all physicians that have performed a "Hernia Repair".

