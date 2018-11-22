package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.Map;

public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数获取long类型值
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(name);
    }
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
