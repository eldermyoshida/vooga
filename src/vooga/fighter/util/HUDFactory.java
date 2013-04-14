package vooga.fighter.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import vooga.fighter.view.HUDElement;


public class HUDFactory {
    public static List<HUDElement> getHUDElements (Observable gameObject)
                                                                         throws InstantiationException,
                                                                         IllegalAccessException,
                                                                         ClassNotFoundException {
        @SuppressWarnings("rawtypes")
        Class objectClass = gameObject.getClass();

        ArrayList<HUDElement> elements = new ArrayList<HUDElement>();

        for (Field member : objectClass.getDeclaredFields()) {
            for (Annotation a : member.getAnnotations()) {
                if (a.getClass() == HUDVariable.class) {
                    HUDVariable varAnnotation = (HUDVariable) a;
                    String subclass = "HUD" + varAnnotation.HUDElementClass();
                    HUDElement newElement = (HUDElement) Class.forName(subclass).newInstance();
                    newElement.setName(varAnnotation.name());
                    newElement.setObservedValue(member.getName());
                    gameObject.addObserver(newElement);
                    elements.add(newElement);
                }
            }
        }

        return elements;
    }
}
