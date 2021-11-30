package functional.venkat.lambdadesign;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Delegation { // separate concern from a class


    public static void main(String[] args) {
        Calculator calculatorStub = new Calculator(ticker -> new BigDecimal("6.01")); // actually does nothing with the ticker
        log.info("STUB: {}", calculatorStub.computeStock("GOOG", 1000));

        Calculator calculatorWeb = new Calculator(YahooFinance::getPrice); // this one does - it calls web service
        log.info("WEB: {}", calculatorWeb.computeStock("GOOG", 1000));
    }

    @RequiredArgsConstructor
    static class Calculator {
        private final Function<String, BigDecimal> priceFinder;

        public BigDecimal computeStock(String ticker, int shares) {
            return priceFinder.apply(ticker)
                    .multiply(BigDecimal.valueOf(shares));
        }
    }

    static class YahooFinance {
        @SneakyThrows
        public static BigDecimal getPrice(String ticker) {
            final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length - 1]);
        }
    }

}
