package com.service.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public boolean transfer(String fromSub, String toSub, float money) {
        //转账前查询
        Account fromAccount = accountDao.findAccountByName(fromSub);
        Account toAccount = accountDao.findAccountByName(toSub);
        System.out.println("转出人：" + fromAccount);
        System.out.println("转入人：" + toAccount);

        //转账
        //从转出人账户上减钱
        int i = accountDao.jianqian(fromAccount, money);
        System.out.println(1/0);
        //从转入人账户上加钱
        int j = accountDao.jiaqian(toAccount, money);

        return i>0&&j>0;

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
