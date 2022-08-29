package com.capcom.mh.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MONSTER")
public class Monster {

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

    @OneToMany(mappedBy = "monster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weakness> weaknesses = new ArrayList<>();


}



