package com.sparta.jh.sortManager.IO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Manages user input.
 */
public class InputManager {
    static Logger logger = LogManager.getLogger(InputManager.class);

    public static String chooseSorter() {
        Scanner scanner = new Scanner(System.in);
        int sorterNum;

        do {
            OutputManager.printEnterSorterMsg();
            while (!scanner.hasNextInt()) {
                logger.info("Non-integer sorter number provided.");
                OutputManager.printInputMismatchMsg();
                scanner.next();
            }
            sorterNum = scanner.nextInt();
        } while (sorterNum < 1 || sorterNum > 6);

        switch (sorterNum) {
            case 1:
                return "BINARY_TREE";
            case 2:
                return "BUBBLE";
            case 3:
                return "INSERTION";
            case 4:
                return "MERGE";
            case 5:
                return "QUICK";
            case 6:
                return "SELECTION";
        }
        logger.warn("Default sorter name returned from chooseSorter.");
        return "QUICK";
    }

    public static int chooseArraySize() {
        Scanner scanner = new Scanner(System.in);
        long arraySize;

        do {
            OutputManager.printEnterArrayMsg();
            while (!scanner.hasNextLong()) {
                logger.info("Non-integer array size provided.");
                OutputManager.printInputMismatchMsg();
                scanner.next();
            }
            arraySize = scanner.nextLong();
        } while (arraySize < 1 || arraySize > Integer.MAX_VALUE);

        return (int) arraySize;
    }
}