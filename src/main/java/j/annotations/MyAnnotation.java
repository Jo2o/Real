package j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Above class declaration.
 * Above class field (member variable).
 * Above constructor.
 * Above method.
 * In front of method's parameter.
 *
 * BUT you can restrict where it can be used by: @Target({METHOD, TYPE, FIELD, PARAMETER, ...})
 *
 * Retention
 *     - SOURCE = only in the code, not in class, not at runtime
 *     - CLASS = info compiled into class files for tools that scan class files instead of source code; not at runtime
 *     - RUNTIME = also available at runtime and you can access it via reflection
 */

//@Documented // javadoc will show it
//@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String name() default "unknown";

    int count() default 0;

    String[] tags() default {"unknown"};

}
