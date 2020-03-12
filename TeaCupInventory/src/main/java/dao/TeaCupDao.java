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
    List<TeaCups> getAllTeaCups() throws TeaCupPersistenceException;
    TeaCups getName(String name) throws TeaCupPersistenceException;
 
    public TeaCups addTeaCup(String name, TeaCups newTeaCup);
  
    TeaCups getTeaCup(String name);
    
    public void loadTeaCups() throws TeaCupPersistenceException;
    
    public void writeTeaCups() throws TeaCupPersistenceException;
}
