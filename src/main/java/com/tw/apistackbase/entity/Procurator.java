package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Procurator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String name;

    @Column(name = "procuratorate_id",nullable = true)
    private Integer procuratorateId;
    public Procurator(String name) {
        this.name = name;
    }
}
