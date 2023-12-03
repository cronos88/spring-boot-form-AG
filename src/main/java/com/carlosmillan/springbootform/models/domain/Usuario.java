package com.carlosmillan.springbootform.models.domain;

import jakarta.validation.constraints.NotEmpty;

public class Usuario {
    @NotEmpty
    String username;

    @NotEmpty
    String password;

    @NotEmpty
    String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
