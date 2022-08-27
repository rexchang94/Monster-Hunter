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
public class Elements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="ELEMENT")
    private String element;

    @OneToMany(mappedBy = "elements", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weakness> weaknesses = new ArrayList<>();

}

