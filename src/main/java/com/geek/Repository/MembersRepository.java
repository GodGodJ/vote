package com.geek.Repository;

import com.geek.Model.Members;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembersRepository extends JpaRepository<Members,String> {

    Members findByNumber(String number);
}
