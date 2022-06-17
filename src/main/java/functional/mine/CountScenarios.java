package functional.mine;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountScenarios {
    
    private static final List<String> fileLines = List.of(
        "trala",
        "trala",
        "trala",
        "Scenario:",
        "trala",
        "trala",
        "|  |||||",
        "trala",
        "trala",
        "Scenario Outline:",
        "trala",
        "trala",
        "trala",
        "Examples:",
        "| seq |||||",
        "| 01 |||||",
        "| 02 |||||",
        "| 03 |||||",
        "trala",
        "trala",
        "Scenario:",
        "trala",
        "Scenario Outline:    ",
        "trala",
        "trala",
        "Examples:",
        "| seq |||||",
        "| 01 |||||",
        "| 02 |||||",
        "| 03 |||||",
        "trala",
        "trala",
        "trala",
        "Scenario:",
        "trala",
        "trala",
        "trala");

    public static void main(String[] args) {
        int scenarioOutlineCounter = 0;
        boolean insideScenarioOutline = false;
        boolean insideExamples = false;
        
        for (String fileLine : fileLines) {
            if (fileLine.isEmpty() || fileLine.startsWith("Scenario:")) {
                insideScenarioOutline = false;
                insideExamples = false;
            
            } else if (fileLine.startsWith("Scenario Outline:")) {
                insideScenarioOutline = true;
                insideExamples = false;
            }
            
            if (insideScenarioOutline && fileLine.startsWith("Examples:")) {
                insideExamples = true;
            }
            
            if (insideScenarioOutline && insideExamples && !fileLine.startsWith("| seq") && fileLine.startsWith("| ")) {
                scenarioOutlineCounter++;
            }
        }
        
        log.info("RESULT: {}", scenarioOutlineCounter);
    }

}
