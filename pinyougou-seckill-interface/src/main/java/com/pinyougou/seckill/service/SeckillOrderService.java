package com.pinyougou.seckill.service;

import com.pinyougou.pojo.TbSeckillOrder;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 */
public interface SeckillOrderService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbSeckillOrder> findAll();

    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     */
    void add(TbSeckillOrder seckillOrder);

    /**
     * 修改
     */
    void update(TbSeckillOrder seckillOrder);

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    TbSeckillOrder findOne(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(TbSeckillOrder seckillOrder, int pageNum, int pageSize);

    /**
     * 秒杀下单
     *
     * @param seckillId
     * @param userId
     */
    void submitOrder(Long seckillId, String userId);

    /**
     * 从缓存中提取订单
     *
     * @param userId
     * @return
     */
    TbSeckillOrder searchOrderFromRedisByUserId(String userId);

    /**
     * 保存订单到数据库
     *
     * @param userId
     * @param orderId
     * @param transactionId
     */
    void saveOrderFromRedisToDb(String userId, Long orderId, String transactionId);

    /**
     * 从缓存中删除订单
     *
     * @param userId
     * @param orderId
     */
    void deleteOrderFromRedis(String userId, Long orderId);
}
