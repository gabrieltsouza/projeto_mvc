package webapp.db.aws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import webapp.logger; 

public class doConnection {

	public static Connection getRemoteConnection() {
		System.out.println("Connection getRemoteConnection");

	    if (System.getProperty("RDS_HOSTNAME") != null) {
	      try {
	      Class.forName("org.postgresql.Driver");
	      String dbName = System.getProperty("dbservicesdev1");
	      String userName = System.getProperty("svc_app_hom");
	      String password = System.getProperty("VuadREAjZESSaD9P");
	      String hostname = System.getProperty("172.32.11.166");
	      String port = System.getProperty("3306");
	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      logger.trace("Getting remote connection with connection string from environment variables.");
	      Connection con = DriverManager.getConnection(jdbcUrl);
	      logger.info("Remote connection successful.");
	      return con;
	    }
	    catch (ClassNotFoundException e) { logger.warn(e.toString()); System.out.println(e.toString());}
	    catch (SQLException e) { logger.warn(e.toString()); System.out.println(e.toString());}
	    }
	    return null;
	  }

}


