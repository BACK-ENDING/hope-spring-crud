package com.hope.leveldiary;

import com.hope.MSGcrud.account.Account;
import com.hope.MSGcrud.repository.JdbcAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JdbcAccountRepositoryTest {

    JdbcAccountRepository jdbcAccountRepository;

    String defaultEmail = "add@email.com";

    @BeforeEach
    public void setUp() {
        jdbcAccountRepository.deleteAll();
    }

    @Test
    public void count() {
        Assertions.assertEquals(0, jdbcAccountRepository.count());
        jdbcAccountRepository.save(new Account("add1@email.com"));
        jdbcAccountRepository.save(new Account("add2@email.com"));
        jdbcAccountRepository.save(new Account("add3@email.com"));
        Assertions.assertEquals(3, jdbcAccountRepository.count());
    }

    @Test
    public void saveAndFindAll() {
        jdbcAccountRepository.save(new Account("add1@email.com"));
        jdbcAccountRepository.save(new Account("add2@email.com"));
        jdbcAccountRepository.save(new Account("add3@email.com"));

        List<Account> getAll = jdbcAccountRepository.findAll();
        Assertions.assertEquals(3, getAll.size());
    }

    @Test
    public void saveAndFindById() {
        long resultId = jdbcAccountRepository.save(new Account(defaultEmail));
        Account getAccount = jdbcAccountRepository.findById(resultId);

        Assertions.assertNotNull(getAccount);
        Assertions.assertEquals(defaultEmail, getAccount.getEmail());
    }

    @Test
    public void saveAndFindByEmail() {
        jdbcAccountRepository.save(new Account(defaultEmail));
        Account getAccount = jdbcAccountRepository.findByEmail(defaultEmail);

        Assertions.assertNotNull(getAccount);
        Assertions.assertEquals(defaultEmail, getAccount.getEmail());
    }

    @Test
    public void update() {
        long resultId = jdbcAccountRepository.save(new Account(defaultEmail));
        Account getAccount = jdbcAccountRepository.findById(resultId);

        getAccount.setEmail("update@email.com");
        jdbcAccountRepository.update(getAccount);
        Account updatedAccount = jdbcAccountRepository.findById(resultId);
        Assertions.assertEquals("update@email.com", updatedAccount.getEmail());
    }

    @Test
    public void deleteById() {
        long resultId1 = jdbcAccountRepository.save(new Account("add1@email.com"));
        long resultId2 = jdbcAccountRepository.save(new Account("add2@email.com"));
        long resultId3 = jdbcAccountRepository.save(new Account("add3@email.com"));

        jdbcAccountRepository.deleteById(resultId2);
        Assertions.assertEquals(2, jdbcAccountRepository.count());

        Assertions.assertNotNull(jdbcAccountRepository.findById(resultId1));
        Assertions.assertNull(jdbcAccountRepository.findById(resultId2));
        Assertions.assertNotNull(jdbcAccountRepository.findById(resultId3));
    }
}

