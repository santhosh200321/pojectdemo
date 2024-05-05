package com.example.pojectdemo.Job;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private Long id  ;
    private int salary_Name;
    private String title;

    public Job() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary_Name;
    }

    public void setSalary(int salary) {
        this.salary_Name = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Job(String name, Long id, int salary, String title) {
        this.name = name;
        this.id = id;
        this.salary_Name= salary;
        this.title = title;
    }

}
