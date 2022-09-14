package com.hope.MSGcrud.account;

public class Account {
    private long id;
    private String email;

    public Account(long id, String email) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Account [id=" + id + ", email=" + email + "]";
    }
}
