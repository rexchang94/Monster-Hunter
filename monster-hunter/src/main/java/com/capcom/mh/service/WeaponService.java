package com.capcom.mh.service;

import com.capcom.mh.entity.Weapon;
import org.springframework.stereotype.Service;

public interface WeaponService {

    Weapon create(Weapon weapon);

    Weapon findById(Long id);
}
