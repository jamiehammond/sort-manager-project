package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Using insertion sort, sorts an array of integers into ascending order
 */
public class InsertionSorter implements Sorter {
    static Logger logger = LogManager.getLogger(InsertionSorter.class);

    private int[] insertionSort(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
        for (int i = 1; i < outputArray.length; i++) {
            int key = outputArray[i];
            int j = i - 1;
            while (j >= 0 && outputArray[j] > key) {
                outputArray[j + 1] = outputArray[j];
                j = j - 1;
            }
            outputArray[j + 1] = key;
        }
        return outputArray;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) throws NullPointerException, EmptyArrayException {
        if (arrayToSort == null) {
            logger.error("Null input array provided to sortArray.");
            throw new NullPointerException("Input array cannot be null!");
        } else if (arrayToSort.length == 0) {
            logger.error("Empty input array provided to sortArray.");
            throw new EmptyArrayException();
        }
        return insertionSort(arrayToSort);
    }
}