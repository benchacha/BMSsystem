package com.bench.bms.application.service.impl;

import com.bench.bms.application.converter.CarDtoConverter;
import com.bench.bms.application.model.CarDto;
import com.bench.bms.application.service.CarService;
import com.bench.bms.domain.model.CarDo;
import com.bench.bms.domain.service.CarDomainService;
import com.bench.bms.infra.repository.CarRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bench
 * @Date 2024/06/20 19:56
 **/

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarDomainService carDomainService;

    @Resource
    private CarDtoConverter carDtoConverter;

    @Resource
    private CarRepository carRepository;

    @Override
    public CarDto addCar(CarDto carDto) {
        CarDo carDo = carDtoConverter.toDo(carDto);
        carDo = carDomainService.saveCar(carDo);
        return carDtoConverter.toDto(carDo);
    }

    @Override
    public void remove(Long carId) {
        carDomainService.removeCar(carId);
    }

    @Override
    public void modifyCar(Long carId, CarDto carDto) {
        CarDo carDo = carDtoConverter.toDo(carDto);
        carDomainService.modifyCar(carId, carDo);
    }

    @Override
    public CarDto searchCar(Long carId) {
        CarDo carDo = carRepository.fingByCarId(carId);
        return carDtoConverter.toDto(carDo);
    }

    @Override
    public List<CarDto> listAllCar() {
        List<CarDo> carDoList = carRepository.list();
        List<CarDto> carDtoList = carDoList.stream()
                .map(carDtoConverter::toDto)
                .collect(Collectors.toList());
        return carDtoList;
    }
}
