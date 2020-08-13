package cn.hellojarvis.dao;

import cn.hellojarvis.entity.PayAccount;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/13 23:52
 */
public interface IPayAccountDao {
    public PayAccount loadAccount(PayAccount payAccount);
}
