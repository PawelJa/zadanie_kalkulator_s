package com.calculator.app.entity;

public class Currency {

    private String name;
    private Double course;

    public Currency(String name, Double course ) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }
}
