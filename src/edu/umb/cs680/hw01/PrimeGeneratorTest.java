package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;


public class PrimeGeneratorTest {

    PrimeGenerator pg;
    LinkedList<Long> actual = new LinkedList<Long>();
    LinkedList<Long> expected = new LinkedList<Long>();;

    @Test
    public void testConstructorForNegativeValue() {
        try{
            pg = new PrimeGenerator(-1,7);
        }
        catch(RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=-1 to=7");
        }
    }

    @Test
    public void listOfPrimeNumbers1to10() {
        pg = new PrimeGenerator(1,10);
        pg.generatePrimes();

        actual = pg.getPrimes();

        expected.add(2L);
        expected.add(3L);
        expected.add(5L);
        expected.add(7L);

        assertEquals(expected,actual);

    }

    @Test
    public void listOfPrimeNumbers3to15() {
        pg = new PrimeGenerator(3,15);
        pg.generatePrimes();

        assertEquals(3,pg.getPrimes().get(0));
        assertEquals(5,pg.getPrimes().get(1));
        assertEquals(7,pg.getPrimes().get(2));
        assertEquals(11,pg.getPrimes().get(3));
        assertEquals(13,pg.getPrimes().get(4));

    }

    @Test
    public void noOfPrimeFrom1to10() {

        pg = new PrimeGenerator(1,10);
        pg.generatePrimes();
        assertEquals(4,pg.getPrimes().size());
    }

    @Test
    public void noOfPrimeFrom7to17() {

        pg = new PrimeGenerator(7,17);
        pg.generatePrimes();

        assertEquals(7-3,pg.getPrimes().size());
    }

}