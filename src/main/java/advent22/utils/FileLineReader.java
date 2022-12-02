package advent22.utils;

@FunctionalInterface
public interface FileLineReader {

    <T> T execute(String path);

}
