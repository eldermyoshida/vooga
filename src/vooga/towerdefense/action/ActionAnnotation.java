package vooga.towerdefense.action;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ActionAnnotation {
    public String name();
    public String value();
}