package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * 品牌接口
 */
public interface BrandService {

    /**
     * 查找所有品牌
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 品牌分页
     * @param pageNum 当前页
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加品牌
     * @param brand
     */
    void add(TbBrand brand);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    TbBrand findOne(Long id);

    /**
     * 修改
     * @param brand
     */
    void update(TbBrand brand);

    /**
     * 删除
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 品牌分页查询
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand brand, int pageNum, int pageSize);
}
