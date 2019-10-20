package dao;

import entity.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectAll(); //查找商品
    int deleteGoods(Goods goods); //删除商品
    Goods selectById(int g_id); //按id查找
    int update(Goods goods); //更新商品
    int add(Goods goods); //新增商品
    int deleteById(String[] ids); //批量删除(逻辑删除)
    //测试一下冲突嘛！
}
