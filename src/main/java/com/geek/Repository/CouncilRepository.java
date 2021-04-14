package com.geek.Repository;

import com.geek.Model.Council;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouncilRepository extends JpaRepository<Council,Integer> {
    Council findByNumber(String number);

    @Query(value = "SELECT * FROM `council` where type = ?1", nativeQuery = true)
    List<Council> findByType(int type);

    @Query(value = "SELECT * FROM council where number = ?1 and type = ?2" , nativeQuery = true)
    Council findBytypeandnumber(String number,int type);

    @Query(value = "select * from council where type = ?1 ORDER  BY agree DESC ",nativeQuery = true)
    List<Council> findBydesctype(int type);

    List<Council> findByOrderByAgreeDesc();

    List<Council> findByOrderByNumberDesc();
}
