package com.maktabsharif.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "teacher_code")
    private long teacherCode;

    @Column
    private Long sallary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail detail;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "address_id")
    private Address address_id;

    @Column
    private LocalDate birthday;



    public void setAddress_id(Address address_id) {
        this.address_id = address_id;
    }


    public Address getAddress_id() {
        return address_id;
    }



    public Teacher() {
    }



    public Teacher(String firstName, String lastName, long teacherCode , LocalDate birthday, long sallary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.birthday = birthday;
        this.sallary = sallary;
    }


    public TeacherDetail getDetail() {
        return detail;
    }

    public void setDetail(TeacherDetail detail) {
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(long teacherCode) {
        this.teacherCode = teacherCode;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                '}';
    }
}
