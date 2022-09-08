package com.capcom.mh.controller;

import com.capcom.mh.entity.Element;
import com.capcom.mh.service.ElementsService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
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
    public ResponseEntity<Element> createElement(@RequestBody Element element) {
        Element createdElement = elementsService.create(element);
        if(createdElement == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdElement);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Element> findElementById(@PathVariable Long id) throws Exception {
        if(id == null) {
            ResponseEntity.badRequest().build();
        }
        Element elements = elementsService.findById(id);

        return ResponseEntity.ok(elements);
    }

}
