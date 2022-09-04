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
@Table(name= "ELEMENTS")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="ELEMENT")
    private String element;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WEAKNESS_ID", referencedColumnName = "id")
    private Weakness weakness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="WEAPON_ID")
    private Weapon weapon;

}

