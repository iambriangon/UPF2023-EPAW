package upf.models;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String user = "";
    private String mail = "";
    private String pwd1 = "";
    private String pwd2 = "";
    private LocalDate birthday;
    private String gender = "";
    private String phoneNumber = "";
    private boolean terms;
    private boolean newsletter;
    
    private Map<String, Boolean> error  = new HashMap<>()
    {{
        put("user", false);
        put("mail", false);
        put("pwd1", false);
        put("pwd2", false);
        put("birthday",false);
       // put("gender",false);
        put("phoneNumber",false);
    }};

    public User() {

    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
        System.out.println(user);
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
            System.out.println(mail);
        } else {
            isAnyError("mail");
            System.out.println(mail);
        }
    }

    public String getPwd1() {
        return this.pwd1;
    }

    public void setPwd1(String pwd1) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd1);
        if (matcher.matches()){
            this.pwd1 = pwd1;
            System.out.println(pwd1);
        } else {
            isAnyError("pwd1");
            System.out.println(pwd1);
        }
    }

    public String getPwd2() {
        return this.pwd2;
    }

    public void setPwd2(String pwd2) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd2);
        if (matcher.matches() && this.pwd1.equals(pwd2)){
            this.pwd2 = pwd2;
            System.out.println(pwd2);
        } else {
            isAnyError("pwd2");
            System.out.println(pwd2);
        }
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        try {
            this.birthday = LocalDate.parse(birthday);
        } catch (DateTimeParseException e) {
            isAnyError("birthday");
        }
    }
    public String getGender() {
    	
    	return this.gender;
    }
    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            this.gender = gender;
        } else {
            isAnyError("gender");
        }
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty() || phoneNumber.matches("\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}")) {
            this.phoneNumber = phoneNumber;
        } else {
            isAnyError("phoneNumber");
        }
    }


    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }


    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }


    public Map<String, Boolean> getError() {
        return error;
    }

    public void isAnyError(String field){
        error.replace(field, true);
    }
}
