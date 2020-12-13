package com.sparta.jh.sortManager;

import com.sparta.jh.sortManager.IO.OutputManager;
import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.managers.ArrayManager;
import com.sparta.jh.sortManager.managers.SorterManager;
import com.sparta.jh.sortManager.sorters.Sorter;
import com.sparta.jh.sortManager.utility.Timer;

import java.util.HashMap;
import java.util.Map;

/**
 * Test suite for sorter speed.
 */
public class SorterSpeedTest {
    public static void main(String[] args) {
        int[] testArray = ArrayManager.generateRandomArray(10000);
        HashMap<String, Sorter> sorters = new HashMap<>();
        sorters.put("Binary Tree Sort", SorterManager.sorterFactory("BINARY_TREE"));
        sorters.put("Bubble Sort", SorterManager.sorterFactory("BUBBLE"));
        sorters.put("Insertion Sort", SorterManager.sorterFactory("INSERTION"));
        sorters.put("Merge Sort", SorterManager.sorterFactory("MERGE"));
        sorters.put("Quick Sort", SorterManager.sorterFactory("QUICK"));
        sorters.put("Selection Sort", SorterManager.sorterFactory("SELECTION"));

        for (Map.Entry<String, Sorter> entry : sorters.entrySet()) {
            long timeTaken = testSorterSpeed(testArray, entry.getValue());
            OutputManager.printTimerResults(entry.getKey(), timeTaken);
        }
    }

    private static long testSorterSpeed(int[] testArray, Sorter binaryTreeSorter) {
        Timer timer = new Timer();
        timer.setStartTime(System.nanoTime());
        try {
            binaryTreeSorter.sortArray(testArray);
        } catch (EmptyArrayException e) {
            System.err.println(e.getMessage());
        }
        timer.setEndTime(System.nanoTime());
        return timer.getTimeDifference();
    }
}