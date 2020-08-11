package cn.hellojarvis.dao;

import cn.hellojarvis.entity.Goods;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:56
 */
public interface IHaveGoodsDao {
    public List<Goods> loadUserGoods(int userId);
}
