package com.capcom.mh.repository;

import com.capcom.mh.entity.Element;
import com.capcom.mh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {

    Optional<Element> findByName(String name);
}
