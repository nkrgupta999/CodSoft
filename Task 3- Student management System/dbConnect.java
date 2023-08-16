import java.sql.*;

public class dbConnect {
   

    public Connection getConnection() throws ClassNotFoundException, SQLException {
       
        String user = "root", pass = "";
        String url = "jdbc:mysql://localhost:3306/studentdata";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
}

