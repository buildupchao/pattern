package com.pattern.common.utils;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author buildupchao
 * @date 2019-07-08 23:52
 * @since JDK 1.8
 */
public final class JsonUtil {


    /**
     * Null serialize is used because else Gson will ignore all null fields.
     */
    private static Gson gson = new GsonBuilder().create();
    //private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    private static Gson fGson = new GsonBuilder().setPrettyPrinting().create();

    private static JsonParser jsonParser = new JsonParser();

    /**
     * To Json Converter using Goolge's Gson Package
     *
     * this method converts a simple object to a json string
     *
     *
     * @param obj
     * @return a json string
     */
    public static <T> String toJson(final T obj) {
        return gson.toJson(obj);
    }

    /**
     * Converts a map of objects using Google's Gson Package
     *
     * @param map
     * @return a json string
     */
    public static String toJson(final Map<String, ?> map) {
        return gson.toJson(map);
    }

    /**
     * Converts a collection of objects using Google's Gson Package
     *
     * @param list
     * @return a json string array
     */
    public static <T> String toJson(final List<T> list) {
        return gson.toJson(list);
    }

    /**
     * Returns the specific object given the Json String
     *
     * @param <T>
     * @param jsonString
     * @return a specific object as defined by the user calling the method
     */
    public static <T> T fromJson(final String jsonString, final Class<T> classOfT) {
        try {
            return gson.fromJson(jsonString, classOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(final String jsonString, final Type typeOf) {
        try {
            return (T) gson.fromJson(jsonString, typeOf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(final JsonElement jsonElement, final Class<T> classOfT) {
        try {
            return gson.fromJson(jsonElement, classOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> fromJsonToList(final JsonArray jsonArray, final Class<T> classOfT) {
        List<T> list = new ArrayList<T>();

        for (int i = 0, size = jsonArray.size(); i < size; i++) {
            list.add(gson.fromJson(jsonArray.get(i), classOfT));
        }

        return list;
    }

    /**
     * Returns a list of specified object from the given json array
     *
     * @param <T>
     * @param jsonString
     * @param type
     *            the type defined by the user
     * @return a list of specified objects as given in the json array
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> fromJsonToList(final String jsonString, final Type type) {
        try {
            List<T> results = Lists.newArrayList();
            JsonArray jsonElements = toJsonArray(jsonString);
            for (JsonElement jsonElement : jsonElements) {
                results.add(gson.fromJson(jsonElement, type));
            }
//            return (List<T>) gson.fromJson(jsonString, type);
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a list of specified object from the given json reader
     *
     * @param <T>
     * @param json
     * @param type
     *            the type defined by the user
     * @return a list of specified objects as given in the json array
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(final JsonReader json, final Type type) {
        try {
            return (T) gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatJson(String json) {
        JsonElement je = jsonParser.parse(json);
        return fGson.toJson(je);
    }

    public static JsonArray toJsonArray(String json){
        return jsonParser.parse(json).getAsJsonArray();
    }
    public static JsonObject toJsonObject(String json){
        return jsonParser.parse(json).getAsJsonObject();
    }

}
