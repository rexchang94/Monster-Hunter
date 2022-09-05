package com.capcom.mh.service;

import com.capcom.mh.entity.Element;
import javassist.NotFoundException;

public interface ElementsService {

    Element create(Element element);

    Element findById(Long id) throws Exception;

    Element findByName(String name);
}
