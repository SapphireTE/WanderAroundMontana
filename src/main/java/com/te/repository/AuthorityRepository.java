package com.te.repository;

import com.te.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Authority findAuthorityByUser(String name);
}
