package resumeDBWithServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resumeDBWithServlet.model.ConnectionManager;

/**
 * Servlet implementation class CustomersData
 */
@WebServlet("/CustomersData")
public class CustomersData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionManager  cm = new ConnectionManager();
    Connection theConnection = cm.getConnection();
   
	
	public void doPost (HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {
	        PrintWriter out = res.getWriter();
	        
	        res.setContentType("text/html");
	        out.println("<html>");
	        out.println("<head><title>All Employees</title></head>");
	        out.println("<body>");
	        out.println("<center><h1>All Employees</h1>");
	        
	        
	        String query = "SELECT CustomerID, FirstName, " + "LastName, "
	                + "StreetAddress, State " + "FROM customer ";
	        try{
	        Statement theStatement=theConnection.createStatement();
	        
	        ResultSet rs = theStatement.executeQuery(query);
	        while (rs.next()) {
	          String customerID = rs.getString("CustomerID");
	          String firstName = rs.getString("FirstName");
	          String lastName = rs.getString("LastName");
	          String address = rs.getString("StreetAddress");
	          String state = rs.getString("State");
	          out.print(customerID + "::");
	          out.print(firstName + "::");
	          out.print(lastName + "::");
	          out.print(address + "::");
	          out.print(state + "::");
	        }
	        }catch(Exception e){
	            e.printStackTrace();
	        } 
	        try{

	            Statement theStatement=theConnection.createStatement();
	           //Connect to emaildb Data source
	           ResultSet theResult=theStatement.executeQuery("select * from customer"); //Select all records from user table.

	          //Fetch all the records and print in table
	          while(theResult.next()){
	           out.println();
	           out.println("<TR>");
	           out.println("<TD>" + theResult.getString("CustomerID") + "</TD>");
	           out.println("<TD>" + theResult.getString("FullName") + "</TD>");
	           out.println("<TD>" + theResult.getString("Titile") + "</TD>");
	           out.println("<TD>" + theResult.getString("FirstName") + "</TD>");
	           out.println("<TD>" + theResult.getString(5) + "</TD>");
	           out.println("<TD>" + theResult.getString(6) + "</TD>");
	           out.println("<TD>" + theResult.getString(7) + "</TD>");
	           out.println("<TD>" + theResult.getString(8) + "</TD>");
	           out.println("<TD>" + theResult.getString(9) + "</TD>");
	           out.println("<TD>" + theResult.getString(10) + "</TD>");
	           out.println("<TD>" + theResult.getString(11) + "</TD>");
	           out.println("</TR>");

	          }

	          theResult.close();//Close the result set
	          theStatement.close();//Close statement

	          }catch(Exception e){

	           out.println(e.getMessage());//Print trapped error.

	          }
	        out.println("</center>");
	        out.println("</body>");
	        out.println("</html>");
	         }
	        }


