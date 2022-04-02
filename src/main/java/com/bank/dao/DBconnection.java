package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconnection {

	public Connection connection()
	{
Connection conn=null;
		
		String databaseUrl="jdbc:mysql://localhost:3307/bankapplication";
        String userName="root";
        String userPassword="susmita";
        
        try
        {
        	conn=DriverManager.getConnection(databaseUrl,userName,userPassword);
        	
        }
        catch(SQLException e)
        {
        	System.out.println("Internal Server Error!!");
        }
       return conn;
    	}
	public static void main(String args[]) {
		

		DBconnection db=new DBconnection();
		Connection conn=db.connection();
		if(conn==null) {
			System.out.println("unsucessfully");
		}else {
			System.out.println("sucessfully");
		}
	}
	}

	

