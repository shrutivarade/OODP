package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.Car;
import edu.umb.cs680.hw12.YearComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest {

    List<Car> CarsList = new ArrayList<Car>();
    
    @Test
    public void testYearComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,new YearComparator());

        assertEquals(2012, CarsList.get(0).getYear());
        assertEquals(2014, CarsList.get(1).getYear());
        assertEquals(2016,CarsList.get(2).getYear());
        assertEquals(2018, CarsList.get(3).getYear());

    }
    
}