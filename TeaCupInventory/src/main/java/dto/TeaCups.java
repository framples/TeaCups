package dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class TeaCups {
    private int manufacturer;
    private String name; 
    private String color;
    private BigDecimal price;
    private LocalDate timeAcquired;
    

   public TeaCups(String name) {
        this.name =  name;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getTimeAcquired() {
        return timeAcquired;
    }

    public void setTimeAcquired(LocalDate timeAcquired) {
        this.timeAcquired = timeAcquired;
    }

}