import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class RegistrationP extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws 
	ServletException,IOException
	{
		res.setContentType("text/html");
		String Rname=req.getParameter("user");
		String Rphone=req.getParameter("phone");
		String Remail=req.getParameter("email");
		String Rpass=req.getParameter("password");
		String Rcpass=req.getParameter("conpassword");
		
	//	String msg="<html><head><title>Table Created</title></head><body><marquee><h1>table";

		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelres","root","root");
		Statement st=con.createStatement();
		
		String query="insert into reg(r_username,r_mobno,r_email,r_pass,r_cpass) values('"+Rname+"','"+Rphone+"','"+Remail+"','"+Rpass+"','"+Rcpass+"');";
		st.executeUpdate(query);
		
		st.close();
		con.close();
		}
		catch(Exception e)
		{
	//		msg+=" Not "+e;
			System.out.println(e);
		}
		
//	    msg+="Created Successfully123!!!!!!!!!!!!!!!!!!</h1></body></html>";
//		PrintWriter out=res.getWriter();
//		out.println(msg);

        res.sendRedirect("LoginPage.html");
	}
}
		
		