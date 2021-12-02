package functional.venkat.lambdadesign;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@Slf4j
public class Decoration {   // multiple delegates - chain them to add behavior


    public static void main(String[] args) {
        Camera camera = new Camera();

        Consumer<String> printCaptured = filterInfo -> {
            log.info("with {}: {}", filterInfo, camera.capture(new Color(200, 100, 200)));
        };
        printCaptured.accept("NoFilter");

        camera.setFilters(Color::brighter);
        printCaptured.accept("BrighterFilter");

        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("BrighterDarkerFilter");

    }

    static class Camera {
        private Function<Color, Color> filter;    // We can DECORATE/COMBINE/CHAIN/COMPOSE more filters into this one! :D

        public Camera() {
            setFilters();
        }

        public Color capture(final Color inColor) {
            return filter.apply(inColor);
        }

        @SafeVarargs
        public final void setFilters(Function<Color, Color>... filters) {
            this.filter = Stream.of(filters)
                    .reduce(Function::compose)
                    .orElse(color -> color);   // This color will come from CAPTURE function. In: Color - Out: Color => Function::identity
        }
    }

}
