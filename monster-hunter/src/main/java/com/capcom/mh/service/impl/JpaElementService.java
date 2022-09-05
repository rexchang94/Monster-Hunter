package com.capcom.mh.service.impl;

import com.capcom.mh.entity.Element;
import com.capcom.mh.exception.ItemExistException;
import com.capcom.mh.exception.ResourceNotFoundException;
import com.capcom.mh.repository.ElementRepository;
import com.capcom.mh.service.ElementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaElementService implements ElementsService {
    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Element create(Element element) {
         boolean elementExist = elementRepository.findByName(element.getName()).isPresent();
         if(elementExist) {
            throw  new ItemExistException("Element Already Exist");
         }
        return elementRepository.save(element);
    }

    @Override
    public Element findById(Long id) {
        Element element = elementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ELEMENT ID NOT FOUND"));
        return element;
    }

    @Override
    public Element findByName(String name) {
        return elementRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("ELEMENT NAME NOT FOUND"));
    }
}
