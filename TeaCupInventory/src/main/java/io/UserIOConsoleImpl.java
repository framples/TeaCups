/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author keelybrennan
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean accept = false;
        double userInput = 0;

        while (!accept) {
            System.out.println(prompt + " " + min + " and " + max);
            userInput = sc.nextDouble();
            if (userInput >= min && userInput <= max) {
                accept = !accept;
            }
        }
        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean valid = false;
        float userInput = 0;
        while (!valid) {
            System.out.println(prompt);
            userInput = Float.parseFloat(sc.nextLine());
            if (userInput >= min && userInput <= max) {
                valid = !valid;
            }
        }
        return userInput;
    }

    @Override
    public int readInt(String prompt) {
        int userInput = 0;

//  Validation of field entry. Prevents text entry which causes code to fail.
        while (true) {
            try {
                System.out.println(prompt);
                userInput = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("The value entered was not an integer. Please enter an integer.");
                continue;
            }
            
            if (userInput >= 0) {
                break;
            } else {
                System.out.println("Please enter a positive integer for the manufacturer number.");
            }
        }
        return userInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userInput = 0;

//  Validation of field entry. Prevents text entry which causes code to fail.
        while (true) {
            try {
                System.out.println(prompt);
                userInput = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("The value entered was not an integer. Please enter an integer.");
                continue;
            }
            if (userInput >= min && userInput <= max) {
                break;
            } else {
                System.out.println("That is not a valid selection.");
            }
        }
        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean valid = false;
        long userInput = 0;

        while (!valid) {
            System.out.println(prompt);
            userInput = Long.parseLong(sc.nextLine());
            if (userInput >= min && userInput <= max) {
                valid = !valid;
            }
        }
        return userInput;
    }

    @Override
    public String readInString(String prompt) {
//        System.out.println(prompt);
//        return sc.nextLine();
        String userInput;

        while (true) {

            try {
                System.out.println(prompt);
                userInput = sc.nextLine();
            } catch (Exception e) {
                System.out.println("");
                continue;
            }

            if (!userInput.isBlank()) {
                break;
            } else {
                System.out.println("A TeaCup name cannot be blank. Please enter a string as a name.");
            }
        }

        return userInput;
    }
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public LocalDate readDate(String prompt) {
        boolean looping = true;
        LocalDate releaseDate = null;

        while (looping) {
            try {
                System.out.println(prompt);
                releaseDate = LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("The value entered was not a date with the acceptable fromat. Please enter a date \nwith the following format: YYYY-MM-DD. Example: 1974-12-03");
                continue;
            }

            if (releaseDate != null) {
                looping = false;
                break;
            }

        }

        return releaseDate;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        return new BigDecimal(sc.nextLine()).setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public BigDecimal readCurrency(String prompt) {
        boolean looping = true;
        BigDecimal currency = null;
        BigDecimal zeroComparison = new BigDecimal("0").setScale(2, RoundingMode.FLOOR);

        while (looping) {
            try {
                System.out.println(prompt);
                currency = new BigDecimal(sc.nextLine()).setScale(2, RoundingMode.FLOOR);
            } catch (Exception e) {
                System.out.println("The value entered was not valid. Please try again.");
                continue;
            }
            if (currency.compareTo(zeroComparison) > 0) {
                break;
            } else {
                System.out.println("Entered value must be non-negative and non-zero.");
            }
        }
        return currency;
    }

    @Override
    public void printf(String message) {
        System.out.printf(message);
    }

}
