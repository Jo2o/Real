package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class MaxAsReduce {

    public static void main(String[] args) {

        Employee max = Employee.createSampleList()
                .stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary())
                .orElse(Employee.builder().build());

        log.info(max.toString());
    }
}
