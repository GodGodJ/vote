package com.geek.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`check`")
public class Check {

    @Id
    private String number; //判断是否投过票

    public Check(String number){
        this.number = number;
    }

    public Check(){

    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
