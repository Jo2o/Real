package advent22.directories;

import static advent22.directories.DirTreeNodeType.DIR;
import static advent22.directories.DirTreeNodeType.FILE;
import static java.lang.Integer.parseInt;
import static java.util.Objects.isNull;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DirSize {

    private static final String INPUT_PATH = "src/main/java/advent22/directories/in.txt";
//    private static final String INPUT_PATH = "src/main/java/advent22/directories/test.txt";
    private static boolean AFTER_LS = false;

    public static void main(String[] args) throws IOException {

        Node root = Node.builder().name("/").build();
        Node currentNode = root;

        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {

                if ("$ ls".equals(line)) {
                    AFTER_LS = true;

                } else  if ("$ cd ..".equals(line)) {
                    AFTER_LS = false;
                    if (currentNode.getParent() != null) {
                        currentNode = currentNode.getParent();
                    }

                } else if ("$ cd /".equals(line)) {
                    AFTER_LS = false;

                } else if (line.startsWith("$ cd ")) {
                    AFTER_LS = false;
                    List<Node> result = new ArrayList<>();
                    findNode(root, Node.builder().name(line.substring(5)).build(), result);
                    currentNode = result.get(0);
                } else if (AFTER_LS) {
                    currentNode.addChild(nodeFromLine(line, currentNode));
                }
            }
        }

        log.info("{}", root);

        Map<String, Integer> dirSizes = new HashMap<>();
        countDirSizes(root, dirSizes);
        log.info("{}", dirSizes);

        int result = dirSizes.values().stream()
            .filter(i -> i <= 100000)
            .mapToInt(i -> i)
            .sum();

        log.info("Sum of dirs less than 100000 (incl.) in size: {}", result);

    }

    private static void countDirSizes(Node node, Map<String, Integer> result) {
        List<Node> children = node.getChildren();
        if (isEmpty(children)) {
            return;
        }
        int sum = 0;
        for (Node child : children) {
            if (child.getDirTreeNodeType() == FILE) {
                sum += child.getSize();
            } else {
                countDirSizes(child, result);
                Integer size = result.get(child.getName());
                sum += isNull(size) ? 0 : size;
            }
        }
        if (node.getDirTreeNodeType() == DIR) {
            result.put(node.getName(), sum);
        }
    }

    private static void findNode(Node node, Node nodeToFind, List<Node> result) {
        if (isNotEmpty(result)) {
            return;
        }
        if (isNotEmpty(node.getChildren()) && node.getChildren().contains(nodeToFind)) {
            result.add(node.getChildren().get(node.getChildren().indexOf(nodeToFind)));
            return;
        }
        if (isNotEmpty(node.getChildren())) {
            for (Node child : node.getChildren()) {
                findNode(child, nodeToFind, result);
            }
        }
    }

    private static Node nodeFromLine(String line, Node parent) {
        if (line.startsWith("dir ")) {
            return Node.builder()
                .name(line.substring(4))
                .parent(parent)
                .dirTreeNodeType(DIR)
                .build();
        }
        String[] sizeName = line.split(" ", 2);
        return Node.builder()
            .name(sizeName[1])
            .size(parseInt(sizeName[0]))
            .parent(parent)
            .dirTreeNodeType(FILE)
            .build();
    }

}
