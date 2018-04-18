package com.spring.example.login.domain;

import javax.persistence.*;

@Entity
@Table(name="usertbl")
public class UserAccount {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
