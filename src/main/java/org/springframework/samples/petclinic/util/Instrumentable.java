package org.springframework.samples.petclinic.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to decorate methods or classes that will be instrumented by the @link(LogAspect)
 * 
 * @author hoserdude
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Instrumentable {

}
