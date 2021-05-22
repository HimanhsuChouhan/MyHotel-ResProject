import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LoginP extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws 
	ServletException,IOException
	{
		res.setContentType("text/html");
		String Luser=req.getParameter("un");
	
		String Lpass=req.getParameter("pw");
		
		String msg="<html><head><title>Login Status</title></head><body><h1>";

		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelres","root","root");
		Statement st=con.createStatement();
		
		String query="select r_email,r_pass from reg";
		String uName,uPass;
	//	st.executeUpdate(query);
		ResultSet rs=st.executeQuery(query);
		while (rs.next()) {
                
                uName = rs.getString(1);
				uPass = rs.getString(2);
          
		      if(Luser.equals(uName) && Lpass.equals(uPass)){
		     	  msg+=" "+uName+" "+uPass;
				  res.sendRedirect("YesORno.html");  
				  
		    	  break;
		  }          	            
                
        }

		
	
		rs.close();
		st.close();
		con.close();
		}
		catch(Exception e)
		{
			msg+=" Not "+e;
			System.out.println(e);
		}
		
//	    msg+="Created Successfully123!!!!!!!!!!!!!!!!!!</h1></body></html>";
		msg+=" Wrong UserName & Password</h1></body></html>";
		PrintWriter out=res.getWriter();
		out.println(msg);

       
	}
}
		
		