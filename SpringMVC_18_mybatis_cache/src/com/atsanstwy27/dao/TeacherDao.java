package com.atkjs927.dao;

import com.atkjs927.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher teacher);

    //public List<Teacher> getTeacherByIdIn(List<Integer> ids);
    public List<Teacher> getTeacherByIdIn(@Param("ids")List<Integer> ids);

    public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

    public int updateTeacher(Teacher teacher);
}
