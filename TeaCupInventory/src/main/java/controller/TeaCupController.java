/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TeaCupDao;
import io.TeaCupView;

/**
 *
 * @author keelybrennan
 */
public class TeaCupController {
    private TeaCupView view;
    private TeaCupDao dao;
    
    public TeaCupController(TeaCupDao dao, TeaCupView view) {
        this.dao = dao;
        this.view = view;
       
    } 


    
    
    
    
}
