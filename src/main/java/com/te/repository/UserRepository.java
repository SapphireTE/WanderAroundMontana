package com.te.repository;

import com.te.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCase(String username);

}
