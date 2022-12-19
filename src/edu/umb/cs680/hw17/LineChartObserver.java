package edu.umb.cs680.hw17;

public class LineChartObserver implements Observer{
    @Override
    public void update(Observable sender, Object o) {
        System.out.println("StockEvent LineChart Updated");
    }


}
