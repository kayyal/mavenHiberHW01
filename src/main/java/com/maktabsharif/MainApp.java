package com.maktabsharif;

import com.maktabsharif.model.Address;
import com.maktabsharif.model.Teacher;
import com.maktabsharif.model.dao.TeacherDAO;
import com.maktabsharif.model.dao.TeacherDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Teacher teacher01 = new Teacher("john", "doe", 123234234, LocalDate.of(1234,12,1) , 213234345);
        Teacher teacher02 = new Teacher("David", "flan", 456475672, LocalDate.of(1234,12,1) , 456234);
        Teacher teacher03 = new Teacher("Taghi", "doe", 678789424, LocalDate.of(1234,12,1) , 234324);
        Teacher teacher04 = new Teacher("Hasan", "doe", 567234775, LocalDate.of(1234,12,1) , 23423234);
        Address address01 = new Address("Tehran" , "Tehran" , 347017254);
        Address address02 = new Address("Mashhad" , "Khorasan" , 34797254);
        Address address03 = new Address("Ghazvin" , "Ghazvin" , 347657254);
        teacher01.setAddress_id(address01);
        teacher02.setAddress_id(address02);
        teacher03.setAddress_id(address03);
//        teacher04.setAddress_id(address01);

//        TeacherDAO teacherDaoImpl = new TeacherDaoImpl(factory);
//
//        System.out.println(teacherDaoImpl.getByadress());
//        System.out.println("Hello");
//

        session.save(teacher01);
        session.save(teacher02);
        session.save(teacher03);
        session.save(teacher04);
        session.getTransaction().commit();

        session.close();
        factory.close();


//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//
////        TeacherDAO teacherDao = new TeacherDaoImpl(factory);
//        TeacherDAO teacherDaoImpl = new TeacherDaoImpl(factory);
//
//        Teacher teacher = new Teacher("john", "doe", 123234234, LocalDate.of(1234,12,1) , 213234345);
//
//
//        factory.close();
    }
}
