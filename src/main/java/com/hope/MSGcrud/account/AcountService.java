package com.hope.MSGcrud.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcountService {

    @Autowired
    private JdbcAccountRepository jdbcAccountRepository;

    public int count(){
        return jdbcAccountRepository.count();
    }

    public long save(Account account){
        return jdbcAccountRepository.save(account);
    }


}
