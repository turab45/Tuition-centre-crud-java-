/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Batch;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public interface BatchDAO {
    public Integer addBatch(Batch batch);
    public Integer updateBatch(Batch batch);
    public Integer deleteBatch(Integer id);
    public Batch getBatchById(Integer id);
    public Integer getBatchIdByName(String name);
    public List<Batch> getAllBatch();
}
