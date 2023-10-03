package ru.study.seminar3.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    MainHW testingObj;

    @BeforeEach
    void initTestingObj(){
        testingObj = new MainHW();
    }

    /**
     * Этого достаточно т.к. один тест покрывает сразу все строки и ветки метода
     */
    @Test
    void evenOddNumber() {
        assertFalse(testingObj.evenOddNumber(3));
        assertTrue(testingObj.evenOddNumber(2));
    }

    @Test
    void numberInInterval() {
        assertFalse(testingObj.numberInInterval(3));
        assertTrue(testingObj.numberInInterval(30));
        assertFalse(testingObj.numberInInterval(110));
    }
}