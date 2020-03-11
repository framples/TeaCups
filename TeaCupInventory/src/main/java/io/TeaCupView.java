/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import dto.TeaCups;
import java.util.List;

/**
 *
 * @author keelybrennan
 */
public class TeaCupView {
        UserIO io;
    
    public TeaCupView(UserIO io) {
    this.io = io;
}

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Create Tea Cup");
        io.print("2. List All Tea Cups");
        io.print("3. Search for a Tea Cup");
        io.print("4. Remove a Tea Cup");
        io.print("5. Edit Tea Cup");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    

    public String getNameChoice() {
        return io.readString("Please enter the name of the Tea Cup you would like to find.");
    }
    
    public void displayTeaCupList(List<TeaCups> teaCupList) {
        for (TeaCups currentTeaCup : teaCupList) {
            io.print(currentTeaCup.getName() + " "
                    + currentTeaCup.getColor() + " "
                    + currentTeaCup.getManufacturer() + " "
                    + currentTeaCup.getPrice() + " "
                    + currentTeaCup.getTimeAcquired());
        }
        io.readString("Hit enter to continue.");
    }
    /// these two do the same thing!
    public <T> void displayObjectList(List<T> list){
    
        for (T t : list) {
            io.print("" + t);
        }
        io.readString("Hit enter to continue.");
    }
    
    
    public void displayDisplayAllTeaCupsBanner() {
        io.print("=== Display Tea Cups");
    }
    
    public void displayDisplayTeaCupBanner() {
        io.print("=== Display Tea Cup ===");
    }
    
    public void displayTeaCup(TeaCups teacup) {
        if (teacup != null) {
            io.print("Name: " + teacup.getName());
            io.print("Color: " + teacup.getColor());
            io.print("Manufacturer: " + teacup.getManufacturer());
            io.print("Price: " + teacup.getPrice());
            io.print("Time Acquired: " + teacup.getTimeAcquired());
        }

       
    }
     public void displayExitBanner() {
        io.print("Good Bye!!!");
     }
     
    public void displayUnknownCommandBanner() {
        io.print("Unknown command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
      io.print("=== ERROR ===");
      io.print("errorMsg");

    }
}
