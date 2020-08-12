package cn.hellojarvis.dao;

import cn.hellojarvis.entity.Goods;

public interface IGoodsDao {
    Goods loadGoodById(int goodsId);

}
