package com.maktabsharif.model.dao;

import com.maktabsharif.core.dao.BaseDaoImpl;
import com.maktabsharif.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDAO {


    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntityName() {
        return "Teacher";
    }


    public List<Teacher> getByadress() {
        List <Teacher>  teachers  ;

        Session session = factory.openSession();
        session.beginTransaction();

        teachers =  session.createQuery("select t  from Teacher t inner join Address a on t.address_id.id= a.id where a.province= 'Tehran'" , Teacher.class ).getResultList();

        session.getTransaction().commit();
        session.close();

        return teachers;

    }

    

    public void removeByTeacherId(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();



        session.createQuery("\"delete from \" + getEntityName() + \"as entity where entity.teacher_code =\" + id");


        session.getTransaction().commit();
        session.close();
    }

    protected ArrayList<Teacher> findYoungOld() {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Session session = factory.openSession();

        Object singleResult = session.createQuery("from Teacher t order by t.birthday").setMaxResults(1).getSingleResult();
        teachers.add((Teacher) singleResult);

        Object singleResult01 = session.createQuery("from Teacher t order by t.birthday desc").setMaxResults(1).getSingleResult();

        teachers.add((Teacher) singleResult01);

        session.close();

        return teachers;
    }

    protected ArrayList<Teacher> findPoorRich() {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Session session = factory.openSession();

        Object singleResult = session.createQuery("from Teacher t order by t.sallary").setMaxResults(1).getSingleResult();
        teachers.add((Teacher) singleResult);

        Object singleResult01 = session.createQuery("from Teacher t order by t.sallary desc").setMaxResults(1).getSingleResult();

        teachers.add((Teacher) singleResult01);


        session.close();

        return teachers;
    }

}
