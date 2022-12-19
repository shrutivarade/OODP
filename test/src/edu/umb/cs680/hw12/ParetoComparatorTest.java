package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.Car;
import edu.umb.cs680.hw12.ParetoComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {

    ArrayList<Car> CarsList = new ArrayList<Car>();

    @Test
    public void testParetoComp(){
        CarsList.add(new Car("Hyundai", "A7", 70,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 40,2018, 10000));

        for(Car car: CarsList){
            car.setDominationCount(CarsList);
        }

        Collections.sort(CarsList,new ParetoComparator());

        assertEquals("Hyundai", CarsList.get(0).getMake());
        assertEquals("Mercedes", CarsList.get(1).getMake());
        assertEquals("Ferrari",CarsList.get(2).getMake());
        assertEquals("Honda", CarsList.get(3).getMake());
    }

}