package com.tw.apistackbase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long time;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "info_id", referencedColumnName = "id")
    private CaseInfo info;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "procuratorate_id", referencedColumnName = "id",nullable = false)
    private Procuratorate procuratorate;

    public Case(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    public Case(String name, Long time, CaseInfo info) {
        this.name = name;
        this.time = time;
        this.info = info;
    }

    public Case(String name, Long time, Procuratorate procuratorate) {
        this.name = name;
        this.time = time;
        this.procuratorate = procuratorate;
    }
}
