package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Using bubble sort, sorts an array of integers into ascending order
 */
public class BubbleSorter implements Sorter {
    static Logger logger = LogManager.getLogger(BinaryTreeSorter.class);

    private int[] bubbleSort(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
        int swapTemp = 0;
        for (int i = 0; i < outputArray.length; i++) {
            for (int j = 1; j < outputArray.length - i; j++) {
                if (outputArray[j - 1] > outputArray[j]) {
                    swapTemp = outputArray[j - 1];
                    outputArray[j - 1] = outputArray[j];
                    outputArray[j] = swapTemp;
                }
            }
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
        return bubbleSort(arrayToSort);
    }
}