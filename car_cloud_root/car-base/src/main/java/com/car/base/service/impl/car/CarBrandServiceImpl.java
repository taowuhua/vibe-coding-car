package com.car.base.service.impl.car;

import com.car.base.entity.car.CarBrand;
import com.car.base.mapper.car.CarBrandMapper;
import com.car.base.service.car.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌字典服务实现类
 *
 * @author system
 * @date 2026-01-16
 */
@Service
public class CarBrandServiceImpl implements CarBrandService {

    /**
     * 品牌字典 Mapper
     */
    @Autowired
    private CarBrandMapper carBrandMapper;

    /**
     * 获取所有启用的品牌列表
     */
    @Override
    public List<CarBrand> getAllBrands() {
        return carBrandMapper.findAllActive();
    }

    /**
     * 根据首字母查询品牌
     */
    @Override
    public List<CarBrand> getByInitial(String initial) {
        return carBrandMapper.findByInitial(initial);
    }

    /**
     * 根据关键词搜索品牌
     */
    @Override
    public List<CarBrand> search(String keyword) {
        return carBrandMapper.searchByName(keyword);
    }
}
