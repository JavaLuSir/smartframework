package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();
    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass:beanClassSet){
            Object obj  = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }
    /**
     * 获取Bean映射
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取bean实例
     * @param clas
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clas){
        if(!BEAN_MAP.containsKey(clas)){
            throw new RuntimeException("can not get bean by class:"+clas);
        }
        return (T)BEAN_MAP.get(clas);
    }

    public static void setBean(Class<?> cls,Object object){
        BEAN_MAP.put(cls,object);
    }
}
