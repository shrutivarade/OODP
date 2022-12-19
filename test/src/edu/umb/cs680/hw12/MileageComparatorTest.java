package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.Car;
import edu.umb.cs680.hw12.MileageComparator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MileageComparatorTest {

    List<Car> CarsList = new ArrayList<Car>();

    @Test
    public void testMileageComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,new MileageComparator());

        int[] expMilegae = new int[]{40, 50, 60, 70};
        int[] actMileage = new int[]{CarsList.get(0).getMileage(),CarsList.get(1).getMileage(),CarsList.get(2).getMileage(),CarsList.get(3).getMileage() };
        assertArrayEquals(expMilegae, actMileage);


    }

}