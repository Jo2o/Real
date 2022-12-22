package advent22.monkeys;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    private static final int ROUNDS = 20;

    public static void main(String[] args) {

        Map<Integer, Monkey> monkeys = createMonkeys().stream()
            .collect(toMap(Monkey::getName, Function.identity()));

        for (int round = 1; round <= ROUNDS; round++) {
            for (Entry<Integer, Monkey> entry : monkeys.entrySet()) {
                Monkey currentMonkey = entry.getValue();
                List<Item> itemsOfCurrentMonkey = currentMonkey.getItems();
                for (Item item : itemsOfCurrentMonkey) {

                    currentMonkey.setInspections(currentMonkey.getInspections() + 1);
                    int newWorryLevel = currentMonkey.getOperation().apply(item.getWorryLevel());
                    int relievedWorryLevel = newWorryLevel/3;
                    int passItMonkeyNumber = currentMonkey.getTest().apply(relievedWorryLevel);

                    item.setWorryLevel(relievedWorryLevel);
                    monkeys.get(passItMonkeyNumber).getItems().add(item);
                }
                itemsOfCurrentMonkey.clear();
            }
        }

        List<Monkey> inspectionOrderedMonkeys = monkeys.values().stream()
            .sorted(Comparator.comparingInt(Monkey::getInspections).reversed())
            .collect(Collectors.toList());

        int monkeyBusiness = 1;
        for (int i = 0; i < 2; i++) {
          monkeyBusiness *= inspectionOrderedMonkeys.get(i).getInspections();
        }
        log.info("Monkey business: {}", monkeyBusiness);
        System.out.println(monkeys);
    }

  public static List<Monkey> createMonkeys() {
      return List.of(
          Monkey.builder()
              .name(0)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(1, 52),
                  Item.of(2, 60),
                  Item.of(3, 85),
                  Item.of(4, 69),
                  Item.of(5, 75),
                  Item.of(6, 75))))
              .operation(old -> old * 17)
              .test(worryLevel -> (worryLevel % 13 == 0) ? 6 : 7)
              .build(),
          Monkey.builder()
              .name(1)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(7, 96),
                  Item.of(8, 82),
                  Item.of(9, 61),
                  Item.of(10, 99),
                  Item.of(11, 82),
                  Item.of(12, 84),
                  Item.of(13, 85))))
              .operation(old -> old + 8)
              .test(worryLevel -> (worryLevel % 7 == 0) ? 0 : 7)
              .build(),
          Monkey.builder()
              .name(2)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(14, 95),
                  Item.of(15, 79))))
              .operation(old -> old + 6)
              .test(worryLevel -> (worryLevel % 19 == 0) ? 5 : 3)
              .build(),
          Monkey.builder()
              .name(3)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(16, 88),
                  Item.of(17, 50),
                  Item.of(18, 82),
                  Item.of(19, 65),
                  Item.of(20, 77))))
              .operation(old -> old * 19)
              .test(worryLevel -> (worryLevel % 2 == 0) ? 4 : 1)
              .build(),
          Monkey.builder()
              .name(4)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(21, 66),
                  Item.of(22, 90),
                  Item.of(23, 59),
                  Item.of(24, 90),
                  Item.of(25, 87),
                  Item.of(26, 63),
                  Item.of(27, 53),
                  Item.of(28, 88))))
              .operation(old -> old + 7)
              .test(worryLevel -> (worryLevel % 5 == 0) ? 1 : 0)
              .build(),
          Monkey.builder()
              .name(5)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(29, 92),
                  Item.of(30, 75),
                  Item.of(31, 62))))
              .operation(old -> old * old)
              .test(worryLevel -> (worryLevel % 3 == 0) ? 3 : 4)
              .build(),
          Monkey.builder()
              .name(6)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(32, 94),
                  Item.of(33, 86),
                  Item.of(34, 76),
                  Item.of(35, 67))))
              .operation(old -> old + 1)
              .test(worryLevel -> (worryLevel % 11 == 0) ? 5 : 2)
              .build(),
          Monkey.builder()
              .name(7)
              .items(new ArrayList<>(Arrays.asList(
                  Item.of(36, 57))))
              .operation(old -> old + 2)
              .test(worryLevel -> (worryLevel % 17 == 0) ? 6 : 2)
              .build());
  }

    public static List<Monkey> createExampleMonkeys() {
        return List.of(
            Monkey.builder()
                .name(0)
                .items(new ArrayList<>(Arrays.asList(
                    Item.of(1, 79),
                    Item.of(2, 98))))
                .operation(old -> old * 19)
                .test(worryLevel -> (worryLevel % 23 == 0) ? 2 : 3)
                .build(),
            Monkey.builder()
                .name(1)
                .items(new ArrayList<>(Arrays.asList(
                    Item.of(3, 54),
                    Item.of(4, 65),
                    Item.of(5, 75),
                    Item.of(6, 74))))
                .operation(old -> old + 6)
                .test(worryLevel -> (worryLevel % 19 == 0) ? 2 : 0)
                .build(),
            Monkey.builder()
                .name(2)
                .items(new ArrayList<>(Arrays.asList(
                    Item.of(7, 79),
                    Item.of(8, 60),
                    Item.of(9, 97))))
                .operation(old -> old * old)
                .test(worryLevel -> (worryLevel % 13 == 0) ? 1 : 3)
                .build(),
            Monkey.builder()
                .name(3)
                .items(new ArrayList<>(Arrays.asList(
                    Item.of(10, 74))))
                .operation(old -> old + 3)
                .test(worryLevel -> (worryLevel % 17 == 0) ? 0 : 1)
                .build());
    }

}
