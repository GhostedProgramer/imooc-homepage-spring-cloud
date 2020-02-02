package com.imooc.homepage.vo;

import org.apache.commons.lang.StringUtils;

public class CreateUserRequest {

    private String username;
    private String email;

    public boolean valide() {
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }

    public CreateUserRequest() {
    }

    public CreateUserRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
