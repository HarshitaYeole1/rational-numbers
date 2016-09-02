package RationalNumbers;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.annotation.Documented;

/**
 * Created by harshita on 31/8/16.
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMe {

}
