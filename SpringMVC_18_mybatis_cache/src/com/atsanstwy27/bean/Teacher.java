package com.atkjs927.bean;

import java.io.Serializable;
import java.util.Date;

// implements Serializable for Default Cache
// Third-party Cache
public class Teacher {

    private Integer id;
    private String name;
    private String course;
    private String address;
    private Date birth;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String course, String address, Date date) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.address = address;
        this.birth = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return birth;
    }

    public void setDate(Date date) {
        this.birth = date;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", address='" + address + '\'' +
                ", date=" + birth +
                '}';
    }
}
