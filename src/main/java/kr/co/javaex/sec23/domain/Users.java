package kr.co.javaex.sec23.domain;

public class Users {
    public String uId;
    public String uName;
    public String password;
    public String pNumber;
    public String email;
    public int role;
    public boolean uStatus;

    public Users() {}

    public String getuId() { return uId; }
    public void setuId(String uId) { this.uId = uId; }

    public String getuName() { return uName; }
    public void setuName(String uName) { this.uName = uName; }

    public String getpassword() { return password; }
    public void setpassword(String password) { this.password = password; }

    public String getpNumber() { return pNumber; }
    public void setpNumber(String pNumber) { this.pNumber = pNumber; }

    public String getemail() { return email; }
    public void setemail(String email) { this.email = email; }

    public int getrole() { return role; }
    public void setrole(int role) { this.role = role; }

}
