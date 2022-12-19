package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.Car;
import org.junit.jupiter.api.Test;

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

}