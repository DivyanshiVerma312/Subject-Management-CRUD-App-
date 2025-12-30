package com.example.subjectcrud.entity;

import jakarta.persistence.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectCode;
    private String subjectName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
}
