package cn.hellojarvis.service;

import cn.hellojarvis.entity.Goods;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:43
 */
public interface IGoodsService {
    public Goods loadGoodById(int goodsId);
}
