package com.pattern.tutor.deepinspringmvc.v5.cache.redisson;

import com.google.common.collect.Sets;
import com.pattern.tutor.deepinspringmvc.v5.cache.redisson.bean.TaskInfo;
import org.apache.commons.collections.CollectionUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author buildupchao
 * @date 2019-07-08 23:08
 * @since JDK 1.8
 */
@ComponentScan
public class RedissonLockExamples {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonLockExamples.class);

    private static RedissonClient redissonClient;

    private static RedissonLiveClient redissionLiveClient;

    public static void main(String[] args) {

        // start spring container
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedissonLockExamples.class);

        // init bean
        redissonClient = ctx.getBean(RedissonClient.class);
        redissionLiveClient = ctx.getBean(RedissonLiveClient.class);

        // do business
        RedissonLockExamples examples = new RedissonLockExamples();

        String taskCode = "test0123";
        Set<String> dependenceTaskCodeSet = Sets.newHashSet("subTask001", "subTask002");


        for (int i = 0; i < 300; i++) {
        	String redisKey = "TASK-" + taskCode;
        	if (redissionLiveClient.isLiveObjectExist(TaskInfo.class, redisKey)) {
        		redissionLiveClient.removeLiveObject(TaskInfo.class, redisKey);
        	}

        	TaskInfo taskInfo = TaskInfo.builder()
	                .redisKey(redisKey)
	                .taskCode(taskCode)
	                .dependenceTaskCodeSet(dependenceTaskCodeSet)
	                .build();
	        redissionLiveClient.cacheLiveObject(taskInfo);
	
	        for (String subTaskCode : dependenceTaskCodeSet) {
	            new Thread(() -> {
	                examples.testRepeatWriteData(taskCode, subTaskCode);
	            }, "consumer-" + subTaskCode).start();
	        }
        }

//        ctx.close();
    }

    public void testRepeatWriteData(String taskCode, String childTaskCode) {
        String redisKey = "TASK-" + taskCode;

        String lockKey = "composite-task-lock-" + taskCode;
        RLock lock = redissonClient.getLock(lockKey);
        try {
            boolean res = lock.tryLock(2, 8, TimeUnit.SECONDS);

            if (res) {
                if (!redissionLiveClient.isLiveObjectExist(TaskInfo.class, redisKey)) {
                    LOGGER.error("task: {} not exist!", taskCode);
                    return;
                }

                TaskInfo taskInfo = redissionLiveClient.getLiveObject(TaskInfo.class, redisKey);

                if (!TaskInfo.isFullInfo(taskInfo)) {
                    LOGGER.error("task [taskCode={}, taskInfo={}] info not full!", taskCode, taskInfo);
                    redissionLiveClient.removeLiveObject(TaskInfo.class, redisKey);
                    return;
                }

                Set<String> dependenceTaskCodeSet = taskInfo.getDependenceTaskCodeSet();
                dependenceTaskCodeSet.remove(childTaskCode);

                if (CollectionUtils.isNotEmpty(dependenceTaskCodeSet)) {
                    TaskInfo newTaskInfo = TaskInfo.builder()
                            .redisKey(redisKey)
                            .taskCode(taskCode)
                            .dependenceTaskCodeSet(dependenceTaskCodeSet)
                            .build();
                    redissionLiveClient.removeLiveObject(TaskInfo.class, redisKey);
                    redissionLiveClient.cacheLiveObject(newTaskInfo);
                    redissionLiveClient.setLiveObjectExpireTime(TaskInfo.class, redisKey, 24 * 60 * 60 * 1000);
                    return;
                } else {
                    LOGGER.info("save data into db.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("task consume fail, error: {}", ex);
        } finally {
            lock.unlock();
        }
    }
}
