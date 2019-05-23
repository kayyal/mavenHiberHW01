package com.maktabsharif.model.dao;

import com.maktabsharif.core.dao.BaseDAO;
import com.maktabsharif.model.Teacher;

import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {

    List<Teacher> getByadress();
}
