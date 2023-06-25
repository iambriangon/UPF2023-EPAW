package upf.models;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int id = 0;
	private String name = "";
	private String mail = "";
	private String pwd = "";
    private String birthday = "";
    private String gender = "";
    private String phoneNumber = "";
    private boolean terms;
    private boolean newsletter;

	private HashMap<String, Boolean> error = null;
	
	public User() {
		error = new HashMap<String, Boolean>();
		error.put("name", false);
		error.put("mail", false);
        error.put("pwd", false);
		error.put("birthday",false);
        error.put("gender",false);
        error.put("phoneNumber",false);
        error.put("terms", false);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			this.mail = mail;
		} else {
			error.put("mail", true);
		}
		
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	public void setPwd(String pwd) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pwd);
		if (matcher.matches()) {
			this.pwd = pwd;
		} else {
			error.put("pwd", true);
		}
	}

    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        System.out.println(birthday);
        try {
            String regex = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(birthday);
            if (matcher.matches()){
                this.birthday = birthday;
            }
        } catch (DateTimeParseException e) {
            setError("birthday", true);
        }
    }

    public String getGender() {
    	return this.gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            this.gender = gender;
        } else {
            setError("gender", true);
        }
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty() || phoneNumber.matches("^[67]\\d{8}$")) { // only spanish numbers
            this.phoneNumber = phoneNumber;
        } else {
            setError("phoneNumber", true);
        }
    }


    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        if (terms){
            this.terms = true;
        } else {
            setError("terms", true);
        }   
    }


    public boolean isNewsletter() {
        return newsletter;
    }
    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }
	
	public HashMap<String,Boolean> getError() {
		return this.error;
	}
	
	public void setError(String name, boolean error) {
		this.error.put(name, error);
	}

    /* Logic Functions */
    public boolean isComplete() {
        return(hasValue(getName()) &&
                hasValue(getMail()) &&
                hasValue(getBirthday()) &&
                hasValue(getGender()) &&
                hasValue(getPwd()) &&
                isTerms());
    }

    private boolean hasValue(String val) {
        return((val != null) && (!val.equals("")));
    }

    /*toString()*/
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' + '\n'+
                ", mail='" + mail + '\'' + '\n'+
                ", pwd='" + pwd + '\'' + '\n'+
                ", birthday='" + birthday + '\'' + '\n'+
                ", gender='" + gender + '\'' + '\n'+
                ", phoneNumber='" + phoneNumber + '\'' + '\n'+
                ", terms=" + terms + '\n'+
                ", newsletter=" + newsletter + '\n'+
                ", error=" + error +
                '}';
    }
}
