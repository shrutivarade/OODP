package edu.umb.cs680.hw04;

import edu.umb.cs680.hw04.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class CarTest {

    private String[] carToStringArray(Car c){
        String[] strarr = {c.getMake(), c.getModel(), String.valueOf(c.getYear())};
       return(strarr);
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String[] expected = new String[]{"Toyota", "RAV4","2018"};
        Car actual = new Car("Toyota", "RAV4",2018);
        assertArrayEquals(expected, carToStringArray(actual));

    }

    @Test
    public void verifyTwoDifferentCarInstances(){
        Car expected = new Car("Toyota", "RAV4",2018);
        Car actual = new Car("Toyota", "RAV4",2018);
        assertNotSame(expected, (actual));
        //Two different car instances having same values are considered as different objects. Hence, test case passed.
    }
}