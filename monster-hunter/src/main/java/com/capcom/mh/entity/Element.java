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
@Table(name= "ELEMENT")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="ELEMENT")
    private String element;

    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weakness> weaknesses = new ArrayList<>();

}

