package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class MaxWithComparator {

    public static void main(String[] args) {

        Employee max = Employee.createSampleList()
                .stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary())
                .orElse(Employee.builder().build());

        log.info(max.toString());
    }
}
