package com.capcom.mh.controller;

import com.capcom.mh.entity.Element;
import com.capcom.mh.entity.Monster;
import com.capcom.mh.service.MonsterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Monster's controller")
@RestController
@RequestMapping(value = "/monster")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/nergigante/{id}")
    public String getNergigante(@PathVariable String id){
        return "Nergigante";
    }

    @PostMapping("/")
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster){
        if(monster.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Monster createdMonster = monsterService.create(monster);
        if(createdMonster == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdMonster);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> findMonsterById(@PathVariable Long id){
        if(id == null) {
            ResponseEntity.badRequest().build();
        }
        Monster monster = monsterService.findById(id);
        return ResponseEntity.ok(monster);
    }

}
