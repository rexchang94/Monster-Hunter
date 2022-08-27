package com.capcom.mh.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MONSTERS")
public class Monsters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_LARGE")
    private Boolean isLarge;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "INFO")
    private String info;

    @Column(name = "DANGER")
    private Integer Danger;

    @OneToMany(mappedBy = "monsters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weakness> weaknesses = new ArrayList<>();

}



