package com.example.subjectcrud.controller;

import com.example.subjectcrud.entity.Subject;
import com.example.subjectcrud.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectRestController {

    private final SubjectService service;

    public SubjectRestController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return service.save(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject subject) {
        return service.update(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
