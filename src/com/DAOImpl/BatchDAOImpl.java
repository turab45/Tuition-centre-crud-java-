/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.BatchDAO;
import com.dbmanager.DBConnection;
import com.pojos.Batch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hsqldb.util.DatabaseManagerSwing;

/**
 *
 * @author Turab Bajeer
 */
public class BatchDAOImpl implements BatchDAO{

    Connection conn = DBConnection.getConnection();
    @Override
    public Integer addBatch(Batch batch) {
        Integer row = null;
        try {
            String query = "insert into batch(batch_name, total_students) values (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, batch.getBatchName());
            pstmt.setInt(2, batch.getTotalStudents());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateBatch(Batch batch) {
        Integer row = null;
        try {
            String query = "update from batch set batch_name=?,total_students=? where batch_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, batch.getBatchName());
            pstmt.setInt(2, batch.getTotalStudents());
            
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update Error: "+e.getMessage());
            e.printStackTrace();
            
        }
        return row;
    }

    @Override
    public Integer deleteBatch(Integer id) {
        Integer row = null;
        try {
            String query = "delete from batch where batch_id = ?";
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
    public Batch getBatchById(Integer id) {
        ResultSet rs = null;
        Batch batch = null;
        try {
            String quey = "select * from batch where batch_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(quey);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
               
                batch = new Batch();
            
                batch.setBatchId(rs.getInt("batch_id"));
                batch.setBatchName(rs.getString("batch_name"));
                batch.setTotalStudents(rs.getInt("total_students"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return batch;
    }

    @Override
    public Integer getBatchIdByName(String name) {
        Integer id = null;
        ResultSet rs = null;
        try {
            String query = "select batch_id from batch where batch_name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
            id = rs.getInt("batch_id");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Batch> getAllBatch() {
        ResultSet rs = null;
        List<Batch> allBatches = new ArrayList<>();
        try {
            String query = "select * from batch";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
                Batch batch = new Batch();
                
                batch.setBatchId(rs.getInt("batch_id"));
                batch.setBatchName(rs.getString("batch_name"));
                 batch.setTotalStudents(rs.getInt("total_students"));
            
              allBatches.add(batch);
            
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return allBatches;
    }
    
}
