package com.sparta.jh.sortManager.IO;

/**
 * Manages output to the console.
 */
public class OutputManager {

    public static void printSorterMsg() {
        System.out.println("Welcome to SortManager!");
        System.out.println("Please enter the number of the sorter than you wish to use:");
        System.out.printf("1. Binary Tree Sorter%n2. Bubble Sorter%n3. Insertion Sorter%n4. Merge Sorter%n5. Quick Sorter%n6. Selection Sorter%n");
    }

    public static void printEnterSorterMsg() {
        System.out.println("Enter a sorter number:");
    }

    public static void printInputMismatchMsg() {
        System.out.println("Please enter a valid integer.");
    }

    public static void printArrayMsg() {
        System.out.println("Please enter the size of the array you wish to sort.");
    }

    public static void printEnterArrayMsg() {
        System.out.println("Enter the size of the array (1-2,147,483,647):");
    }

    public static void printResults(String sorterName, String beforeArray, String afterArray, long timeTaken) {
        System.out.printf("Sorting using the %s sorter.%n", sorterName);
        System.out.printf("Array before sorting:%n%s%n", beforeArray);
        System.out.printf("Array after sorting:%n%s%n", afterArray);
        System.out.printf("Time taken: %s nano seconds.", timeTaken);
    }

    public static void printTimerResults(String sorterName, long timeTaken) {
        System.out.printf("%s - time taken: %s nano seconds.%n", sorterName, timeTaken);
    }
}