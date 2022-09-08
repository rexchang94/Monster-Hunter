package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Element;
import com.capcom.mh.entity.Weapon;
import com.capcom.mh.entity.WeaponElement;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.WeaponRepository;
import com.capcom.mh.service.ElementsService;
import com.capcom.mh.service.WeaponElementService;
import com.capcom.mh.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        for(WeaponElement weaponElement :weapon.getWeaponElements()){
//            Element element = elementsService.findByName(weaponElement.getElement().getName());
//            weaponElement.setElement(element);
//
//        }

        Weapon weaponCreated = weaponRepository.save(weapon);
        return weaponCreated;
    }

    @Override
    public Weapon findById(Long id) {
        Weapon weapon = weaponRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("WEAPON ID NOT FOUND"));
        return weapon;
    }
}
