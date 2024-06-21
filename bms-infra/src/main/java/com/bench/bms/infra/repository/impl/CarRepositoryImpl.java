package com.bench.bms.infra.repository.impl;

import com.bench.bms.domain.model.CarDo;
import com.bench.bms.infra.repository.CarRepository;
import com.bench.bms.infra.repository.converter.CarPoConverter;
import com.bench.bms.infra.repository.entity.CarPo;
import com.bench.bms.infra.repository.mapper.CarPoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bench
 * @Date 2024/06/20 19:40
 **/

@Service
public class CarRepositoryImpl implements CarRepository {

    @Resource
    private CarPoMapper carPoMapper;

    @Resource
    private CarPoConverter carPoConverter;

    @Override
    public CarDo fingByCarId(Long carId) {
        CarPo carPo = carPoMapper.searchByCarId(carId);
        return carPoConverter.toDo(carPo);
    }

    @Override
    public void save(CarDo carDo) {
        CarPo carPo = carPoConverter.toPo(carDo);
        System.out.println(carPo);
        carPoMapper.insert(carPo);
    }

    @Override
    public void remove(Long carId) {
        carPoMapper.deleteById(carId);
    }

    @Override
    public void update(Long carId, CarDo carDo) {
        CarPo carPo = carPoConverter.toPo(carDo);
        carPoMapper.updateById(carPo);
    }

    @Override
    public List<CarDo> list() {
        List<CarPo> carPoList = carPoMapper.ListAllCar();
        List<CarDo> carDoList = carPoList.stream()
                .map(carPoConverter::toDo)
                .collect(Collectors.toList());
        return carDoList;
    }
}
