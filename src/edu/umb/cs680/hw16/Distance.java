package edu.umb.cs680.hw16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distance {

    public static double get(List<Double> p1, List<Double> p2){ //Euclidean Distance
        return Distance.get(p1,p2, ((o1, o2) -> {
            double sum = 0, EucliDistance = 0;
            for(int i = 0 ; i<o1.size(); i++){
                sum = sum + Math.pow(o1.get(i) - o2.get(i), 2);
            }
            EucliDistance = Math.sqrt(sum);
            return EucliDistance;
        }));
    }

    public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric){
        return metric.distance(p1,p2);
    }

    public static List<List<Double>> matrix (List<List<Double>> points){
        return Distance.matrix(points,((o1, o2) -> {
            double sum = 0, EucliDistance = 0;
            for(int i = 0 ; i<o1.size(); i++){
                sum = sum + Math.pow(o1.get(i) - o2.get(i), 2);
            }
            EucliDistance = Math.sqrt(sum);
            return EucliDistance;
        }));
    }

    public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {

        int noOfPoints = points.size();

        List<List<Double>> distMatrix = formDistanceMatrix(noOfPoints);
        List<Double> now;
        List<Double> then;

        for(int i = 0; i < noOfPoints; i++) {

            now = (List)points.get(i);

            for(int j = 0; j < noOfPoints; ++j) {

                then = (List)points.get(j);

                double distance = get(now, then, metric);
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
