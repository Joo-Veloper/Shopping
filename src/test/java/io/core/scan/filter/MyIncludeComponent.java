package io.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)// Type -> class Lavel에 붙는다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
