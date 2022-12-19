package edu.umb.cs680.hw11;

import edu.umb.cs680.hw11.Manhattan;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanTest {

    @Test
    public void distanceTestWithP1P2() {
        double expected = 30.0;

        List<Double> p1 = Arrays.asList(2.0, 14.0, 6.0);
        List<Double> p2 = Arrays.asList(16.0, 4.0, 12.0);
        double actual = new Manhattan().distance(p1, p2);

        assertEquals(expected, actual);
    }

}