package org.smart4j.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * POJO 转JSON
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            LOGGER.error("object formatted failed",e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * JSON转换为POJO
     * @param jsonstr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJSON(String jsonstr,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(jsonstr,type);
        } catch (Exception e) {
            LOGGER.error("from json to Object failed！",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
