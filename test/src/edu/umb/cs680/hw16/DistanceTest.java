package edu.umb.cs680.hw16;

import edu.umb.cs680.hw16.Distance;
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
    public void testForManhattanDist() {

        double actual = Distance.get(p1, p2, (p1, p2) -> {
            double ManhatDistance = 0;
            for(int i = 0 ; i<p1.size(); i++){
                ManhatDistance = ManhatDistance + Math.abs(p1.get(i) - p2.get(i));
            }
            return ManhatDistance;
        });
        assertEquals(9.0, actual);
    }

    @Test
    public void manhattanMatrix() {
        Double[][] expected = {
                { 0.0, 9.0, 18.0, 4.0, 9.0 },
                { 9.0, 0.0, 9.0, 9.0, 4.0 },
                { 18.0, 9.0, 0.0, 18.0, 9.0 },
                { 4.0, 9.0, 18.0, 0.0, 9.0 },
                { 9.0, 4.0, 9.0, 9.0, 0.0 } };

        List<List<Double>> actual = Distance.matrix(points, (o1, o2) -> {
            double ManhatDistance = 0;
            for(int i = 0 ; i<o1.size(); i++){
                ManhatDistance = ManhatDistance + Math.abs(o1.get(i) - o2.get(i));
            }
            return ManhatDistance;
        });

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }

    @Test
    public void testForEuclideanDist() {
        double actual = Distance.get(p1, p2, ((p1, p2) -> {
            double sum = 0, EucliDistance = 0;
            for(int i = 0 ; i<p1.size(); i++){
                sum = sum + Math.pow(p1.get(i) - p2.get(i), 2);
            }
            EucliDistance = Math.sqrt(sum);
            return EucliDistance;
        }));
        assertEquals(Math.sqrt(27.0), actual);
    }

    @Test
    public void euclideanMatrix() {
        Double[][] expected = {
                { 0.0, Math.sqrt(27.0), Math.sqrt(108.0), Math.sqrt(8.0), Math.sqrt(35.0) },
                { Math.sqrt(27.0), 0.0, Math.sqrt(27.0), Math.sqrt(35.0), Math.sqrt(8.0) },
                { Math.sqrt(108.0), Math.sqrt(27.0), 0.0, Math.sqrt(116.0), Math.sqrt(35.0) },
                { Math.sqrt(8.0), Math.sqrt(35.0), Math.sqrt(116.0), 0.0, Math.sqrt(27.0) },
                { Math.sqrt(35.0), Math.sqrt(8.0), Math.sqrt(35.0), Math.sqrt(27.0), 0.0 } };

        List<List<Double>> actual = Distance.matrix(points, ((p1, p2) -> {
            double sum = 0, EucliDistance = 0;
            for(int i = 0 ; i<p1.size(); i++){
                sum = sum + Math.pow(p1.get(i) - p2.get(i), 2);
            }
            EucliDistance = Math.sqrt(sum);
            return EucliDistance;
        }));

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }

    @Test
    public void testForChebyshevDist() {
        double actual = Distance.get(p1, p2, ((p1, p2) -> {
            double max = 0, ChebyDistance = 0;
            for (int i = 0; i < p1.size(); i++)
            {
                double temp = Math.abs(p1.get(i) - p2.get(i));
                if(max < temp)
                {
                    max = temp;
                }
            }
            ChebyDistance = max;

            return ChebyDistance;
        }));
        assertEquals(3.0, actual);
    }

    @Test
    public void chebyshevMatrix() {
        Double[][] expected = {
                { 0.0, 3.0, 6.0, 2.0, 5.0 },
                { 3.0, 0.0, 3.0, 5.0, 2.0 },
                { 6.0, 3.0, 0.0, 8.0, 5.0 },
                { 2.0, 5.0, 8.0, 0.0, 3.0 },
                { 5.0, 2.0, 5.0, 3.0, 0.0 } };

        List<List<Double>> actual = Distance.matrix(points, ((o1, o2) -> {
            double max = 0, ChebyDistance = 0;
            for (int i = 0; i < o1.size(); i++)
            {
                double temp = Math.abs(o1.get(i) - o2.get(i));
                if(max < temp)
                {
                    max = temp;
                }
            }
            ChebyDistance = max;

            return ChebyDistance;
        }));

        for (int i = 0; i < expected.length; i++) {
            Double[] temp = new Double[5];

            assertArrayEquals(expected[i], actual.get(i).toArray(temp));

        }
    }

}