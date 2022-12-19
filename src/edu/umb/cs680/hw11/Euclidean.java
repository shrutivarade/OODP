package edu.umb.cs680.hw11;

import java.util.List;

public class Euclidean implements DistanceMetric{

    double EucliDistance = 0;
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double sum = 0;
        for(int i = 0 ; i<p1.size(); i++){
            sum = sum + Math.pow(p1.get(i) - p2.get(i), 2);
        }
        EucliDistance = Math.sqrt(sum);
        return EucliDistance;
    }
}
