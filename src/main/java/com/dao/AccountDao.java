package com.dao;

import com.pojo.Account;

public interface AccountDao {
    Account findAccountById(int id);

    Account findAccountByName(String name);

    int jianqian(Account fromAccount, float money);

    int jiaqian(Account toAccount, float money);
}
