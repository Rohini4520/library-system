package com.acciojob.library_system.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer StudentId;

    private String name;

    private Integer age;

    private String branch;

    @Column(unique = true,length = 300)
    private String emailId;

    private String address;
}


