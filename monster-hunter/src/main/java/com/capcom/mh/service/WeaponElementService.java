package com.capcom.mh.service;

import com.capcom.mh.entity.WeaponElement;

public interface WeaponElementService {

    WeaponElement create(WeaponElement weaponElement);

    WeaponElement findById(Long id);

}
