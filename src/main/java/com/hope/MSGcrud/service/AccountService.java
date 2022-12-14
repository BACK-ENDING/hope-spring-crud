package com.hope.MSGcrud.service;

import com.hope.MSGcrud.account.Account;
import com.hope.MSGcrud.repository.JdbcAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final JdbcAccountRepository jdbcAccountRepository;

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
