package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Weapon;
import com.capcom.mh.entity.WeaponElement;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.WeaponRepository;
import com.capcom.mh.service.ElementsService;
import com.capcom.mh.service.WeaponElementService;
import com.capcom.mh.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaWeaponServiceImpl implements WeaponService {

    @Autowired
    WeaponRepository weaponRepository;

    @Autowired
    WeaponElementService weaponElementService;

    @Autowired
    ElementsService elementsService;

    @Override
    public Weapon create(Weapon weapon) {
        Weapon weaponCreated = weaponRepository.save(weapon);
        if(weapon.getWeaponElements() != null && weapon.getWeaponElements().size() > 0){
            List<WeaponElement> weaponElementList = new ArrayList<>();
            for(WeaponElement weaponElement : weapon.getWeaponElements()){
                weaponElement.setWeapon(weaponCreated);
                weaponElementList.add(weaponElementService.create(weaponElement));
            }
            weaponCreated.setWeaponElements(weaponElementList);
        }
        return weaponCreated;
    }

    @Override
    public Weapon findById(Long id) {
        Weapon weapon = weaponRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("WEAPON ID NOT FOUND"));
        return weapon;
    }
}
