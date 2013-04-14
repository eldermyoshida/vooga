package vooga.fighter.util;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
public @interface HUDVariable {
    public String name();

    public String HUDElementClass();
}
