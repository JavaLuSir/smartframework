package org.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

        if (CollectionUtils.isNotEmpty(controllerClassSet)) {
            for (Class controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Action.class)) {
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        if (mapping.matches("\\w+:/\\w*")) {
                            String[] arrys = mapping.split(":");
                            if(ArrayUtils.isNotEmpty(arrys)&&arrys.length==2){
                                String requestMethod = arrys[0];
                                String requestPath = arrys[1];
                                Request request = new Request(requestMethod,requestPath);
                                Handler handler = new Handler(controllerClass,method);
                                ACTION_MAP.put(request,handler);
                            }
                        }
                    }
                }
            }
        }
    }

   public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
   }
}
