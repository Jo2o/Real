package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Sort {

    public static void main(String[] args) {

        List<Employee> sorted = Employee.createSampleList()
                .stream()
                .sorted(Comparator.comparing(Employee::getName)) // KEY EXTRACTOR ... (e1, e2) -> e1.getName().compareTo(e2.getName())
                .collect(Collectors.toUnmodifiableList());

        log.info(sorted.toString());
    }
}
