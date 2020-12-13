package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Using merge sort, sorts an array of integers into ascending order.
 */
public class MergeSorter implements Sorter {
    static Logger logger = LogManager.getLogger(MergeSorter.class);

    private int[] mergeSort(int[] inputArray) {
        if (inputArray.length < 2) {
            return inputArray;
        }

        int midIndex = inputArray.length / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[inputArray.length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputArray.length; i++) {
            rightArray[i - midIndex] = inputArray[i];
        }

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] array = new int[leftArray.length + rightArray.length];
        int arrPointer = 0, leftPointer = 0, rightPointer = 0;

        while (leftPointer < leftArray.length && rightPointer < rightArray.length) {
            if (leftArray[leftPointer] < rightArray[rightPointer]) {
                array[arrPointer++] = leftArray[leftPointer++];
            } else {
                array[arrPointer++] = rightArray[rightPointer++];
            }
        }
        while (leftPointer < leftArray.length) {
            array[arrPointer++] = leftArray[leftPointer++];
        }
        while (rightPointer < rightArray.length) {
            array[arrPointer++] = rightArray[rightPointer++];
        }
        return array;
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
        return mergeSort(arrayToSort);
    }
}