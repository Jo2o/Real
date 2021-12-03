package functional.packt.handson;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Slf4j
public class ParallelGrouping {

    public static void main(String[] args) {

        ConcurrentMap<String, List<Employee>> groupedByDepartment = Employee.createSampleList()
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getDepartment));

        log.info(groupedByDepartment.toString());

    }
}
