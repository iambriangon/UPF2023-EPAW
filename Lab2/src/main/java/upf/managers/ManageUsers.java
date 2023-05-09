package upf.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upf.models.User;
import upf.utils.DB;

public class ManageUsers {

    private DB db = null;

    public ManageUsers() {
        try {
            db = new DB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalize() {
        try {
            db.disconnectBD();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    // Add new user
    public void addUser(String name, String mail, String pwd) {
        String query = "INSERT INTO users (usr,mail,pwd) VALUES (?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, mail);
            statement.setString(3, pwd);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*Check if all the fields are filled correctly */
    public boolean isComplete(User user) {
        return (hasValue(user.getUser()) &&
                hasValue(user.getMail()) &&
                hasValue(user.getPwd1()) &&
                hasValue(user.getPwd2()));
    }

    private boolean isAlreadyRegistered(User user) throws SQLException {
        ResultSet u = getUserFromDB(user.getUser());
        ResultSet e = getEmailFromDB(user.getMail());

        return true;
    }


    private boolean hasValue(String val) {
        return ((val != null) && (!val.equals("")));
    }

    private ResultSet getUserFromDB(String username) {
        String query = "SELECT usr FROM users WHERE usr = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, username);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet getEmailFromDB(String email) {
        String query = "SELECT mail FROM users WHERE mail = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, email);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
