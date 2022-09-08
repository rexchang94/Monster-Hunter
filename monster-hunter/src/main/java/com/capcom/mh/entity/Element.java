package com.capcom.mh.entity;

import com.capcom.mh.validation.ListValue;
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
@Table(name= "ELEMENTS")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    @ListValue({"fire","water","ice","thunder","dragon"})
    private String name;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weakness> weaknesses;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<WeaponElement> weaponElements;

}

