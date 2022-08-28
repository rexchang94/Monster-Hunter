package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Element;
import com.capcom.mh.model.ElementRepository;
import com.capcom.mh.service.ElementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaElementService implements ElementsService {
    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Element create(Element element) {
        return elementRepository.save(element);
    }
}
