package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class GroupByWithAverageSalary {

    public static void main(String[] args) {

        Map<String, Double> averageSalariesInDepartments = Employee.createSampleList()
                .stream()
                .collect(groupingBy(Employee::getDepartment, averagingInt(Employee::getSalary)));

        log.info(averageSalariesInDepartments.toString());
    }
}
