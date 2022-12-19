package src.edu.umb.cs680.hw17;

import edu.umb.cs680.hw17.*;
import org.junit.jupiter.api.Test;


class StockEventTest {

    public StockQuoteObservable obs = new StockQuoteObservable();
    LineChartObserver LCO = new LineChartObserver();
    TableChartObserver TCO = new TableChartObserver();
    ThreeDObserver TDO = new ThreeDObserver();


    @Test
    public void STOCKTest() {
        obs.addObserver(LCO);
        obs.addObserver(TCO);
        obs.addObserver(TDO);

        obs.changeQuote("hji", 80.0);

        obs.removeObserver(LCO);
        obs.removeObserver(TCO);
        obs.removeObserver(TDO);
    }

    /*Observer quoteUpdateLineChart = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("StockEvent LineChart Updated");
    };
    Observer quoteUpdateTableChart = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("StockEvent TableChart Updated");
    };
    Observer quoteUpdateThreeDChart = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("StockEvent ThreeDChart Updated");
    };*/


}