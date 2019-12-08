package com.pattern.distribution.component.jta.repository.primary;

import com.pattern.distribution.component.jta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author buildupchao
 * @date 2019/12/08 19:43
 * @since JDK 1.8
 */
@Repository
public interface UserPrimaryRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);
}