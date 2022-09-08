package com.capcom.mh.repository;

import com.capcom.mh.entity.WeaponElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponElementRepository extends JpaRepository<WeaponElement, Long> {
}
