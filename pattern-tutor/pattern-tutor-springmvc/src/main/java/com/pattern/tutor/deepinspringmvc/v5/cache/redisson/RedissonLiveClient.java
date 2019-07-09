package com.pattern.tutor.deepinspringmvc.v5.cache.redisson;

import org.redisson.api.RExpirable;
import org.redisson.api.RLiveObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author buildupchao
 * @date 2019-07-08 23:49
 * @since JDK 1.8
 */
@Service
public class RedissonLiveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonLiveClient.class);

    private static final int RETRYLIMIT = 3;

    @Autowired
    private RLiveObjectService rLiveObjectService;

    /**
     * 判断实时对象是否存在
     *
     * @param cacheKey
     * @return
     * @throws Exception
     */
    public <T> boolean isLiveObjectExist(Class<T> tClass, String cacheKey) {
        try {
            T t = getLiveObject(tClass, cacheKey);
            return Optional.ofNullable(t).isPresent();
        } catch (Exception e) {
            LOGGER.error("get live object fail,error:", e);
            return false;
        }
    }

    /**
     * 存储分布式实时对象
     *
     * @param t
     * @return
     * @throws Exception
     */
    public <T> T cacheLiveObject(T t) {
        return rLiveObjectService.persist(t);
    }

    /**
     * 按照key删除redis中的分布式实时对象
     *
     * @param cacheKey
     * @throws Exception
     */
    public <T> void removeLiveObject(Class<T> tClass, String cacheKey) {
        T t = getLiveObject(tClass, cacheKey);
        if (rLiveObjectService.isLiveObject(t)) {
            rLiveObjectService.delete(t);
        }
        rLiveObjectService.delete(tClass, cacheKey);
    }

    /**
     * 获取redis中的分布式实时对象
     *
     * @param cacheKey
     * @return
     * @throws Exception
     */
    public <T> T getLiveObject(Class<T> tClass, String cacheKey) {
        int retry = 0;
        T t = null;
        do {
            try {
                t = rLiveObjectService.get(tClass, cacheKey);
                retry = 0;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                retry++;
                LOGGER.error("getLiveObject retry..." + retry + " time(s)");
            }
        } while (retry > 0 && retry <= RETRYLIMIT);
        return t;
    }


    /**
     * 实时对象设置过期时间
     *
     * @param tClass
     * @param cacheKey
     * @param time
     * @param <T>
     * @throws Exception
     */
    public <T> boolean setLiveObjectExpireTime(Class<T> tClass, String cacheKey, long time) {
        T t = getLiveObject(tClass, cacheKey);
        if (Optional.ofNullable(t).isPresent()) {
            RExpirable re = rLiveObjectService.asRExpirable(t);
            re.expire(time, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断实例是否存在
     *
     * @param instance
     * @param <T>
     * @return
     */
    public <T> boolean isExists(T instance) {
        return rLiveObjectService.isExists(instance);
    }

    /**
     * 附加对象
     *
     * @param detachedObject
     * @param <T>
     * @return
     */
    public <T> T attach(T detachedObject) {
        return rLiveObjectService.attach(detachedObject);
    }
}

