package com.capcom.mh.repository;

import com.capcom.mh.entity.WeaponElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponElementRepository extends JpaRepository<WeaponElement, Long> {
    List<WeaponElement> findAllByWeaponIs(Long id);
}
