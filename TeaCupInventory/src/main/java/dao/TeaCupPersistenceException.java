/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author keelybrennan
 */
public class TeaCupPersistenceException extends Exception {
        public TeaCupPersistenceException(String message) {
        super(message);
    }
    
    public TeaCupPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    

}
