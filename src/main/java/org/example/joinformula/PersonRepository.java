package org.example.joinformula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "SELECT p FROM Person p")
    List<Person> get();

    @Query(value = "SELECT p.* FROM Person p", nativeQuery = true)
    List<Person> getNative();
}
