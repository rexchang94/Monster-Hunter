package com.capcom.mh.service;

import com.capcom.mh.entity.Monster;

public interface MonsterService {

    Monster create(Monster monster);

    Monster findById(Long id);

}
