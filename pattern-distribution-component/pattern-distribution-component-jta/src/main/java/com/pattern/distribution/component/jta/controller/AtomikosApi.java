package com.pattern.distribution.component.jta.controller;

import java.sql.Timestamp;
import java.time.Instant;

import javax.annotation.Resource;

import com.pattern.distribution.component.jta.domain.User;
import com.pattern.distribution.component.jta.repository.primary.UserPrimaryRepository;
import com.pattern.distribution.component.jta.repository.secondary.UserSecondaryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author buildupchao
 * @date 2019/12/08 19:44
 * @since JDK 1.8
 */
@RestController
public class AtomikosApi {

    @Resource
    private UserPrimaryRepository userPrimaryRepository;

    @Resource
    private UserSecondaryRepository userSecondaryRepository;

    @Transactional
    @RequestMapping(value = "/user/action/save", method = {RequestMethod.POST, RequestMethod.GET})
    public String save() {
        Timestamp regTime = Timestamp.from(Instant.now());
        userPrimaryRepository.save(new User("aa", "aa123456", "aa@foxmail.com", "naa", regTime));
        userPrimaryRepository.save(new User("bb", "bb123456", "bb@foxmail.com", "nbb", regTime));
        userSecondaryRepository.save(new User("cc", "cc123456", "cc@foxmail.com", "ncc", regTime));
        return "Save success!";
    }

    @Transactional
    @RequestMapping(value = "/user/action/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete() {
        userPrimaryRepository.deleteAll();
        userSecondaryRepository.deleteAll();
        if (true) {
            throw new RuntimeException("test RuntimeException");
        }

        return "delete all";
    }


    @Transactional
    @RequestMapping(value = "/user/action/delete/quickly", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteDirectly() {
        userPrimaryRepository.deleteAll();
        userSecondaryRepository.deleteAll();
        return "delete all";
    }
}
