package com.pattern.tutor.deepinspringmvc.v5.cache.redisson.bean;

import com.google.gson.reflect.TypeToken;
import com.pattern.common.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author buildupchao
 * @date 2019-07-09 00:04
 * @since JDK 1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TaskInfo {

    @RId
    private String redisKey;

    private String taskCode;

    private Set<String> dependenceTaskCodeSet;

    public static boolean isFullInfo(TaskInfo taskInfo) {

        if (!Optional.ofNullable(taskInfo).isPresent()) {
            return false;
        }
        String taskInfoJson = JsonUtil.toJson(taskInfo);
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        Map<String, Object> taskInfoMap = JsonUtil.fromJson(taskInfoJson, type);
        if (taskInfoMap.size() < TaskInfo.class.getDeclaredFields().length - 2) {
            return false;
        }
        return true;
    }
}
