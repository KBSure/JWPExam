package my.examples.miniwas;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {

    /**
     * The name of the servlet
     */
    String name() default "";

    /**
     * The URL patterns of the servlet
     */
    String value() default "";

}
