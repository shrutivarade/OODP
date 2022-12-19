package edu.umb.cs680.hw11;

import java.util.List;

public class Chebyshev implements DistanceMetric{

    double ChebyDistance = 0;
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double max = 0;
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
    }
}
