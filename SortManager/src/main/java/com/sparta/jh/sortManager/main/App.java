package com.sparta.jh.sortManager.main;

import com.sparta.jh.sortManager.IO.InputManager;
import com.sparta.jh.sortManager.IO.OutputManager;
import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.managers.ArrayManager;
import com.sparta.jh.sortManager.managers.SorterManager;
import com.sparta.jh.sortManager.sorters.Sorter;
import com.sparta.jh.sortManager.utility.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class.
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting application.");
        OutputManager.printSorterMsg();
        String sorterName = InputManager.chooseSorter();

        OutputManager.printArrayMsg();
        int arraySize = InputManager.chooseArraySize();

        Sorter sorter = SorterManager.sorterFactory(sorterName);
        int[] array = ArrayManager.generateRandomArray(arraySize);
        int[] sortedArray = new int[arraySize];

        Timer timer = new Timer();
        timer.setStartTime(System.nanoTime());
        try {
            sortedArray = sorter.sortArray(array);
        } catch (EmptyArrayException e) {
            System.err.println(e.getMessage());
        }
        timer.setEndTime(System.nanoTime());

        try {
            OutputManager.printResults(sorterName.toLowerCase(), ArrayManager.arrayToString(array), ArrayManager.arrayToString(sortedArray), timer.getTimeDifference());
        } catch (EmptyArrayException e) {
            logger.error("Empty array given in App when printing results.");
            System.err.println(e.getMessage());
        }
        logger.info("Ending application.");
    }
}