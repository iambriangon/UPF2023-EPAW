package upf.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    public void addUser(String name, String mail, String pwd, LocalDate birthday, String gender, String phoneNumber, boolean terms, boolean newsletter) {
        String query = "INSERT INTO users (usr,mail,pwd,birthday,gender,phoneNumber,terms,newsletter) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, mail);
            statement.setString(3, pwd);
            statement.setDate(4, java.sql.Date.valueOf(birthday));
            statement.setString(5,gender);
            statement.setString(6, phoneNumber);
            statement.setBoolean(7, terms);
            statement.setBoolean(8, newsletter);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Check if all the fields are filled correctly */
    public boolean isComplete(User user) throws SQLException {
        return (hasValue(user.getUser()) &&
                hasValue(user.getMail()) &&
                hasValue(user.getPwd1()) &&
                hasValue(user.getPwd2()) &&
                (user.getBirthday()!= null) &&
                user.isTerms() &&
                isNotRegistered(user) &&
                (user.getPhoneNumber() == null || isPhoneNumberUnique(user.getPhoneNumber())));
    }


    private boolean isNotRegistered(User user) throws SQLException {
        boolean user_registered = getUserFromDB(user.getUser());
        boolean mail_registered = getEmailFromDB(user.getMail());

        if (user_registered){
            user.isAnyError("user");
        }
        if (mail_registered){
            user.isAnyError("mail");
        }

        return !user_registered && !mail_registered;
    }


    private boolean hasValue(String val) {
        return ((val != null) && (!val.equals("")));
    }

    private boolean getUserFromDB(String username) {
        String query = "SELECT usr FROM users WHERE usr = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet r = statement.executeQuery();
            boolean registered = r.next();
            r.close();
            return  registered;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean getEmailFromDB(String email) {
        String query = "SELECT mail FROM users WHERE mail = ?";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet r = statement.executeQuery();
            boolean registered = r.next();
            r.close();
            return registered;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isPhoneNumberUnique(String phoneNumber) {
        String query = "SELECT * FROM users WHERE phoneNumber=?";
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
