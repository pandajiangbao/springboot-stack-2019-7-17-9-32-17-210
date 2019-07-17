package com.tw.apistackbase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 50,nullable = false,unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="procuratorate_id")
    private List<Procurator> procuratorList;

    public Procuratorate(String name) {
        this.name = name;
    }

    public Procuratorate(String name, List<Procurator> procuratorList) {
        this.name = name;
        this.procuratorList = procuratorList;
    }
}
