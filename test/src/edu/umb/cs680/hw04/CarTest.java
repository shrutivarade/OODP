package src.edu.umb.cs680.hw04;

import edu.umb.cs680.hw04.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
}