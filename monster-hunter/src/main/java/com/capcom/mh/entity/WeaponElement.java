package com.capcom.mh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "WEAPON_ELEMENTS")
public class WeaponElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "element_id")
    private Element element;

    @Column
    @NotNull
    private Integer value;

}
