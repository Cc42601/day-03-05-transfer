package com.dao.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(int id) {

        String sql = "select * from account where id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), id);

    }

    @Override
    public Account findAccountByName(String name) {
        String sql = "select * from account where name = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    @Override
    public int jianqian(Account fromAccount, float money) {
        String sql = "update account set money = money-? where id = ? ";

        int i = jdbcTemplate.update(sql, money, fromAccount.getId());
        return i;
    }

    @Override
    public int jiaqian(Account toAccount, float money) {
        String sql = "update account set money = money+? where id = ? ";
        int j = jdbcTemplate.update(sql, money, toAccount.getId());
        return j;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
