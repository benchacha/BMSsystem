package com.bench.bms.infra.repository;

import com.bench.bms.domain.model.CarDo;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/20 19:36
 **/
public interface CarRepository {

    CarDo fingByVid(String vid);

    void save(CarDo carDo);

    void remove(String vid);

    void update(CarDo carDo);

    List<CarDo> list();

}
