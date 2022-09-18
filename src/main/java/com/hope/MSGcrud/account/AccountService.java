package com.hope.MSGcrud.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private final JdbcAccountRepository jdbcAccountRepository;

    public AccountService(JdbcAccountRepository jdbcAccountRepository) {
        this.jdbcAccountRepository = jdbcAccountRepository;
    }

    public int count(){
        return jdbcAccountRepository.count();
    }

    public long save(Account account){
        return jdbcAccountRepository.save(account);
    }

    public int update(Account account){
        return jdbcAccountRepository.update(account);
    }

    public int deleteById(Long id){
        return jdbcAccountRepository.deleteById(id);
    }

    public List<Account> findAll(){
        return jdbcAccountRepository.findAll();
    }

    public Account findById(Long id){
        return jdbcAccountRepository.findById(id);
    }
    public Account findByEmail(String email){
        return jdbcAccountRepository.findByEmail(email);
    }

    public void deleteAll(){
        jdbcAccountRepository.deleteAll();
    }

}
