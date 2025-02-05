package com.wycliffe.pointofsalesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPwdDto {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}