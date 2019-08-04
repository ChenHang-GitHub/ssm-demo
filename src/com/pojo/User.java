package com.pojo;

public class User {


    private int id;

    private String username;

    private String userpassword;
    private String usermessage;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public String getUsermessage() {
        return usermessage;
    }
    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", usermessage='" + usermessage + '\'' +
                '}';
    }
}
