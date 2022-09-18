package com.hope.MSGcrud.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    JdbcAccountRepository jdbcAccoutRepository;
    AccountService accountService = new AccountService(jdbcAccoutRepository);

    @Test
    void nullFindByIdTest(){
        Account account1 = new Account(7L , "kimhuemang");
        long saveAccountId = accountService.save(account1);
        accountService.save(null);

        Account findAccount = accountService.findById(7L);

    }
}