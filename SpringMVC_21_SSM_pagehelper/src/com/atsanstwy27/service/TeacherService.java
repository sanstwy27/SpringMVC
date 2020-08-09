package com.atkjs927.service;

import com.atkjs927.bean.Teacher;
import com.atkjs927.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacher(Integer id) {
        return teacherDao.getTeacherById(1);
    }

    public List<Teacher> getAll() {
        return teacherDao.getTeachers();
    }

}
