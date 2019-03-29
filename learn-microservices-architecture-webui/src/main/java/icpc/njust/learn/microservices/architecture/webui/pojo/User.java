package icpc.njust.learn.microservices.architecture.webui.pojo;


import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String phonenumber;
    private String registertime;
    private String lastlogintime;

    public User() {
    }

    public User(String username, String password, String phonenumber, String registertime, String lastlogintime) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.registertime = registertime;
        this.lastlogintime = lastlogintime;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }


    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phonenumber, user.phonenumber) &&
                Objects.equals(registertime, user.registertime) &&
                Objects.equals(lastlogintime, user.lastlogintime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, phonenumber, registertime, lastlogintime);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", registertime='" + registertime + '\'' +
                ", lastlogintime='" + lastlogintime + '\'' +
                '}';
    }
}
