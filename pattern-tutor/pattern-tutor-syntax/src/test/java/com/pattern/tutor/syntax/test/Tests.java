package com.pattern.tutor.syntax.test;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author buildupchao
 * @date: 2019/4/10 22:23
 * @since JDK 1.8
 */
public class Tests {

    public static void main(String[] args) {
        ArrayList<TaskQueueInfo> taskQueueInfos = Lists.newArrayList(
                TaskQueueInfo.builder().priority(2).millis(1000).build(),
                TaskQueueInfo.builder().priority(5).millis(1000).build(),
                TaskQueueInfo.builder().priority(2).millis(2000).build()
        );
        PriorityBlockingQueue<TaskQueueInfo> taskQueue = new PriorityBlockingQueue<>();
        for (TaskQueueInfo taskQueueInfo : taskQueueInfos) {
            taskQueue.offer(taskQueueInfo);
        }
        System.out.println(taskQueue.poll());
        System.out.println(taskQueue.poll());
        System.out.println(taskQueue.poll());
    }

    @Data
    @Builder
    public static class TaskQueueInfo implements Comparable<TaskQueueInfo> {

        private int priority;

        private long millis;

        @Override
        public int compareTo(TaskQueueInfo queueInfo) {

            int result = 0;
            if (this.priority == queueInfo.priority) {
                result = 0;
            } else if (this.priority > queueInfo.priority) {
                result = -1;
            } else {
                result = 1;
            }
            if (result == 0) {
                if (this.millis == queueInfo.millis) {
                    return 0;
                } else if (this.millis < queueInfo.millis) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return result;
            }
        }
    }
}
