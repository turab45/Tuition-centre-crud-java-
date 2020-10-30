/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.StudentDAO;
import com.dbmanager.DBConnection;
import com.pojos.Batch;
import com.pojos.Student;
import com.sun.javafx.font.FontResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public class StudentDAOImpl implements StudentDAO{
    

    Connection conn = DBConnection.getConnection();
    
    @Override
    public Integer addStudent(Student student) {
        Integer row = null;
        try {
            String query = "insert into student(student_name,student_phone,student_batch,address) "
                    + "values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getStudentPhone());
            pstmt.setInt(3, student.getStudentBatch().getBatchId());
            pstmt.setString(4, student.getStudentAddress());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("ADD Student Error: "+e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateStudent(Student student) {
        Integer row = null;
        try {
            String query = "update student set student_name=?,student_phone=?,student_batch=?,address=? where student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getStudentPhone());
            pstmt.setInt(3, student.getStudentBatch().getBatchId());
            pstmt.setString(4, student.getStudentAddress());
            pstmt.setInt(5, student.getStudentId());
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update Error: "+e.getMessage());
            e.printStackTrace();
            
        }
        return row;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        Integer row = null;
        try {
            String query = "delete from student where student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
             System.out.println("Update Error: "+e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Student getStudentById(Integer id) {
        ResultSet rs = null;
        Student student = new Student();
        try {
            String quey = "select * from student where student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(quey);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Batch studentBatch = new Batch();
                studentBatch.setBatchId(rs.getInt("student_batch"));
            
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentPhone(rs.getString("student_phone"));
                student.setStudentBatch(studentBatch);
                student.setStudentAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Integer getStudentIdByName(String name) {
        Integer id = null;
        try {
            String query = "select student_id from student where student_name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            
            id = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Student> getAllStudent() {
        ResultSet rs = null;
        List<Student> allStudents = new ArrayList<>();
        try {
            String query = "select * from student";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                Batch studentBatch = new Batch();
                studentBatch.setBatchId(rs.getInt("student_batch"));
            
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentPhone(rs.getString("student_phone"));
                student.setStudentBatch(studentBatch);
                student.setStudentAddress(rs.getString("address"));
            
                allStudents.add(student);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return allStudents;
    }
    
}
