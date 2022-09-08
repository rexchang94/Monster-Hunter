package com.capcom.mh.service.impl;

import com.capcom.mh.entity.WeaponElement;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.WeaponElementRepository;
import com.capcom.mh.service.WeaponElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponElementServiceImpl implements WeaponElementService {

    @Autowired
    WeaponElementRepository weaponElementRepository;

    @Override
    public WeaponElement create(WeaponElement weaponElement) {
        return weaponElementRepository.save(weaponElement);
    }

    @Override
    public WeaponElement findById(Long id) {
        return weaponElementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("WEAPON_ELEMENT ID NOT FOUND"));
    }
}
