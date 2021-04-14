package com.geek.Repository;

import com.geek.Model.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CheckRepository extends JpaRepository<Check,String> {
    @Query(value = "SELECT * FROM `check` where number = ?1", nativeQuery = true)
     Optional<Check> findByNumber(String number);
}
