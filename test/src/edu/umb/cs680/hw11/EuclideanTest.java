package edu.umb.cs680.hw11;

import edu.umb.cs680.hw11.Euclidean;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanTest {


    @Test
    public void distanceTestWithP1P2() {
        double expected = Math.sqrt(332.0);

        List<Double> p1 = Arrays.asList(2.0, 14.0, 6.0);
        List<Double> p2 = Arrays.asList(16.0, 4.0, 12.0);
        double actual = new Euclidean().distance(p1, p2);

        assertEquals(expected, actual);
    }




}