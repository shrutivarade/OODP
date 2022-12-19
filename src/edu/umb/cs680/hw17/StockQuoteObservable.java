package edu.umb.cs680.hw17;

public class StockQuoteObservable extends Observable{

    public void changeQuote(String t, double q){
        notifyObserver(new StockEvent(t,q));
        System.out.println("Observer updated");
    }
}
