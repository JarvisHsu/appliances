package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IHaveGoodsDao;
import cn.hellojarvis.entity.Goods;
import cn.hellojarvis.entity.UserInfo;
import cn.hellojarvis.service.IHaveGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:58
 */
@Service("HaveGoodsImpl")
public class HaveGoodsServiceImpl implements IHaveGoodService {
    @Autowired
    private IHaveGoodsDao haveGoodsDao;

    @Override
    public List<Goods> loadUserGoods(int userId) {
        return haveGoodsDao.loadUserGoods(userId);
    }

    @Override
    public List<UserInfo> loadGoodUsers(int goodsId) {
        return haveGoodsDao.loadGoodUsers(goodsId);
    }
}
