package upf.managers;

import upf.models.Login;
import upf.models.User;
import upf.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void addUser(String name, String mail, String pwd, String birthday, String gender, String phoneNumber, boolean terms, boolean newsletter) {
        String query = "INSERT INTO users (usr,mail,pwd,birthday,gender,phoneNumber,terms,newsletter) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            phoneNumber = phoneNumber.isEmpty()? null : phoneNumber;
            statement = db.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, mail);
            statement.setString(3, pwd);
            statement.setString(4, birthday);
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
        return (hasValue(user.getUsername()) &&
                hasValue(user.getMail()) &&
                hasValue(user.getPwd1()) &&
                hasValue(user.getPwd2()) &&
                (user.getBirthday()!= null) &&
                user.isTerms() &&
                isNotRegistered(user));
    }

    public boolean isComplete(Login user) {
        return (hasValue(user.getUser()) &&
                hasValue(user.getPassword()) &&
                isRegisteredUser(user) &&
                isValidPassword(user)
                );

    }
    private boolean isNotRegistered(User user) throws SQLException {
        boolean user_registered = getUserFromDB(user.getUsername());
        boolean mail_registered = getEmailFromDB(user.getMail());
        boolean phone_registered = isPhoneNumberUnique(user.getPhoneNumber());

        if (user_registered){
            user.isAnyError("username");
        }
        if (mail_registered){
            user.isAnyError("mail");
        }
        if (phone_registered){
            user.isAnyError("phoneNumber");
        }

        return !user_registered && !mail_registered && !phone_registered;
    }

    private boolean hasValue(String val) {
        return ((val != null) && (!val.equals("")));
    }

    private boolean getUserFromDB(String username) {
        String query = "SELECT usr FROM users WHERE usr = ?";
        return selectColumn(username, query);
    }

    private boolean getEmailFromDB(String email) {
        String query = "SELECT mail FROM users WHERE mail = ?";
        return selectColumn(email, query);
    }

    private boolean isPhoneNumberUnique(String phoneNumber) {
        String query = "SELECT * FROM users WHERE phoneNumber = ?";
        if (phoneNumber.isEmpty()) // if user did not introduce their phone number do not check in DB
            return false;

        return selectColumn(phoneNumber, query);
    }

    private boolean isRegisteredUser(Login u) {
        boolean user_registered = getUserFromDB(u.getUser());
        if (!user_registered)
            u.isAnyError("user");

        return user_registered;
    }

    private boolean isValidPassword(Login u) {
        String query = "SELECT pwd FROM users WHERE usr = ?";

        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, u.getUser());
            ResultSet r = statement.executeQuery();
            if (r.next() && r.getString("pwd").equals(u.getPassword()))
                return true;
            else
                u.isAnyError("password");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean selectColumn(String field, String query) {
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, field);
            ResultSet r = statement.executeQuery();
            boolean registered = r.next();
            r.close();
            return registered;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
