package com.kevin.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kevin.pojo.TbBrand;
import com.kevin.sellergoods.service.BrandService;
import com.vo.PageBean;
import com.vo.State;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/28
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageBean findPage(
            @RequestParam(name = "currPage", defaultValue = "1") int currPage,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return brandService.findPage(currPage, pageSize);
    }

    @RequestMapping("/add")
    public State add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);

            return new State(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new State(false, "增加失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }


    @RequestMapping("/update")
    public State update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);

            return new State(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new State(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    public State delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new State(false, "删除失败");
        }
    }

    @RequestMapping("/search")
    public PageBean search(@RequestBody TbBrand tbBrand,
                           @RequestParam(name = "currPage", defaultValue = "1") int currPage,
                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return brandService.findPage(tbBrand,currPage, pageSize);
    }
}
