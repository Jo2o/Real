package designpatterns.factorymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        PlanFactory planFactory = new PlanFactory();

        System.out.println("Enter plan: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String planType = bufferedReader.readLine();

        System.out.println("Enter units: ");
        int units = Integer.parseInt(bufferedReader.readLine());

        Plan plan = planFactory.getPlan(planType);

        System.out.println("PlanType = " + planType + ", units = " + units + " => result = ");
        plan.setupRate();
        plan.calculateBill(units);
  }
}
