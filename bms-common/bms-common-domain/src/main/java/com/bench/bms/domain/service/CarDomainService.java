package com.bench.bms.domain.service;

import com.bench.bms.domain.model.CarDo;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/20 19:33
 **/


public interface CarDomainService {

    CarDo saveCar(CarDo carDo);

//    CarDo selectCarByCarId(Long carId);

    void modifyCar(Long carId, CarDo carDo);

//    List<CarDo> listAllCar();

    void removeCar(Long carId);

    String generateVid(String input);

}
