package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Monster;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.MonsterRepository;
import com.capcom.mh.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaMonsterService implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public Monster create(Monster monster) {
        return monsterRepository.save(monster);
    }

    public Monster findById(Long id) {
        return monsterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MONSTER ID NOT FOUND"));
    }


}
