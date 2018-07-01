package com.kevin.sellergoods.service;

import com.kevin.pojo.TbBrand;
import com.vo.PageBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/27
 * 品牌接口
 */
public interface BrandService {
    public List<TbBrand> findAll();

    //品牌分页
    public PageBean findPage(int currPage, int pageSize);

    public void add(TbBrand tbBrand);

    public TbBrand findOne(Long id);

    public void update(TbBrand tbBrand);

    public void delete(Long[] ids);

    public PageBean findPage(TbBrand tbBrand, int currPage, int pageSize);


}
