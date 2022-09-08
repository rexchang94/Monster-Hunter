package com.capcom.mh.model.dto;

import com.capcom.mh.entity.WeaponElement;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class WeaponCreateRequestDto {

    private List<WeaponElement> weaponElements;

    private String name;

    private String slug;

    private String type;

    private Integer rank;

    private Boolean isCloseWeapon;
}
