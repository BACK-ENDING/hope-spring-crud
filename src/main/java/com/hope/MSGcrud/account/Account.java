package com.hope.MSGcrud.account;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String email;

    public Account(String email) {
        this.email = email;
    }

    public Account(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Account [id=" + id + ", email=" + email + "]";
    }
}
