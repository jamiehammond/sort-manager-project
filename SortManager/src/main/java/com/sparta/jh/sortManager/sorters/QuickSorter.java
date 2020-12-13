package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sparta.jh.sortManager.utility.Swapper.swap;

/**
 * Using quick sort, sorts an array of integers into ascending order.
 */
public class QuickSorter implements Sorter {
    static Logger logger = LogManager.getLogger(QuickSorter.class);

    private int[] quickSort(int[] inputArray) {
        return quickSort(inputArray, 0, inputArray.length - 1);
    }

    private int[] quickSort(int[] inputArray, int low, int high) {
        int[] outputArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
        if (low < high) {
            int partitionIndex = partition(outputArray, low, high);

            outputArray = quickSort(outputArray, low, partitionIndex - 1);
            outputArray = quickSort(outputArray, partitionIndex + 1, high);
        }
        return outputArray;
    }

    private int partition(int[] array, int low, int high) throws NullPointerException {
        int pivot = array[high];
        int smallerIndex = low - 1;

        for (int i = low; i <= high - 1; i++) {
            if (array[i] < pivot) {
                smallerIndex++;
                try {
                    swap(array, smallerIndex, i);
                } catch (EmptyArrayException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            swap(array, smallerIndex + 1, high);
        } catch (EmptyArrayException e) {
            e.printStackTrace();
        }
        return smallerIndex + 1;
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
        return quickSort(arrayToSort);
    }
}