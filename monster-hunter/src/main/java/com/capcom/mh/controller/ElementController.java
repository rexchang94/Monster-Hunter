package com.capcom.mh.controller;

import com.capcom.mh.entity.Element;
import com.capcom.mh.service.ElementsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Elements controller")
@RestController
@RequestMapping(value = "/elements")
public class ElementController {

    @Autowired
    ElementsService elementsService;

    @PostMapping(value = "")
    public ResponseEntity<Element> createElement(@RequestBody Element element){
        if(element.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Element createdElement = elementsService.create(element);
        if(createdElement == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdElement);
    }

}
