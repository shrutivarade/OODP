package src.edu.umb.cs680.hw17;

import edu.umb.cs680.hw17.*;
import org.junit.jupiter.api.Test;


class StockEventTest {

    public StockQuoteObservable obs = new StockQuoteObservable();
    LineChartObserver LCO = new LineChartObserver();
    TableChartObserver TCO = new TableChartObserver();
    ThreeDObserver TDO = new ThreeDObserver();


    @Test
    public void STOCKTestwithoutLE() {
        obs.addObserver(LCO);
        obs.addObserver(TCO);
        obs.addObserver(TDO);
        obs.changeQuote("xyz", 80.0);
        obs.removeObserver(LCO);
        obs.removeObserver(TCO);
        obs.removeObserver(TDO);
    }

    @Test
    public void STOCKTestwithLE() {
        obs.addObserver((sender, event) -> System.out.println("StockEvent LineChart Updated"));
        obs.addObserver((sender, event) -> System.out.println("StockEvent TableChart Updated"));
        obs.addObserver((sender, event) -> System.out.println("StockEvent ThreeDChart Updated"));
        obs.changeQuote("PQR", 60.0);
        obs.removeObserver((sender, event) -> System.out.println("StockEvent LineChart Updated"));
        obs.removeObserver((sender, event) -> System.out.println("StockEvent TableChart Updated"));
        obs.removeObserver((sender, event) -> System.out.println("StockEvent ThreeDChart Updated"));
    }



}
