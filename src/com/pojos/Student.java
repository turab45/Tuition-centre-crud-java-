/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

/**
 *
 * @author Turab Bajeer
 */
public class Student {
    private int studentId;
    private String studentName;
    private String studentPhone;
    private String studentAddress;
    private Batch studentBatch;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Batch getStudentBatch() {
        return studentBatch;
    }

    public void setStudentBatch(Batch studentBatch) {
        this.studentBatch = studentBatch;
    }
    
    
    
    
}
