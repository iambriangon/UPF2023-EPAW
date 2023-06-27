package upf.managers;

import upf.utils.DB;
import upf.models.Tweet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ManageTweets {
	
	private DB db = null ;
	
	public ManageTweets() {
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
	
	/* Add a tweet */
	public void addTweet(Tweet tweet) {
		String query = "INSERT INTO tweets (uid,postdatetime,content,movie) VALUES (?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,tweet.getUid());
			statement.setTimestamp(2,tweet.getPostDateTime());
			statement.setString(3,tweet.getContent());
			statement.setString(4,tweet.getMovie());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Delete existing tweet */
	public void deleteTweet(Integer id,Integer uid) {
		String query = "DELETE FROM tweets WHERE id = ? AND uid=?";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			statement.setInt(2,uid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteTweetById(Integer id) {
		String query = "DELETE FROM tweets WHERE id = ? ";
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
	
	
	/* Get tweets from a user given start and end*/
	public List<Tweet> getUserTweets(Integer uid,Integer start, Integer end) {
		 String query = "SELECT tweets.id,tweets.uid,tweets.postdatetime,tweets.content,users.name,tweets.movie FROM tweets INNER JOIN users ON tweets.uid = users.id where tweets.uid = ? ORDER BY tweets.postdatetime DESC LIMIT ?,? ;";
		 PreparedStatement statement = null;
		 List<Tweet> l = new ArrayList<Tweet>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,uid);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Tweet tweet = new Tweet();
       		     tweet.setId(rs.getInt("id"));
				 tweet.setUid(rs.getInt("uid"));
				 tweet.setPostDateTime(rs.getTimestamp("postdatetime"));
				 tweet.setContent(rs.getString("content"));
				 tweet.setUname(rs.getString("name"));
				 tweet.setMovie(rs.getString("movie"));
				 l.add(tweet);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}

	/* Get tweets from a followed users  given start and end*/
	public List<Tweet> getUserFollowedTweets(Integer uid,Integer start, Integer end) {
		String query = "SELECT t.id,t.uid,t.postdatetime,t.content,u.name,t.movie FROM tweets t INNER JOIN (SELECT id, name FROM users, follows WHERE id = fid AND uid = ?) u ON t.uid = u.id ORDER BY t.postdatetime DESC LIMIT ?,? ;";
		PreparedStatement statement = null;
		List<Tweet> l = new ArrayList<Tweet>();
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,start);
			statement.setInt(3,end);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Tweet tweet = new Tweet();
				tweet.setId(rs.getInt("id"));
				tweet.setUid(rs.getInt("uid"));
				tweet.setPostDateTime(rs.getTimestamp("postdatetime"));
				tweet.setContent(rs.getString("content"));
				tweet.setUname(rs.getString("name"));
				tweet.setMovie(rs.getString("movie"));
				l.add(tweet);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  l;
	}

	/* Get tweets from all users given start and end*/
	public List<Tweet> getAllUserTweets(Integer limit) {
		String query = "SELECT tweets.id,tweets.uid,tweets.postdatetime,tweets.content,users.name,tweets.movie FROM tweets INNER JOIN users ON tweets.uid = users.id ORDER BY tweets.postdatetime DESC LIMIT ? ;";
		PreparedStatement statement = null;
		List<Tweet> l = new ArrayList<Tweet>();
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,limit);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Tweet tweet = new Tweet();
				tweet.setId(rs.getInt("id"));
				tweet.setUid(rs.getInt("uid"));
				tweet.setPostDateTime(rs.getTimestamp("postdatetime"));
				tweet.setContent(rs.getString("content"));
				tweet.setUname(rs.getString("name"));
				tweet.setMovie(rs.getString("movie"));
				l.add(tweet);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  l;
	}
	
	//SELECT movie FROM tweets GROUP BY movie ORDER BY COUNT(movie) DESC LIMIT 10;
	public List<String> getPopularMovies(int limit){
		String query = "SELECT movie FROM tweets GROUP BY movie ORDER BY COUNT(movie) DESC LIMIT ?;";
		PreparedStatement statement = null;
		List<String> movies = new ArrayList<String>() ;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,limit);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				movies.add(rs.getString("movie"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	//SELECT movie FROM tweets GROUP BY movie ORDER BY COUNT(movie) DESC LIMIT 10;
	public List<String> getMyMovies(int uid, int limit){
		String query = "SELECT movie FROM tweets WHERE uid = ? GROUP BY movie LIMIT ?;";
		PreparedStatement statement = null;
		List<String> movies = new ArrayList<String>() ;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,limit);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				movies.add(rs.getString("movie"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
}