package edu.umb.cs680.hw00;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    Calculator calc;

    public CalculatorTest() {
        calc = new Calculator();
    }

    @Test
    public void multiply2by3() {
        Calculator calc = new Calculator();
        Assertions.assertEquals(6,calc.multiply(2,3));
    }

    @Test
    public void divide20by4() {
        Calculator calc = new Calculator();
        Assertions.assertEquals(05,calc.divide(20,4));
    }

    @Test
    public void divide20by0() {

        try{
            calc.divide(20,0);
        }
        catch(IllegalArgumentException e){

            Assertions.assertEquals(e.getMessage(),"division by zero");

//            Assertions.assertThrows(e.getClass(),()->calc.divide(20,0));
//            Assertions.assertThrows(IllegalArgumentException.class,()->calc.divide(20,0));
        }
    }
}

