package com.maktabsharif.model;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_details")
public class TeacherDetail implements Serializable {

    private Long id;
    private String name;
    private String code;

    public TeacherDetail() {
    }

    public TeacherDetail(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
