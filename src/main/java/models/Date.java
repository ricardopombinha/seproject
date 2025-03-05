package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Date {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    // Static method to validate the date
    private static boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String format(String pattern) {
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public String toString() {
        return format("dd-MM-yyyy");
    }

    public static void main(String[] args) {
        try {
            Date date1 = new Date(24, 6, 2024);
            Date date2 = new Date(1, 2, 2023);
            //System.out.println("Formatted Date 1: " + date1.format("dd-MM-yyyy"));
            System.out.println("Date2: " + date2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
