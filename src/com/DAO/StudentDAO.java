/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Student;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public interface StudentDAO {
    public Integer addStudent(Student student);
    public Integer updateStudent(Student student);
    public Integer deleteStudent(Integer id);
    public Student getStudentById(Integer id);
    public Integer getStudentIdByName(String name);
    public List<Student> getAllStudent();
    
}
