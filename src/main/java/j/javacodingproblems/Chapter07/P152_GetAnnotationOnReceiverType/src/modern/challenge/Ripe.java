package j.javacodingproblems.Chapter07.P152_GetAnnotationOnReceiverType.src.modern.challenge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ripe {}
