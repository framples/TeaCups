/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import dto.TeaCups;
import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

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
    
    
    
    
    
    

    
    
    
    
//==CASE 4: REMOVE TEACUP    
    public void displayRemoveBanner() {
        io.print("=== Remove TeaCup from Inventory ===");
    }
    

    
    

    public void displayRemoveSuccessBanner() {
        io.print("=== Success! The TeaCup was removed from Invetory. ===");
    }

//==CASE 5: EDIT TEACUP
    
    public int displayEditMenuAndGetChoice(TeaCups teaCup) {
        io.print("=== Edit A TeaCup ===");
        io.print("-----Field-----  |---Current Entry---");
        io.print("1. Title         |   " + teaCup.getName());
        io.print("2. Color         |   " + teaCup.getColor());
        io.print("3. Date Acquired |   " + teaCup.getTimeAcquired().format(ISO_LOCAL_DATE));
        io.print("4. Manufacturer  |   " + teaCup.getManufacturer());
        io.print("5. Price         |   " + teaCup.getPrice());
        io.print("6. Edit All      |");
        io.print("7. Exit Editor   |");
        io.print("-----------------|");
        return io.readInt("Select An Option: ");
    }
    
    public String getName() {
        String input = io.readString("Enter name: ");
//        if (input.isEmpty()) {
//            input = "- No Data -";
//        }
        return input;
    }
    
    public String getColor() {
        String input = io.readString("Enter color: ");
        return input;
    }
    
//    public LocalDate getTimeAcquired() {
//
//    } 
    
    public int getManufacturer() {
        Integer input = io.readInt("Enter manufacturer ID number: ");
        return input;
    }
    
    public BigDecimal getPrice(){
        BigDecimal input = io.readBigDecimal("IDK");
        return input;
    }
    

    public boolean promptEditContinue() {
        String choice = io.readString("Changes complete. Continue editing? (y/n)");
        return choice.toLowerCase().contains("y");
    }



}
