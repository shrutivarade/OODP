package edu.umb.cs680.hw14;

import edu.umb.cs680.hw12.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    private String[] carToStringArray(Car c){
        String[] strarr = {c.getMake(), c.getModel(), String.valueOf(c.getMileage()), String.valueOf(c.getYear()), String.valueOf(c.getPrice())};
        return(strarr);
    }

    @Test
    public void testCarEqualityWithMakeModelYear(){
        String[] expected = new String[]{"Toyota", "RAV4","80","2018","90000.0"};
        Car actual = new Car("Toyota", "RAV4",80,2018, 90000);
        assertArrayEquals(expected, carToStringArray(actual));

    }

    @Test
    public void testTwoDifferentCarInstances(){
        Car expected = new Car("Toyota", "RAV4",80,2018, 90000);
        Car actual = new Car("Toyota", "RAV4",80,2018, 90000);
        assertNotSame(expected, (actual));
        //Two different car instances having same values are considered as different objects. Hence, test case passed.
    }

    @Test
    public void testMakeUsingAssertNotEquals() {
        Car car = new Car("Toyota", "RAV3", 43, 2020, 8777000);
        String actual = car.getMake();
        String expected = "TATA";
        assertNotEquals(actual, expected);
    }



    ArrayList<Car> CarsList = new ArrayList<Car>();

    @Test
    public void testPriceComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,(Car o1, Car o2) -> (int) (o1.getPrice() - o2.getPrice()));

        assertEquals(100000, CarsList.get(0).getPrice());
        assertEquals(400000, CarsList.get(1).getPrice());
        assertEquals(460000,CarsList.get(2).getPrice());
        assertEquals(700000, CarsList.get(3).getPrice());
    }

    @Test
    public void testRevPriceComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,(Car o1, Car o2) -> (int) (o1.getPrice() - o2.getPrice()));
        Collections.sort(CarsList, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));

        assertEquals(100000, CarsList.get(3).getPrice());
        assertEquals(400000, CarsList.get(2).getPrice());
        assertEquals(460000,CarsList.get(1).getPrice());
        assertEquals(700000, CarsList.get(0).getPrice());
    }


    @Test
    public void testYearComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,(Car o1, Car o2) -> o1.getYear() - o2.getYear());

        assertEquals(2012, CarsList.get(0).getYear());
        assertEquals(2014, CarsList.get(1).getYear());
        assertEquals(2016,CarsList.get(2).getYear());
        assertEquals(2018, CarsList.get(3).getYear());

    }

    @Test
    public void testMileageComp(){
        CarsList.add(new Car("Hyundai", "A7", 40,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 70,2018, 100000));

        Collections.sort(CarsList,(Car o1, Car o2) -> o1.getMileage()- o2.getMileage());

        int[] expMilegae = new int[]{40, 50, 60, 70};
        int[] actMileage = new int[]{CarsList.get(0).getMileage(),CarsList.get(1).getMileage(),CarsList.get(2).getMileage(),CarsList.get(3).getMileage() };
        assertArrayEquals(expMilegae, actMileage);


    }

    @Test
    public void testParetoComp(){
        CarsList.add(new Car("Hyundai", "A7", 70,2012, 400000));
        CarsList.add(new Car("Mercedes","B65", 50,2014, 460000));
        CarsList.add(new Car("Ferrari","R44", 60,2016, 700000));
        CarsList.add(new Car("Honda","GT5", 40,2018, 10000));

        for(Car car: CarsList){
            car.setDominationCount(CarsList);
        }

        Collections.sort(CarsList,(Car o1, Car o2) -> o1.getDominationCount()- o2.getDominationCount());

        assertEquals("Hyundai", CarsList.get(0).getMake());
        assertEquals("Mercedes", CarsList.get(1).getMake());
        assertEquals("Ferrari",CarsList.get(2).getMake());
        assertEquals("Honda", CarsList.get(3).getMake());
    }




}