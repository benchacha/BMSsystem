package com.bench.bms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bench.bms.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/18 09:11
 **/

@Mapper
public interface CarMapper extends BaseMapper<Car> {

    List<Car> selectAllCars();

}
