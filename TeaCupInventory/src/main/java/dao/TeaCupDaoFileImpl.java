/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TeaCups;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
    public void createTeaCup(TeaCups newTeaCup) {
        
    }

    public static final String TEACUP_FILE = "teacupfile.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, TeaCups> teacups = new HashMap<>();

    @Override
    public List<TeaCups> getAllTeaCups() {
        //loadTeaCups();
        return new ArrayList<TeaCups>(teacups.values());
    }

    @Override
    public TeaCups getName(String name) {
       //loadTeaCups();
       return teacups.get(name);
    }
    
    //use case 
    //public TeaCups removeTeaCup(String name) throws DvdCollectionDaoException {
    public TeaCups removeTeaCup(String name){
    TeaCups teacups = teacups.remove(name);
       // writeTeaCups();
        return teacups;
    }
    
    
    
    
    
    ////////////////////LOAD TEACUP ///////////////////
    
    private void loadTeaCups() {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new Bufferedreader(new FileReader(TEACUP_FILE)));
        }catch (FileNotFoundException e) {
            throw new TeaCupPersistenceException("Could not load teacups into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            TeaCups currentTeaCups = new TeaCups(currentTokens[0]);
            
            currentTeaCups.setColor(currentTokens[1]);
            currentTeaCups.setManufacturer(currentTokens[2]);
            currentTeaCups.setPrice(currentTokens[3]);
            currentTeaCups.setTimeAcquired(currentTokens[4]);
            
            teacups.put(currentTeaCups.getName(), currentTeaCups);
            // not sure how to do this with ints/bigdecimals so need to look into it. 
        }
        scanner.close();
    }
    

}
