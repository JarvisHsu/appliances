package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IGoodsDao;
import cn.hellojarvis.entity.Goods;
import cn.hellojarvis.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:44
 */
@Service("GoodsServiceImpl")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public Goods loadGoodById(int goodsId){
        return goodsDao.loadGoodById(goodsId);
    }
}
