package com.hope.MSGcrud.repository;

import com.hope.MSGcrud.account.Account;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface AccountRepository  {

    int count();

    long save(Account account);

    int update(Account account);

    int deleteById(Long id);

    void deleteAll();

    List<Account> findAll();

    Account findById(Long id);

    Account findByEmail(String email);
}
