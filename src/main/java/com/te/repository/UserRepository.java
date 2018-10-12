package com.te.repository;

import com.te.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCase(String username);
    User findByFirstName(String first_name);
    User findByLastName(String last_name);
    User saveEmail(String email);

}
