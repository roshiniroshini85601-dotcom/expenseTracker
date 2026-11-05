package com.roshini.task1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.NonNull;
import jakarta.validation.constraints.NotEmpty;
//here we are performing encapsulation because we are keeping details private so that
//private hides the variable. Getter reads the hidden variable. Setter changes the hidden variable.

@Entity
public class Expense {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NotEmpty
    private String name;
    @NonNull
    private Integer amount;

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setAmount(Integer amount){
        this.amount=amount;
    }
    public Integer getAmount(){
        return amount;
    }


}
