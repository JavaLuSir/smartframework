package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将URL编码
     */
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("encode url failed",e);
            throw new RuntimeException(e);
        }
        return target;
    }
    /**
     * 将URL解码
     */
    public static String decodeURL(String source){
        String target;
        try {
            target=URLDecoder.decode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("decode url failed ",e);
            throw new RuntimeException(e);
        }
        return target;

    }

}
