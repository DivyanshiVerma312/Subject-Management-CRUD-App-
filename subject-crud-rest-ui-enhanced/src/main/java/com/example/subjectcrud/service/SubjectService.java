package com.example.subjectcrud.service;

import com.example.subjectcrud.entity.Subject;
import com.example.subjectcrud.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repo;

    public SubjectService(SubjectRepository repo) {
        this.repo = repo;
    }

    public List<Subject> getAll() {
        return repo.findAll();
    }

    public Subject save(Subject subject) {
        return repo.save(subject);
    }

    public Subject update(Long id, Subject subject) {
        Subject s = repo.findById(id).orElseThrow();
        s.setSubjectCode(subject.getSubjectCode());
        s.setSubjectName(subject.getSubjectName());
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
