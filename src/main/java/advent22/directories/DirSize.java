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
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DirSize {

    private static final String INPUT_PATH = "src/main/java/advent22/directories/in.txt";
    private static final String PATH_SEPARATOR = "/";
    private static boolean AFTER_LS = false;

    public static void main(String[] args) throws IOException {

        Node root = Node.builder()
            .name("/")
            .path("/")
            .build();

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
                    String dirName = line.substring(5);
                    List<Node> result = new ArrayList<>();
                    findNode(
                        root,
                        Node.builder()
                            .name(dirName)
                            .path(currentNode.getPath() + PATH_SEPARATOR + dirName)
                            .build(),
                        result);
                    currentNode = result.get(0);

                } else if (AFTER_LS) {
                    currentNode.addChild(nodeFromLine(line, currentNode));

                } else {
                    throw new RuntimeException("Unexpected line: " + line);
                }
            }
        }

        log.info("{}", root);

        Map<String, Integer> dirSizes = new HashMap<>();
        countDirSizes(root, dirSizes);
        for (Entry<String, Integer> entry : dirSizes.entrySet()) {
            log.info("{}", entry);
        }

        root.setSize(root.getChildren().stream().mapToInt(Node::getSize).sum());

        int diskSpaceFree = 70000000 - root.getSize();
        int diskSpaceNeeded = 30000000 - diskSpaceFree;
        log.info("\nDisk space total: {}", 70000000);
        log.info("\nDisk space occupied: {}", root.getSize());
        log.info("\nDisk space free: {}", diskSpaceFree);
        log.info("\nDisk space needed: {}", diskSpaceNeeded);

        int result = dirSizes.values().stream()
            .filter(i -> i <= 100000)
            .mapToInt(i -> i)
            .sum();

        log.info("Sum of dirs less than 100000 (incl.) in size: {}", result);

    List<Entry<String, Integer>> resultEntriesLess =
        dirSizes.entrySet().stream()
            .filter(e -> e.getValue() <= diskSpaceNeeded + 10000)
            .sorted((e1, e2) -> (-1) * Integer.compare(e1.getValue(), e2.getValue()))
            .collect(Collectors.toList());

        log.info("\nSorted dirs less than needed space: {}", resultEntriesLess);
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
                Integer size = result.get(child.getPath());
                sum += isNull(size) ? 0 : size;
            }
        }
        if (node.getDirTreeNodeType() == DIR) {
            result.put(node.getPath(), sum);
            node.setSize(sum);
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
                .path(parent.getPath() + PATH_SEPARATOR + line.substring(4))
                .parent(parent)
                .dirTreeNodeType(DIR)
                .build();
        }
        String[] sizeName = line.split(" ", 2);
        return Node.builder()
            .name(sizeName[1])
            .path(parent.getPath() + PATH_SEPARATOR + sizeName[1])
            .size(parseInt(sizeName[0]))
            .parent(parent)
            .dirTreeNodeType(FILE)
            .build();
    }

}
