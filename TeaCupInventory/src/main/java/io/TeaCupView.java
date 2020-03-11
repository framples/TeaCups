/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import dto.TeaCups;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    
    public void displayDisplayAllTeaCupsBanner() {
        io.print("=== Display Tea Cup");
    }
    
    public void displayTeaCup(TeaCups teacup) {
        if (teacup != null) {
            io.print("Name: " + teacup.getName());
            io.print("Color: " + teacup.getColor());
            io.print("Manufacturer: " + teacup.getManufacturer());
            io.print("Price: " + teacup.getPrice());
            io.print("Time Acquired: " + teacup.getTimeAcquired());
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
    
    public void displayCreateTeaCupBanner() {
        io.print("=== Create TeaCup ===");
    }
    
    public TeaCups getNewTeaCupInfo() {
        String name = io.readString("Please enter name of TeaCup");
        int manufacturer = io.readInt("Please enter Manufacturer");
        String color = io.readString("Please enter color");
        BigDecimal price = io.readBigDecimal("Please enter price");
        LocalDate timeAcquired = io.readDate("Please enter the time acquired");
        TeaCups currentTeaCup = new TeaCups(name);
        currentTeaCup.setManufacturer(manufacturer);
        currentTeaCup.setColor(color);
        currentTeaCup.setPrice(price);
        currentTeaCup.setTimeAcquired(timeAcquired);
        return currentTeaCup;
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("TeaCup successfully created. Please hit enter to continue");
    }
}
