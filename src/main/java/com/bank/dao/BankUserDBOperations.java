package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class BankUserDBOperations {
     DBconnection ob=new DBconnection();
     Connection conn=ob.connection();

     public boolean login(long accid,String password) throws SQLException
		{
				
			PreparedStatement stmt=conn.prepareStatement("select * from bankuser where userId=? and userPassword=? ");
			stmt.setLong(1, accid);
			stmt.setString(2,password);
			
			ResultSet result=stmt.executeQuery();
			if(result.next()) //true or false
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	 	
	 	public void logout() throws SQLException
		{
			conn.close();
			
		}
	 	
	 	public boolean changePassword(long accid,String newPassword) throws SQLException
		{
			PreparedStatement stmt=conn.prepareStatement("update bankuser set userPassword=? where userId=? ");
			stmt.setString(1,newPassword);
			stmt.setLong(2, accid);
			int affectedRows=stmt.executeUpdate();
			if(affectedRows>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
	 	
	 	
	 	synchronized public void deposit(double depositAmount,long userid)
	 	{
	 		try
	 		{
	 		PreparedStatement stmt=conn.prepareStatement("select * from bankuser where userId=? ");
			stmt.setLong(1, userid);	
			ResultSet result=stmt.executeQuery();
			double availableBalance=0.0;
			  while(result.next())
			  {
				  availableBalance=result.getDouble(5); 
			  }
			  
			  availableBalance=availableBalance + depositAmount;
			  
			  PreparedStatement stmt1=conn.prepareStatement("update bankuser set balance=? where userId=?");
			  stmt1.setDouble(1, availableBalance);
			  stmt1.setLong(2,userid);
			  int affectedRows=stmt1.executeUpdate();
			  if(affectedRows>0)
			  {
				  System.out.println("Deposit Successfull!!");
				  System.out.println("Available Balance:"+availableBalance);
			  }
			  else
			  {
				System.out.println("Problem in deposit operation!!");  
			  }
				 			
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println("Something went wrong!!");
	 		}
	 		}
	 	
	 	
	 	synchronized public void withdraw(double withdrawalAmount,long userid)
	 	{
	 		try
	 		{
	 		PreparedStatement stmt=conn.prepareStatement("select * from bankuser where userId=? ");
			stmt.setLong(1, userid);	
			ResultSet result=stmt.executeQuery();
			double availableBalance=0.0;
			  while(result.next())
			  {
				  availableBalance=result.getDouble(5); 
			  }
			  
			  if(withdrawalAmount<=availableBalance)
			  {
			  availableBalance=availableBalance - withdrawalAmount;
			  PreparedStatement stmt1=conn.prepareStatement("update bankuser set balance=? where userId=?");
			  stmt1.setDouble(1, availableBalance);
			  stmt1.setLong(2,userid);
			  int affectedRows=stmt1.executeUpdate();
				  if(affectedRows>0)
				  {
					  System.out.println("Withdrawal Successfull!!");
					  System.out.println("Remaining Balance:"+availableBalance);
				  }
				  else
				  {
					System.out.println("Problem in withdrawal operation!!");  
				  }
			  }
			  else
			  {
				  System.out.println("Sufficient balance not available!!");
			  }
			 
				 			
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println("Something went wrong!!");
	 		}
	 		}
	 	
	 	synchronized public void fundTransfer(long senderId,long receiverId,double tamount)
	 	{
	 		ResultSet rs=null;
	 		try
	 		{
	 		PreparedStatement pr1=conn.prepareStatement("select * from bankuser where userId=?");
	 		pr1.setLong(1,senderId);
	 		rs=pr1.executeQuery();
	 		double senderBalance=0.0;
	 		
	 		while(rs.next())
	 		{
	 			senderBalance=rs.getDouble(5);	
	 		}
	 		
	 		if(senderBalance>=tamount)
	 		{
	 			senderBalance=senderBalance-tamount;
	 			pr1=conn.prepareStatement("update bankuser set balance=? where userId=?");
	 			pr1.setDouble(1, senderBalance);
		 		pr1.setLong(2,senderId);
		 		pr1.executeUpdate();
	 			
	 		}
	 		else
	 		{
	 			System.out.println("Insufficient balance for fund transfer!!");
	 		}
	 		
	 		//For receiver balance updation
	 		pr1=conn.prepareStatement("select * from bankuser where userId=?");
	 		pr1.setLong(1,receiverId);
	 		rs=pr1.executeQuery();
	 		double receiverBalance=0.0;
	 		
	 		while(rs.next())
	 		{
	 			receiverBalance=rs.getDouble(5);	
	 		}
	 		
	 		receiverBalance=receiverBalance+tamount;
	 
			pr1=conn.prepareStatement("update bankuser set balance=? where userId=?");
			pr1.setDouble(1, receiverBalance);
	 		pr1.setLong(2,receiverId);
	 		pr1.executeUpdate();
	 		
	 		
	 		
	 		Random r=new Random();
	 		long tid=(long)r.nextLong(99999);//10000
	 		
	 		Date d=new Date();//java.util
	 		Timestamp tdate=new Timestamp(d.getTime());//java.sql
	 		
	 		pr1=conn.prepareStatement("insert into transactions values(?,?,?,?,?)");
	 		pr1.setLong(1, tid);
	 		pr1.setDouble(2, tamount);
	 		pr1.setTimestamp(3, tdate);
	 		pr1.setLong(4, senderId);
	 		pr1.setLong(5, receiverId);
	 		
	 		if(pr1.executeUpdate()>0)
	 		{
	 			System.out.println("Fund transfer successfull!!");
	 		}
	 		else
	 		{
	 			System.out.println("problem in fund transfer!!");
	 		}
	 		
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println("somthing went wrong!!");
	 		}
	 	}
	 	
	 	synchronized public ResultSet transactions(long accid)
	 	{
	 		ResultSet rs=null;
	 		try
	 		{
	 		PreparedStatement pr=conn.prepareStatement("select * from transactions where senderId=?");
	 		pr.setLong(1, accid);
	 		rs=pr.executeQuery();
	 		
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println("Something went wrong!!");
	 		}
	 		return rs;
	 	}
	 	
	 	public ResultSet balanceCheck(long accid)
	 	{
	 		ResultSet rs=null;
	 		try
	 		{
	 		PreparedStatement pr=conn.prepareStatement("select * from bankuser where userId=?");
	 		pr.setLong(1, accid);
	 		rs=pr.executeQuery();
	 		
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e.getMessage());
	 			System.out.println("Somethinng went wrong!!");
	 		}
	 		return rs;
	 	}
	

}

        	
    
