package cn.hellojarvis.service;

import cn.hellojarvis.entity.Goods;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 21:58
 */
public interface IHaveGoodService {
    public List<Goods> loadUserGoods(int userId);
}
