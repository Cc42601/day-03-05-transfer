package com.web;

import com.pojo.Account;
import com.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private AccountService service;

    @Test
    public void testFindById() {
        Account account = service.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testTransfer() {
        String fromSub = "jack"; //传出人
        String toSub = "rose";//转入人
        float money = 100f;
        boolean fiag = service.transfer(fromSub, toSub, money);

        if (fiag){
            System.out.println("成功 ");
        }

    }
}
