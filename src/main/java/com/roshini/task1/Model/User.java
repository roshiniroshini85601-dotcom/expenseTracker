package com.roshini.task1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @NotBlank
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    private String password;

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}



//dto--> data transfer object  means sending only the required data from database to frontend using java objec
//frontend sends data backend receives it means that is request dto
//backend sends response means that is response dto

