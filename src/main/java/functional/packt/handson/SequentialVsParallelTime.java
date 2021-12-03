package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

import static java.lang.System.nanoTime;

@Slf4j
public class SequentialVsParallelTime {

    public static void main(String[] args) {

        long start = nanoTime();

        long evenCount = IntStream.rangeClosed(0, 1000_000_000)
                .filter(i -> i%2 == 0)
                .count();

        log.info("Count of evens: {}. In sequential it took {}ns.", evenCount, nanoTime() - start); // 1_051_940_400

        start = nanoTime();

        evenCount = IntStream.rangeClosed(0, 1000_000_000)
                .parallel()
                .filter(i -> i%2 == 0)
                .count();

        log.info("Count of evens: {}. In parallel it took {}ns.", evenCount, nanoTime() - start); // 202_494_700
    }
}
