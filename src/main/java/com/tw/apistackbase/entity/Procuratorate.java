package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 50,nullable = false,unique = true)
    private String name;

    public Procuratorate(String name) {
        this.name = name;
    }
}
