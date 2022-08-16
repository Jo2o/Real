package unittesting.auditsystem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Builder
@RequiredArgsConstructor
public class AuditManager1 {

    private final int maxEntriesPerFile;
    private final String directoryName;

  /**
   * Retrieves a full list of files from the working directory 
   * 
   * Sorts them by index (all filenames follow the same pattern: audit_{index}.txt [for example, audit_1.txt]) 
   * 
   * If there are no audit files yet, creates a first one with a single record 
   * 
   * If there are audit files, gets the most recent one and either appends the new record to it or creates a new file, 
   * depending on whether the number of entries in that file has reached the limit
   *
   * @param visitorName
   * @param directoryName
   */
  @SneakyThrows
  public void addRecord(String visitorName, String directoryName) {
      
      
      List<Path> files = Files.list(Path.of(directoryName))
          .sorted()
          .collect(Collectors.toList());
      
      if (files.size() == 0) {
          
      }
  }
}
