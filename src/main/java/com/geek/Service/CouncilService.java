package com.geek.Service;

import com.geek.Model.Council;
import com.geek.Repository.CouncilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouncilService {

    @Autowired
    private CouncilRepository councilRepository;

    public List<Council> finAll(){
        return councilRepository.findAll();
    }

    public Council findByNumber(String number){
        return councilRepository.findByNumber(number);
    }


    public List<Council> findAllByNumber(){
        return councilRepository.findByOrderByNumberDesc();
    }

    public void addAgree(String number,int type){
        Council council1 =  councilRepository.findBytypeandnumber(number,type);
        int agree = council1.getAgree();
        council1.setAgree(agree+1);
        councilRepository.save(council1);
    }

    public void addAginst(String number,int type){
        Council council = councilRepository.findBytypeandnumber(number,type);
        int against = council.getAgainst();
        council.setAgainst(against+1);
        councilRepository.save(council);
    }

    public void addawaiver(String number,int type){
        Council council = councilRepository.findBytypeandnumber(number,type);
        int awaiver = council.getAwaiver();
        council.setAwaiver(awaiver+1);
        councilRepository.save(council);
    }

    public List<Council> findbytypedesc(int type){
        return councilRepository.findBydesctype(type);
    }

    public List<Council> findbytype(int type){
        return councilRepository.findByType(type);
    }




}
