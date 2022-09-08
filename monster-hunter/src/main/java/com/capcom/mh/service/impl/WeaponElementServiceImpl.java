package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Element;
import com.capcom.mh.entity.WeaponElement;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.WeaponElementRepository;
import com.capcom.mh.service.ElementsService;
import com.capcom.mh.service.WeaponElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponElementServiceImpl implements WeaponElementService {

    @Autowired
    WeaponElementRepository weaponElementRepository;

    @Autowired
    ElementsService elementsService;

    @Override
    public WeaponElement create(WeaponElement weaponElement) {
        Element element = elementsService.findByName(weaponElement.getElement().getName());
        if(element == null) {
            throw new ResourceNotFoundException("Element name now found");
        }
        return weaponElementRepository.save(weaponElement);
    }

    @Override
    public WeaponElement findById(Long id) {
        return weaponElementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("WEAPON_ELEMENT ID NOT FOUND"));
    }

    @Override
    public List<WeaponElement> findWeaponElementsByWeaponId(Long weaponId) {
        return weaponElementRepository.findAllByWeaponIs(weaponId);
    }
}
