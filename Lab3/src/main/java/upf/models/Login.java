package upf.models;

import java.util.HashMap;
import java.util.Map;

public class Login {

	private String user = "";
	private String password = "";

	private Map<String, Boolean> error  = new HashMap<>()
	{{
		put("user", false);
		put("password", false);
	}};
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Boolean> getError() {
		return error;
	}
	
	public boolean isComplete() {
	    return(hasValue(getUser()));
	}

	public void isAnyError(String field){
		error.replace(field, true);
	}

	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}

	
}