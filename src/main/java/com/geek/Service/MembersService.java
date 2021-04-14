package com.geek.Service;

import com.geek.Model.Members;
import com.geek.Repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

    @Autowired
    private MembersRepository membersRepository;


    public Members checkMembers(String number){
        Members members = membersRepository.findByNumber(number);
        return members;

    }



}
