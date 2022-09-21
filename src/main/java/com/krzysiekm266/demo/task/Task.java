package com.krzysiekm266.demo.task;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;
    @Transient
    private Period taskTime;
    
    public Task() {
        this.beginDate = LocalDate.now();
    }

    public Task(Long id, String name, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.beginDate = LocalDate.now();
        this.endDate = endDate;
    }
    public Task(String name,  LocalDate endDate) {
        this.name = name;
        this.beginDate = LocalDate.now();
        this.endDate = endDate;
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
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public LocalDate setEndDate() {
        return endDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Period getTaskTime() {
        return Period.between(this.beginDate,this.endDate);
    }

   
    @Override
    public String toString() {
        return "Task [begintDate=" + beginDate + ", endDate=" + endDate + ", id=" + id + ", name=" + name + "]";
    }
   
}
