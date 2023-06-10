package com.service;

import com.pojo.Account;

public interface AccountService {
    Account findAccountById(int id);

    boolean transfer(String fromSub, String toSub, float money);

}
