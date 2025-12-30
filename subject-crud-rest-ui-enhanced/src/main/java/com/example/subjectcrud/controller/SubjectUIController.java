package com.example.subjectcrud.controller;

import com.example.subjectcrud.entity.Subject;
import com.example.subjectcrud.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectUIController {

    private final SubjectService service;

    public SubjectUIController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("subjects", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subject", new Subject());
        return "add-subject";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subject subject) {
        service.save(subject);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("subject", service.getAll().stream()
                .filter(s -> s.getId().equals(id)).findFirst().orElseThrow());
        return "edit-subject";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
