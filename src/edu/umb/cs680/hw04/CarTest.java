package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] carToStringArray(Car c){
        String[] strarr = {c.getMake(), c.getModel(), String.valueOf(c.getYear())};
       return(strarr);
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String[] expected = new String[]{"Toyota", "RAV4","2018"};
        Car actual = new Car("Toyota", "RAV4",50,2018,100000);
        assertArrayEquals(expected, carToStringArray(actual));


    }

    /*

    private String[] carToStringArray(Car c){
        String[] strarr = {c.getMake(), c.getModel(),String.valueOf(c.getMileage()), String.valueOf(c.getYear()), String.valueOf(c.getPrice())};
       return(strarr);
    }

    @Test
    public void verifyCarEqualityWithMakeMileagePrice(){
        String[] expected = new String[]{"BMW", "60","900000"};
        Car actual = new Car("BMW", "M3",60,2023,900000);
        assertArrayEquals(expected, carToStringArray(actual),"Model Matched");
    }*/
}