package j.annotations;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Annotated annotated = new Annotated();
        annotated.doIt();

        Class<? extends Annotated> classOfAnnotated = annotated.getClass();
        log.info("ClassOfAnnotated MyAnnotation.name: {}", ((MyAnnotation)classOfAnnotated.getAnnotations()[0]).name());
        log.info("ClassOfAnnotated MyAnnotation.count: {}", ((MyAnnotation)classOfAnnotated.getAnnotations()[0]).count());
        log.info("ClassOfAnnotated MyAnnotation.tags: {}", ((MyAnnotation)classOfAnnotated.getAnnotations()[0]).tags());

        Annotation[] methodAnnotations = classOfAnnotated.getMethod("doIt").getAnnotations();
        log.info("MethodDoItOfAnnotated MyAnnotation.name: {}", ((MyAnnotation)methodAnnotations[0]).name());
        log.info("MethodDoItOfAnnotated MyAnnotation.count: {}", ((MyAnnotation)methodAnnotations[0]).count());
        log.info("MethodDoItOfAnnotated MyAnnotation.tags: {}", ((MyAnnotation)methodAnnotations[0]).tags());

    }
}
