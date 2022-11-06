package com.will.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Jackson工具类
 * @author Will.WT
 * @date 2022/11/01 15:39
 */
public class JacksonHelper {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // 设置时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 反序列化-忽略未知的json字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 序列化-Date转String
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 序列化-不包含null字段
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 序列化-空对象转json时不抛异常
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }


    public static ObjectMapper getInstance(){
        return objectMapper;
    }

    /**
     * 序列化
     * @param src
     * @return
     */
    public static String toJson(Object src){
        try {
            return objectMapper.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toByte(Object src){
        try {
            return objectMapper.writeValueAsBytes(src);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 反序列化
     * @param json
     * @return
     */
    public static Map<String, Object> fromJsonMap(String json){
        try {
            return objectMapper.readValue(json,
                            new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map<String, Object>> fromJsonList(String json){
        try {
            return objectMapper.readValue(json,
                            new TypeReference<List<Map<String, Object>>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> valueType){
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
