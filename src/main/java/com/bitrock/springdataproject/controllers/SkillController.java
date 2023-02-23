package com.bitrock.springdataproject.controllers;

import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping
    ResponseEntity<List<Skill>> getAllWithMoreThanOneEmployee() {
        return new ResponseEntity<>(skillService.getAllWithMoreThanOneEmployee(), HttpStatus.OK);
    }
}
