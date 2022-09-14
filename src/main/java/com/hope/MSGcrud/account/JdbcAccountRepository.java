package com.hope.MSGcrud.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcAccountRepository implements AccountRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from accounts", Integer.class);
    }

    @Override
    public long save(Account account) {
        // 자동 생성되는 키 리턴받기
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into accounts (email) values (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,account.getEmail());
            return ps;
        }, keyHolder);

        return (long)keyHolder.getKey();

        // 자동 생성되는 키를 받을 수 없다. 성공 또는 실패. 0 또는 1만 반환
        // return jdbcTemplate.update("insert into accounts (email) values (?)",
        //	account.getEmail());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update accounts set email = ? where id = ?",
                account.getEmail(),
                account.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete account where id = ?", id);
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from accounts",
                (rs, rowNum) -> new Account( rs.getLong("id"), rs.getString("email")
                )
        );
    }

    @Override
    public Account findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select * from accounts where id = ?",
                    new Object[] {id},
                    (rs, rowNum) -> Optional.of(new Account(
                            rs.getLong("id"),
                            rs.getString("email")
                    ))
            ).orElse(null);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Account findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("select * from accounts where id = email",
                    new Object[] {email},
                    (rs, rowNum) -> Optional.of(new Account(
                            rs.getLong("id"),
                            rs.getString("email")
                    ))
            ).orElse(null);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from accounts");
    }

}
