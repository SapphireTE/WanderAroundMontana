package com.te.repository;

import com.te.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> { // -- interface
    User findByUsernameIgnoreCase(String username);
//    User createUser(Long user);
//    Optional<User> findById(Long Id);
    List<User> findByFirstNameIgnoreCase(String username);

    Optional<User> findByEmailIgnoreCase(String email);

    List<User> findAll();

    List<User> findByLastName (String lastName);



//    Optional<User> setDateOfBirth (LocalDate dateOfBirth);

//    Optional<User> deleteUserByUsername(String user);

//    @Query("Select c from #{#entityName} c LEFT JOIN FETCH c.images")
//    List<User> findAllWithImages();

//    Optional<User> find
}



