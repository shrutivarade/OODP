package edu.umb.cs680.hw01;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class PrimeGeneratorTest {

    PrimeGenerator pg;

    @Test
    public void Testconstructorfornegativevalue() {
        try{
            pg = new PrimeGenerator(-1,7);
        }
        catch(RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "Wrong input values: from=-1 to=7");
            //assertThrows(e.getClass(),()->new PrimeGenerator(-1,7));
        }
    }

    @Test
    public void NoOfPrimefrom1to10() {

        PrimeGenerator pg = new PrimeGenerator(1,10);
        pg.generatePrimes();
        assertEquals(4,pg.getPrimes().size());
    }

    @Test
    public void NoOfPrimefrom1to7() {

        PrimeGenerator pg = new PrimeGenerator(1,7);
        pg.generatePrimes();
        assertEquals(4,pg.getPrimes().size());
    }


    @Test
    public void ListofPrimeNumbers1to5() {
        PrimeGenerator pg = new PrimeGenerator(1,5);
        pg.generatePrimes();

        LinkedList<Long> ll = new LinkedList<Long>();
        ll.add(2L);
        ll.add(3L);
        ll.add(5L);
        assertEquals(ll, pg.getPrimes() );

    }

    @Test
    public void ListofPrimeNumbers1to100() {
        PrimeGenerator pg = new PrimeGenerator(1,100);
        pg.generatePrimes();
        assertEquals(2,pg.getPrimes().get(0));
        assertEquals(3,pg.getPrimes().get(1));
        assertEquals(5,pg.getPrimes().get(2));
        assertEquals(7,pg.getPrimes().get(3));
        assertEquals(11,pg.getPrimes().get(4));
        assertEquals(13,pg.getPrimes().get(5));
        assertEquals(17,pg.getPrimes().get(6));
        assertEquals(19,pg.getPrimes().get(7));
        assertEquals(23,pg.getPrimes().get(8));
        assertEquals(29,pg.getPrimes().get(9));
        assertEquals(31,pg.getPrimes().get(10));
        assertEquals(37,pg.getPrimes().get(11));
        assertEquals(41,pg.getPrimes().get(12));
        assertEquals(43,pg.getPrimes().get(13));
        assertEquals(47,pg.getPrimes().get(14));
        assertEquals(53,pg.getPrimes().get(15));
        assertEquals(59,pg.getPrimes().get(16));
        assertEquals(61,pg.getPrimes().get(17));
        assertEquals(67,pg.getPrimes().get(18));
        assertEquals(71,pg.getPrimes().get(19));
        assertEquals(73,pg.getPrimes().get(20));
        assertEquals(79,pg.getPrimes().get(21));
        assertEquals(83,pg.getPrimes().get(22));
        assertEquals(89,pg.getPrimes().get(23));
        assertEquals(97,pg.getPrimes().get(24));
    }


    /*@Test
    public void isEven(){
        PrimeGenerator pg = new PrimeGenerator(1,5);
        for(int i=1; i<=5; i+=2){
            assertFalse(pg.isEven(i));

        }
        for(int j=2; j<=5; j+=2){
            assertTrue(pg.isEven(j));
        }
    }*/

}