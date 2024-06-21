package com.bench.bms.infra.repository;

import com.bench.bms.domain.model.CarDo;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/20 19:36
 **/
public interface CarRepository {

    CarDo fingByCarId(Long carId);

    void save(CarDo carDo);

    void remove(Long carId);

    void update(Long carId, CarDo carDo);

    List<CarDo> list();

}
