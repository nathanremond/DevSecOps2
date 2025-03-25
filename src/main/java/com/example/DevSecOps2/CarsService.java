package com.example.DevSecOps2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarsService {

    ArrayList<Car>cars = new ArrayList<Car>();

    public CarsService() {
        Car car = new Car("AA11BB", "ferrari", 2000);
        cars.add(car);
        car = new Car("BB22CC", "porsche", 1000);
        cars.add(car);
        car = new Car("CC33DD", "peugeot", 500);
        cars.add(car);
        car = new Car("EE44FF", "renault", 200);
        cars.add(car);
    }


    @GetMapping("/cars/{plateNumber}")
    public Car disBonjour(@PathVariable("plateNumber") String plaque){
        int i=0;
        while(i<cars.size() && cars.get(i).getPlateNumber().equals(plaque)==false){
            i++;
        }
        if(i < cars.size()){
            return cars.get(i);
        } else {
            return null;
        }
    }
}