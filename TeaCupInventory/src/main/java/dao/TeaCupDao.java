/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TeaCups;

import java.util.List;

/**
 *
 * @author keelybrennan
 */
public interface TeaCupDao {
 
    public void createTeaCup(TeaCups newTeaCup);
    
    List<TeaCups> getAllTeaCups();
    TeaCups getName(String name);

}
