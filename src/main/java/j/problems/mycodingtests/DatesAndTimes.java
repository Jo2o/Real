package j.problems.mycodingtests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatesAndTimes {

  public static void main(String[] args) {
      LocalDate comeBackDate = LocalDate.of(2022, 5, 29);
      log.info("Ak mas vakcinu po tomto datume, tak mozes ist s nami na Azory: {}", 
          comeBackDate.minusDays(270).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
  }
}
