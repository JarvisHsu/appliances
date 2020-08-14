package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IPayAccountDao;
import cn.hellojarvis.entity.PayAccount;
import cn.hellojarvis.service.IPayAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/13 23:54
 */
@Service("PayAccountServiceImpl")
public class PayAccountServiceImpl implements IPayAccountService {
    @Autowired
    private IPayAccountDao payAccountDao;
    @Override
    public PayAccount checkAccount(PayAccount payAccount) {
        return payAccountDao.loadAccount(payAccount);
    }

    @Override
    public boolean modifyBalance(PayAccount payAccount) {
        return payAccountDao.modifyBalance(payAccount)!=0;
    }
}
