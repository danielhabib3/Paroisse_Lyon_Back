package com.example.Paroisse_Lyon_Back.model;

public class User {
    private String username;
    private String password;
    private String role;
    private String telephone;

    public User() {
    }

    public User(String username, String password, String role, String telephone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}
