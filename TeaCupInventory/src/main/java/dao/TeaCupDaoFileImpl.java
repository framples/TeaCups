/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TeaCups;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author keelybrennan
 */
public class TeaCupDaoFileImpl implements TeaCupDao {

    public static final String TEACUP_FILE = "teacupfile.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, TeaCups> teacups = new HashMap<>();
    
    @Override

    public List<TeaCups> getAllTeaCups() throws TeaCupPersistenceException {
        //loadTeaCups();
        return new ArrayList<TeaCups>(teacups.values());
    }
    public TeaCups addTeaCup(String name, TeaCups newTeaCup) {
        TeaCups teaCup = teacups.put(name, newTeaCup);
        return teaCup;
    }
    
    
    @Override
    public TeaCups getName(String name) throws TeaCupPersistenceException{
        //loadTeaCups();
        return teacups.get(name);
    }

    public TeaCups getTeaCup(String name) {
       //loadTeaCups();
       return teacups.get(name);
    }
    
    //use case 
    public TeaCups removeTeaCup(String name){
    TeaCups removedTeacups = teacups.remove(name);
        //writeTeaCups() ;
        return removedTeacups;
    }
    
    
    
    ////////////////////LOAD TEACUP ///////////////////
    @Override
    public void loadTeaCups() throws TeaCupPersistenceException {
        Scanner scanner;
        
        try {

            scanner = new Scanner(new BufferedReader(new FileReader(TEACUP_FILE)));
        } catch (FileNotFoundException e) {
            throw new TeaCupPersistenceException("Could not load teacups into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            TeaCups currentTeaCups = new TeaCups(currentTokens[0]);
            
            currentTeaCups
                    .setColor(
                            currentTokens[1]);
            currentTeaCups
                    .setManufacturer(Integer.parseInt(
                            currentTokens[2]));
            currentTeaCups
                    .setPrice(
                            new BigDecimal(currentTokens[3])
                                .setScale(2,RoundingMode.HALF_UP)
                        );
            currentTeaCups
                    .setTimeAcquired(LocalDate.parse(
                            currentTokens[4]
                            ));
            
            teacups.put(currentTeaCups.getName(), currentTeaCups);
            
        }
        scanner.close();
    }
    
    @Override
    public void writeTeaCups() throws TeaCupPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(TEACUP_FILE));
        } catch (IOException e) {
            String errMsg = "Could not create file: " + e.getMessage();
            throw new TeaCupPersistenceException(errMsg, e);
        }
        
        List<TeaCups> teaCupsList = this.getAllTeaCups();
        for (TeaCups teaCups : teaCupsList) {
            
            out.println(
                    teaCups.getName() + DELIMITER +
                    teaCups.getColor() + DELIMITER +
                    teaCups.getManufacturer() + DELIMITER +
                    teaCups.getPrice() + DELIMITER +
                    teaCups.getTimeAcquired());
            
            out.flush();
        }
//        for (TeaCups currentTeaCup : teaCupsList)
        
        out.close();
    }
    

}
