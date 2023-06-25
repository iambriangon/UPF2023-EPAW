package upf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {

    private Connection connection = null;

    public DB() throws Exception {

        // WITHOUT POOL
        String user = "mysql";
        String password ="prac";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/finallab?&user="+user+"&password="+password);

    }

    //execute queries
    public PreparedStatement prepareStatement(String query) throws SQLException{
        // Note that this is done using https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/
        return connection.prepareStatement(query);
    }

    public void disconnectBD() throws SQLException{
        connection.close();
    }
}