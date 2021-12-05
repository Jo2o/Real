package functional.venkat.resources;

import java.io.IOException;

@FunctionalInterface
public interface UseInstance <T> {

    void accept(T instance) throws IOException;

}
