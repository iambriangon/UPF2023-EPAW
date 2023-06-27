package upf.managers;

import org.apache.commons.lang3.tuple.Pair;
import upf.models.User;
import upf.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ManageUsers {
	
	private DB db = null ;
	
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
	
	/* Get a user given its PK*/
	public User getUser(Integer id) {
		String query = "SELECT id,name,mail FROM users WHERE id = ? ;";
		PreparedStatement statement = null;
		ResultSet rs = null;
		User user = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			rs = statement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setMail(rs.getString("mail"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
		
	// Add new user
	public void addUser(User user) {
		String query = "INSERT INTO users (name,mail,pwd,birthday,gender,phoneNumber,terms,newsletter) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,user.getName());
			statement.setString(2,user.getMail());
			statement.setString(3,user.getPwd());
			statement.setString(4,user.getBirthday());
			statement.setString(5,user.getGender());
			statement.setString(6,user.getPhoneNumber().isEmpty()? null: user.getPhoneNumber());
			statement.setBoolean(7,user.isTerms());
			statement.setBoolean(8,user.isNewsletter());
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Follow a user
	public void followUser(Integer uid, Integer fid) {
		String query = "INSERT INTO follows (uid,fid) VALUES (?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,fid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Unfollow a user
	public void unfollowUser(Integer uid, Integer fid) {
		String query = "DELETE FROM follows WHERE uid = ? AND fid = ?";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,fid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// Get all the users
	public List<User> getUsers(Integer start, Integer end) {
		 String query = "SELECT id,name FROM users ORDER BY name ASC LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,start);
			 statement.setInt(2,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setName(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<User> getNotFollowedUsers(Integer id, Integer start, Integer end) {
		 String query = "SELECT id,name FROM users WHERE id NOT IN (SELECT id FROM users,follows WHERE id = fid AND uid = ?) AND id <> ? ORDER BY name LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2, id);
			 statement.setInt(3,start);
			 statement.setInt(4,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setName(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<User> getFollowedUsers(Integer id, Integer start, Integer end) {
		 String query = "SELECT id,name FROM users,follows WHERE id = fid AND uid = ? ORDER BY name LIMIT ?,?;";
		 PreparedStatement statement = null;
		 List<User> l = new ArrayList<User>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setName(rs.getString("name"));
				 l.add(user);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}

	public boolean updatePassword(int id, String newPass) {
		String query = "UPDATE users SET pwd = ? WHERE id = ?;";
		PreparedStatement statement = null;
		boolean error = true;

		try {
			statement = db.prepareStatement(query);
			statement.setString(1, newPass);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0){
				error = false;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}

	public boolean updateUsername(int id, String newUsername) {
		String query = "UPDATE users SET name = ? WHERE id = ?;";
		PreparedStatement statement = null;
		boolean error = true;

		// Username taken
		if (checkUser(newUsername)) return error;

		try {
			statement = db.prepareStatement(query);
			statement.setString(1, newUsername);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0){
				error = false;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}

	public boolean updateEmail(int id, String newEmail) {
		String query = "UPDATE users SET mail = ? WHERE id = ?;";
		PreparedStatement statement = null;
		boolean error = true;

		// Email taken
		if (checkMail(newEmail)) return error;

		try {
			statement = db.prepareStatement(query);
			statement.setString(1, newEmail);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0){
				error = false;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}

	public boolean updatePhone(int id, String newPhone) {
		String query = "UPDATE users SET phoneNumber = ? WHERE id = ?;";
		PreparedStatement statement = null;
		boolean error = true;

		// Phone taken
		if (checkPhone(newPhone)) return error;

		try {
			statement = db.prepareStatement(query);
			statement.setString(1, newPhone);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0){
				error = false;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}

	public boolean deleteUserById(Integer id) {
		String query = "DELETE FROM users WHERE id = ? ";
		PreparedStatement statement = null;
		boolean status = false;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			if (statement.executeUpdate() > 0)
				status = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public Pair<Boolean,User> checkLogin(User user) {
		
		String query = "SELECT id,mail from users where name=? AND pwd=?";
		PreparedStatement statement = null;
		boolean output = false;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,user.getName());
			statement.setString(2,user.getPwd());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setMail(rs.getString("mail"));
				output = true;
			} 
			rs.close();
			statement.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Pair.of(output,user);
		
	}
	
	public boolean checkUser(String user) {
		
		String query = "SELECT name from users where name=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		try {
			
			statement = db.prepareStatement(query);
			statement.setString(1,user);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				output = true;
			}
			rs.close();
			statement.close();
			return output;
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
		
	}

	public boolean checkUserById(String user) {

		String query = "SELECT name from users where id=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		try {

			statement = db.prepareStatement(query);
			statement.setString(1,user);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				output = true;
			}
			rs.close();
			statement.close();
			return output;

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return output;

	}

	public boolean checkPhone(String phone){
		String query = "SELECT phoneNumber from users where phoneNumber=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		if (!phone.isEmpty()) {
			try {

				statement = db.prepareStatement(query);
				statement.setString(1, phone);
				rs = statement.executeQuery();
				if (rs.isBeforeFirst()) {
					output = true;
				}
				rs.close();
				statement.close();
				return output;

			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return output;
	}
	
	public boolean checkMail(String mail) {
		
		String query = "SELECT mail from users where mail=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean output = false;
		try {
			
			statement = db.prepareStatement(query);
			statement.setString(1,mail);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				output = true;
			}
			rs.close();
			statement.close();
			return output;
			
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
		
	}
		
	/*Check if all the fields are filled correctly */
	public boolean isComplete(User user) {
	    return (hasValue(user.getName()) &&
				hasValue(user.getMail()) &&
				hasValue(user.getPwd())  &&
				hasValue(user.getBirthday()) &&
				hasValue(user.getGender()));
	}
	
	public boolean isLoginComplete(User user) {
	    return(hasValue(user.getName()) &&
	    	   hasValue(user.getPwd()) );
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
		
	
	// TODO: add other methods 

}