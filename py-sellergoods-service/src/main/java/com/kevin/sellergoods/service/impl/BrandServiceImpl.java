package com.kevin.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mapper.TbBrandMapper;
import com.kevin.pojo.TbBrand;
import com.kevin.pojo.TbBrandExample;
import com.kevin.sellergoods.service.BrandService;
import com.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/27
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {

        List<TbBrand> list = brandMapper.selectByExample(null);
        return list;
    }

    @Override
    public PageBean findPage(int currPage, int pageSize) {
        PageHelper.startPage(currPage, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageBean findPage(TbBrand tbBrand, int currPage, int pageSize) {
        PageHelper.startPage(currPage, pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null) {
            if (tbBrand.getName() != null && tbBrand.getName() != "") {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar() != "") {
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageBean(page.getTotal(), page.getResult());
    }

}
