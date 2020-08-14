package cn.hellojarvis.service;

import cn.hellojarvis.entity.PayAccount;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/13 23:53
 */
public interface IPayAccountService {
    public PayAccount checkAccount(PayAccount payAccount);
    public boolean modifyBalance(PayAccount payAccount);
}
