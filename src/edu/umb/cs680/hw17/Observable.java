package edu.umb.cs680.hw17;


import java.util.ArrayList;
import java.util.List;

public class Observable<StockEvent> {



    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer<StockEvent> o){
        System.out.println("Observer Added");
    }


    public void removeObserver(Observer<StockEvent> o){
        System.out.println("Observer Removed");
    }

    public int countObservers(){
        return this.observers.size();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void clearObservers(){

    }

    public void notifyObserver(StockEvent event){
        observers.forEach((observer -> {observer.update(this,event);}));
    }


}
