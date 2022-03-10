package com.healthcare.healthcareservice.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Example {
    @Id
    private int id;

    private String name;

    public Example(){
        
    }

    public Example(int id2, String name2) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
}
