package com.aye.model;

import java.io.Serializable;

/**
 * @Author Aye
 * @Description:
 * @Date: Created in 17:52 2019/4/23
 * @Version: V1.0
 */
public class MQUser implements Serializable{
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "MQUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
