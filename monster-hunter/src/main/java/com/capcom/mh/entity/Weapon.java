package com.capcom.mh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WEAPONS")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "weapon", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    @Column(name="NAME")
    private String name;

    @Column(name="SLUG")
    private String slug;

    @Column(name="TYPE")
    private String type;

    @Column(name="RANK")
    private Integer rank;

    @Column(name="IS_CLOSE_WEAPON")
    private Boolean isCloseWeapon;
}
