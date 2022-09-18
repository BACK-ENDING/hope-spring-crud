package com.hope.MSGcrud.account;


public class Account {
    private Long id;
    private String email;

    public Account(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Account(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
