package ru.study.seminar2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void resetVehicles(){
        car = new Car("Company", "model", 1500);
        motorcycle = new Motorcycle("Company", "model2", 1501);
    }

    @Test
    void CarInstance() {
        assertInstanceOf(Vehicle.class, car);
    }

    @Nested
    class wheelCount {
        @Test
        void CarWheelCount() {
            assertEquals(car.getNumWheels(), 4);
        }

        @Test
        void MotorcycleWheelCount() {
            assertEquals(motorcycle.getNumWheels(), 2);
        }
    }

    @Nested
    class Speed {
        @Nested
        class CarSpeed {
            @Test
            @Order(1)
            void driveSpeed() {
                car.testDrive();
                assertEquals(car.getSpeed(), 60);
            }

            @Test
            @Order(2)
            void parkSpeed() {
                car.park();
                assertEquals(car.getSpeed(), 0);
            }
        }

        @Nested
        class MotorcycleSpeed {
            @Test
            @Order(1)
            void driveSpeed() {
                motorcycle.testDrive();
                assertEquals(motorcycle.getSpeed(), 75);
            }

            @Test
            @Order(2)
            void parkSpeed() {
                motorcycle.park();
                assertEquals(car.getSpeed(), 0);
            }
        }
    }
}