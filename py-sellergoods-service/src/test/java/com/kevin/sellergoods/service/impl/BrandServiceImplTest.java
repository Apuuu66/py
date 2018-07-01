package com.kevin.sellergoods.service.impl;

import com.kevin.mapper.TbBrandMapper;
import com.kevin.pojo.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class BrandServiceImplTest {
    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Test
    public void findAll() {
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        System.out.println(tbBrands);
    }
}