package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/regform")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		String mygender = req.getParameter("gender1");
		String mycity = req.getParameter("city1");
		
		PrintWriter out = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EclipseDemo","root","1493");

			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mygender);
			ps.setString(5, mycity);

			int count = ps.executeUpdate();
			if (count > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> User Registered Successfully </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User not Registered Due to Some Error </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
				rd.include(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception Occured"+e.getMessage()+ "</h3>");

			RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
			rd.include(req, resp);
		}
	}

}
