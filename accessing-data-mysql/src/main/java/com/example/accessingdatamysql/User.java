package com.example.accessingdatamysql;

import jakarta.persistence.*;
@Entity
public class User{
@TableGenerator(
        name ="api",
        allocationSize = 1,
        initialValue = 1)


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,
    generator="api")
    private Integer id;

    private String name;
    private String email;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}



}
