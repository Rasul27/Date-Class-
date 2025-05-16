package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) return false;
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    public void updateDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            System.out.println("Invalid date update request.");
            return;
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDayOfWeek() {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int calculateDifference(Date other) {
        LocalDate d1 = LocalDate.of(this.year, this.month, this.day);
        LocalDate d2 = LocalDate.of(other.year, other.month, other.day);
        return Math.abs((int) java.time.temporal.ChronoUnit.DAYS.between(d1, d2));
    }

    public void printDate() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println(months[month - 1] + " " + day + ", " + year);
    }

    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    @Override
    public int compareTo(Date o) {
        if (this.year != o.year) return this.year - o.year;
        if (this.month != o.month) return this.month - o.month;
        return this.day - o.day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }
}
