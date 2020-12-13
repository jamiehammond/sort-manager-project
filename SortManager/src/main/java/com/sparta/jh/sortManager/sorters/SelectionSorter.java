package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sparta.jh.sortManager.utility.Swapper.swap;

/**
 * Using selection sort, sorts an array of integers into ascending order.
 */
public class SelectionSorter implements Sorter {
    static Logger logger = LogManager.getLogger(SelectionSorter.class);

    private int[] selectionSort(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
        for (int i = 0; i < outputArray.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < outputArray.length; j++) {
                if (outputArray[j] < outputArray[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                try {
                    swap(outputArray, minIndex, i);
                } catch (EmptyArrayException e) {
                    System.err.println(e.getMessage());
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
        return selectionSort(arrayToSort);
    }
}