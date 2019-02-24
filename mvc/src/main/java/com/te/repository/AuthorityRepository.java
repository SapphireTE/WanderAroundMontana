package com.te.repository;

import com.te.domain.Authority;
import com.te.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    List<Authority> findAuthoritiesByUserAAndIsDelete(User user,Boolean isDelete); //dsl domain specific language
    List<Authority> findAll();
}
