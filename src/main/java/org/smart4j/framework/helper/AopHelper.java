package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Aspect;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class AopHelper {

    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception{
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if(annotation !=null&&!annotation.equals(Aspect.class)){
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }
}
