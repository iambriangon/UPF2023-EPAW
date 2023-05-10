package upf.models;

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

    private Map<String, Boolean> error  = new HashMap<>()
    {{
        put("user", false);
        put("mail", false);
        put("pwd1", false);
        put("pwd2", false);
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

    public Map<String, Boolean> getError() {
        return error;
    }

    public void isAnyError(String field){
        error.replace(field, true);
    }
}
