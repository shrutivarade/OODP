package edu.umb.cs680.hw17;

public class ThreeDObserver implements Observer {
    @Override
    public void update(Observable sender, Object o) {
        System.out.println("StockEvent ThreeDChart Updated");
    }
}
