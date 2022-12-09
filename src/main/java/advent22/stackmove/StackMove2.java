package advent22.stackmove;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackMove2 {

    private static final String START_STATE_INPUT_PATH = "src/main/java/advent22/stackmove/startstate01.txt";
    private static final String MOVING_INPUT_PATH = "src/main/java/advent22/stackmove/moving01.txt";
    private static final List<Stack<Character>> STACKS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<Stack<Character>> reversedStacks = loadStacks();

        for (var stack : reversedStacks) {
            STACKS.add(reverseStack(stack));
        }
        log.info("{}", STACKS);

        try (Stream<String> lines = Files.lines(Paths.get(MOVING_INPUT_PATH), StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                line = line.replace("move ", "").replace(" from ", ",").replace(" to ", ",");
                String[] moves = line.split(",");
                move(parseInt(moves[0]), parseInt(moves[1]), parseInt(moves[2]));
                log.info("{}", line);
            });
        }

        List<Character> topCrates = STACKS.stream()
            .filter(stack -> !stack.isEmpty())
            .map(Stack::peek)
            .collect(Collectors.toList());

        log.info("Top crates: {}", topCrates);

    }

    private static void move(int amount, int from, int to) {
        Stack<Character> fromStack = STACKS.get(from);
        Stack<Character> toStack = STACKS.get(to);
        Stack<Character> tempStack = STACKS.get(0);
        for (int i = 0; i < amount; i++) {
            tempStack.push(fromStack.pop());
        }
        for (int i = 0; i < amount; i++) {
            toStack.push(tempStack.pop());
        }
    }

    private static List<Stack<Character>> loadStacks() throws IOException {
        List<Stack<Character>> stacks = new ArrayList<>();
        stacks.add(new Stack<>()); // stack used for moving crates around
        try (Stream<String> lines = Files.lines(Paths.get(START_STATE_INPUT_PATH), StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                for (int i = 1; i < line.length(); i += 4) {
                    int idx = convertIdx(i);
                    if (stacks.size() < idx + 1) {
                        stacks.add(new Stack<>());
                    }
                    char ch = line.charAt(i);
                    if (ch != ' ') {
                        stacks.get(idx).push(ch);
                    }
                }
            });
        }
        return Collections.unmodifiableList(stacks);
    }

    /**
     * Converts indexes of StartState file: 1->1, 5->2, 9->3, 13->4
     * @param idx of crate in the file
     * @return index of a stack
     */
    private static int convertIdx(int idx) {
        return (idx - 1)/4 + 1;
    }

    private static Stack<Character> reverseStack(Stack<Character> stack) {
        Stack<Character> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        return result;
    }

}
