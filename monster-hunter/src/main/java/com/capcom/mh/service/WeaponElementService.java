package com.capcom.mh.service;

import com.capcom.mh.entity.WeaponElement;

import java.util.List;

public interface WeaponElementService {

    WeaponElement create(WeaponElement weaponElement);

    WeaponElement findById(Long id);

    List<WeaponElement> findWeaponElementsByWeaponId(Long weapon_Id);

}
