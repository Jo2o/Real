package functional.packt.handson;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class Employee {

    private String name;
    private String department;
    private int salary;

    public static List<Employee> createSampleList() {
        return List.of(
                Employee.builder()
                        .name("Johnny")
                        .department("HR")
                        .salary(1000)
                        .build(),

                Employee.builder()
                        .name("Sonya")
                        .department("Soldiers")
                        .salary(3500)
                        .build(),

                Employee.builder()
                        .name("Jax")
                        .department("Soldiers")
                        .salary(2000)
                        .build(),

                Employee.builder()
                        .name("Raiden")
                        .department("Gods")
                        .salary(7500)
                        .build(),

                Employee.builder()
                        .name("Liu")
                        .department("HR")
                        .salary(3000)
                        .build()
        );
    }
}
