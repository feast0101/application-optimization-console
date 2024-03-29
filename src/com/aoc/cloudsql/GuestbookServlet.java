package com.aoc.cloudsql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class GuestbookServlet extends HttpServlet
{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	  throws IOException {
	   
	  PrintWriter out = resp.getWriter();
	  Connection c = null;
	    try {
	      DriverManager.registerDriver(new AppEngineDriver());
	      c = DriverManager.getConnection("jdbc:google:rdbms://instance_name/guestbook");
	      String fname = req.getParameter("fname");
	      String content = req.getParameter("content");
	      if (fname == "" || content == "") {
	        out.println("<html><head></head><body>You are missing either a message or a name! Try again! Redirecting in 3 seconds...</body></html>");
	      } else {
	      String statement ="INSERT INTO entries (guestName, content) VALUES( ? , ? )";
	      PreparedStatement stmt = c.prepareStatement(statement);
	      stmt.setString(1, fname);
	      stmt.setString(2, content);
	      int success = 2;
	      success = stmt.executeUpdate();
	      if(success == 1) {
	        out.println("<html><head></head><body>Success! Redirecting in 3 seconds...</body></html>");
	      } else if (success == 0) {
	        out.println("<html><head></head><body>Failure! Please try again! Redirecting in 3 seconds...</body></html>");
	      }
	     }
	    } catch (SQLException e) {
	        e.printStackTrace();
	      } finally {
	          if (c != null) 
	            try {
	              c.close();
	            } catch (SQLException ignore) {
	              }
	      } resp.setHeader("Refresh","3; url=/guestbook.jsp");
	  }
}
