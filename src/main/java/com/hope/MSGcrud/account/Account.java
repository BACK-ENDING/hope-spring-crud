package com.hope.MSGcrud.account;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String email;

    @Override
    public String toString(){
        return "Account [id=" + id + ", email=" + email + "]";
    }
}
