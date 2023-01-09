package com.mohakgemini.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user111")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;

}
