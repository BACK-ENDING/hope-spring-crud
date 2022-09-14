package com.hope.MSGcrud.account;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
