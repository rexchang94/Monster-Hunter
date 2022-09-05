package com.capcom.mh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @OneToMany(mappedBy = "weapon", cascade = CascadeType.PERSIST)
    private List<WeaponElement> weaponElements;

    @Column(name="NAME")
    @NotNull
    private String name;

    @Column(name="SLUG")
    @NotNull
    private String slug;

    @Column(name="TYPE")
    @NotNull
    private String type;

    @Column(name="RANK")
    @NotNull
    private Integer rank;

    @Column(name="IS_CLOSE_WEAPON")
    @NotNull
    private Boolean isCloseWeapon;
}
