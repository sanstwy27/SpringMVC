package com.atkjs927.dao;


import com.atkjs927.bean.Teacher;

import java.util.List;

public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeachers();

}
