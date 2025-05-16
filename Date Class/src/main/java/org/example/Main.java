package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();

        // Valid and Invalid Dates
        try {
            dates.add(new Date(15, 5, 2022));
            dates.add(new Date(29, 2, 2024)); // valid leap year
            dates.add(new Date(31, 4, 2023)); // invalid: April has 30 days
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Update date
        Date d = new Date(1, 1, 2020);
        d.printDate();
        d.updateDate(31, 2, 2021); // invalid
        d.updateDate(27, 11, 2025); // valid
        d.printDate();
        d.getDayOfWeek();

        // Day of week
        System.out.println("Day of week: " + d.getDayOfWeek());

        // Difference between dates
        Date d1 = new Date(1, 1, 2020);
        Date d2 = new Date(1, 1, 2021);
        System.out.println("Days between " + d1 + " and " + d2 + ": " + d1.calculateDifference(d2));

        // Sorting
        dates.add(new Date(12, 12, 2019));
        dates.add(new Date(25, 12, 2023));
        dates.add(new Date(1, 1, 2021));
        Collections.sort(dates);
        System.out.println("\nSorted dates:");
        for (Date date : dates) {
            date.printDate();
        }
    }
}
