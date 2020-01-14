package com.pattern.distribution.component.jta.repository.secondary;

import com.pattern.distribution.component.jta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author buildupchao
 * @date 2019/12/08 19:44
 * @since JDK 1.8
 */
@Repository
public interface UserSecondaryRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);
}