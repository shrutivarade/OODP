package edu.umb.cs680.hw11;

import edu.umb.cs680.hw11.Chebyshev;
import edu.umb.cs680.hw11.Distance;
import edu.umb.cs680.hw11.Euclidean;
import edu.umb.cs680.hw11.Manhattan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    private static List<Double> p1, p2, p3, p4, p5;
    private static List<List<Double>> points = new LinkedList<>();
    @BeforeAll
    static void createListOfPoints(){
        p1 = Arrays.asList(1.0, 2.0, 3.0);
        p2 = Arrays.asList(4.0, 5.0, 6.0);
        p3 = Arrays.asList(7.0, 8.0, 9.0);
        p4 = Arrays.asList(3.0, 2.0, 1.0);
        p5 = Arrays.asList(6.0, 5.0, 4.0);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
    }

    @Test
    public void distForTwoPoints() {
        double actual = Distance.get(p1, p2);
        assertEquals(Math.sqrt(27.0), actual);
    }

    @Test
    public void testForEuclideanDist() {
        double actual = Distance.get(p1, p2, new Euclidean());
        assertEquals(Math.sqrt(27.0), actual);
    }

    @Test
    public void testForManhattanDist() {
        double actual = Distance.get(p1, p2, new Manhattan());
        assertEquals(9.0, actual);
    }

    @Test
    public void testForChebyshevDist() {
        double actual = Distance.get(p1, p2, new Chebyshev());
        assertEquals(3.0, actual);
    }



    @Test
    public void euclideanMatrix() {
        Double[][] expected = {
                { 0.0, Math.sqrt(27.0), Math.sqrt(108.0), Math.sqrt(8.0), Math.sqrt(35.0) },
                { Math.sqrt(27.0), 0.0, Math.sqrt(27.0), Math.sqrt(35.0), Math.sqrt(8.0) },
                { Math.sqrt(108.0), Math.sqrt(27.0), 0.0, Math.sqrt(116.0), Math.sqrt(35.0) },
                { Math.sqrt(8.0), Math.sqrt(35.0), Math.sqrt(116.0), 0.0, Math.sqrt(27.0) },
                { Math.sqrt(35.0), Math.sqrt(8.0), Math.sqrt(35.0), Math.sqrt(27.0), 0.0 } };

        List<List<Double>> actual = Distance.matrix(points);

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }

    @Test
    public void manhattanMatrix() {
        Double[][] expected = {
                { 0.0, 9.0, 18.0, 4.0, 9.0 },
                { 9.0, 0.0, 9.0, 9.0, 4.0 },
                { 18.0, 9.0, 0.0, 18.0, 9.0 },
                { 4.0, 9.0, 18.0, 0.0, 9.0 },
                { 9.0, 4.0, 9.0, 9.0, 0.0 } };

        List<List<Double>> actual = Distance.matrix(points, new Manhattan());

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }

    @Test
    public void chebyshevMatrix() {
        Double[][] expected = {
                { 0.0, 3.0, 6.0, 2.0, 5.0 },
                { 3.0, 0.0, 3.0, 5.0, 2.0 },
                { 6.0, 3.0, 0.0, 8.0, 5.0 },
                { 2.0, 5.0, 8.0, 0.0, 3.0 },
                { 5.0, 2.0, 5.0, 3.0, 0.0 } };

        List<List<Double>> actual = Distance.matrix(points, new Chebyshev());

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }


}