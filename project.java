package jdbc;
import java.sql.*;
import java.util.Scanner;


class proj
{
	static void insert()
	{
		try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarining","root","2204");
			PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter ID: ");
			int id=sc.nextInt();
			
			System.out.println("Enter NAME: ");
			String name=sc.next();   
			
			System.out.println("Enter age: ");
			int age=sc.nextInt();
			
			System.out.println("Enter salary: ");
			int salary=sc.nextInt();
			
			System.out.println("Enter desig: ");
			String desig=sc.next(); 
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);
			System.out.println("Data inserted successfully");
			stmt.execute();
			con.close();
	    	}
	    	 catch(Exception e)
	    	 {
	    		 System.out.println(e);
	    	 }
	}
	
	static void display()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","2204");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+": "+rs.getString(2)+": "+rs.getInt(3)+": "+rs.getInt(4)+": "+rs.getString(5));
		}
		
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void update()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","2204");
		PreparedStatement stmt=con.prepareStatement("Update emp set salaray=? where id=?");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		int id=sc.nextInt();
		
		System.out.println("Enter salary: ");
		int salaray=sc.nextInt();
		
		stmt.setInt(1,salary);
		stmt.setInt(2,id);
		
		stmt.execute();
		con.close();
		System.out.println("Data updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void delete()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","2204");
		PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		int id=sc.nextInt();
		
		stmt.setInt(1,id);
		System.out.println("Want to delete data ? yes or no");
		String ch=sc.next();
		if(ch.equalsIgnoreCase("yes"))
		{
			stmt.execute();
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("no data deleted");
		}
		con.close();
		
	}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	static void exit()
	{
		System.out.println("Thank you!");
	}
}

public class project {

	public static void main(String[] args) {
int ch1=0;
	
		
		
		do{ 
		System.out.println("===============================");
		System.out.println("1.Insert");
		System.out.println("2.Display");
		System.out.println("3.Upadate");
		System.out.println("4.Delete");
		System.out.println("5.exit");
		System.out.println("===============================");
		System.out.println("Enter your Choice: ");
		Scanner sc=new Scanner(System.in);
		ch1=sc.nextInt();

		if(ch1==1)
		{
			proj.insert();
		}
		if(ch1==2)
		{
			proj.display();
		}
		if(ch1==3)
		{
			proj.update();
		}
		if(ch1==4)
		{
			proj.delete();
		}
		}while(ch1!=5);
		
	}


	}