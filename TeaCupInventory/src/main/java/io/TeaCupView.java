
package io;

import dto.TeaCups;
import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
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

    public void displayCreateTeaCupBanner() {
        io.print("=== Create TeaCup ===");
    }

    public TeaCups getNewTeaCupInfo() {
        String name = io.readString("Please enter name of TeaCup");
        int manufacturer = io.readInt("Please enter Manufacturer number");
        String color = io.readString("Please enter color");
        BigDecimal price = io.readCurrency("Please enter price");
        LocalDate timeAcquired = io.readDate("Please enter the time acquired (YYYY-MM-DD)");
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

    public void displayDisplayTeaCupBanner() {
        io.print("=== Display TeaCup ===");

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
    
//    public String getName() {
//        String input = io.readString("Enter name: ");
////        if (input.isEmpty()) {
////            input = "- No Data -";
////        }
//        return input;
//    }
    
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
