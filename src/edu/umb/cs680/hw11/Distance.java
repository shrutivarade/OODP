package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distance {

    public static double get(List<Double> p1, List<Double> p2){ //Euclidean Distance
        return Distance.get(p1,p2, new Euclidean());
    }

    public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric){ // For_Manhattan
        return metric.distance(p1,p2);
    }

    public static List<List<Double>> matrix (List<List<Double>> points){ //For_Euclidean
        return Distance.matrix(points,new Euclidean());
    }

    public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {

        int noOfPoints = points.size();

        List<List<Double>> distMatrix = formDistanceMatrix(noOfPoints);
        List<Double> p1;
        List<Double> p2;

        for(int i = 0; i < noOfPoints; i++) {

            p1 = (List)points.get(i);

            for(int j = 0; j < noOfPoints; ++j) {

                p2 = (List)points.get(j);

                double distance = get(p1, p2, metric);
                ((List)distMatrix.get(i)).set(j, distance);

            }
        }

        return distMatrix;
    }

    private static List<List<Double>> formDistanceMatrix(int noOfPoints) {

        List<List<Double>> distMatrix = new ArrayList(noOfPoints);
        Double[] vec;
        for(int i = 0; i < noOfPoints; i++) {

            vec = new Double[noOfPoints];

            Arrays.fill(vec, 0.0);
            distMatrix.add(Arrays.asList(vec));
        }

        return distMatrix;
    }
}
