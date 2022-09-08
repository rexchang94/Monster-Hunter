package com.capcom.mh.controller;

import com.capcom.mh.entity.Weapon;
import com.capcom.mh.service.WeaponService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Weapon Controller")
@RestController
@RequestMapping(value = "/weapons")
public class WeaponController {

    @Autowired
    WeaponService weaponService;

    @PostMapping(value = "")
    public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon) {
        Weapon createdWeapon = weaponService.create(weapon);
        if(createdWeapon == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weapon);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Weapon> findWeaponById(@PathVariable Long id) {
        if(id == null) {
            ResponseEntity.badRequest().build();
        }

        Weapon weapon = weaponService.findById(id);

        return ResponseEntity.ok(weapon);
    }

}
