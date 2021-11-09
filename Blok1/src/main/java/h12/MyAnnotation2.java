package h12;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Inherited
public @interface MyAnnotation2 {
    String value() default "Hello2";
}
