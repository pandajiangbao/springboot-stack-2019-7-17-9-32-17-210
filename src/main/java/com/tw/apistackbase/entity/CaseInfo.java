package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String subjective;
    @Column(nullable = false)
    private String objectivity;

    public CaseInfo(String subjective, String objectivity) {
        this.subjective = subjective;
        this.objectivity = objectivity;
    }
}
