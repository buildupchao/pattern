package com.pattern.tutor.syntax.database.util;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Slf4j
public class FilterUselessTaskInfo {

    private volatile LinkedHashSet<String> data = new LinkedHashSet<>();
    private static final String OUTPUT = "/src/main/resources/database/ids_result";

    public static void main(String[] args) throws Exception {
        String base = System.getProperty("user.dir") + "/pattern-tutor/pattern-tutor-syntax";
        List<String> filter = Files.readAllLines(Paths.get(base, "/src/main/resources/database/ids2"));
        HashSet<String> filterValues = Sets.newHashSet(filter);
        List<String> originDatas = Files.readAllLines(Paths.get(base, "/src/main/resources/database/ids1"));

        FileOutputStream out = new FileOutputStream(new File(base + OUTPUT));
        originDatas.stream().map(v -> {
            String taskIdStr = v.split("_")[3];
            System.out.println(taskIdStr + "   ->    " + filterValues.contains(taskIdStr));
            if (!filterValues.contains(taskIdStr)) {
                return "delete /escheduler/tasks_queue/" + v;
            }
            return null;
        }).filter(StringUtils::isNotBlank)
                .forEach(v -> {
                    try {
                        out.write((v + "\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("DONE______________________");
    }
}
