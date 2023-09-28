package ru.study.seminar2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void CarInstance() {
        Car car = new Car("Company", "model", 1500);
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    void CarWheelCount() {
        Car car = new Car("Company", "model", 1500);
        assertEquals(car.getNumWheels(), 4);
    }

    @Test
    void MotorcycleWheelCount() {
        Motorcycle motorcycle = new Motorcycle("Company", "model2", 1501);
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    @Test
    void CarSpeed() {
        Car car = new Car("Company", "model", 1500);
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    void MotorcycleSpeed() {
        Motorcycle motorcycle = new Motorcycle("Company", "model2", 1501);
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }

    @Test
    void CarParkedSpeed() {
        Car car = new Car("Company", "model", 1500);
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    void MotorcycleParkedSpeed() {
        Motorcycle motorcycle = new Motorcycle("Company", "model2", 1501);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}