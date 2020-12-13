package com.sparta.jh.sortManager;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.managers.ArrayManager;
import com.sparta.jh.sortManager.managers.SorterManager;
import com.sparta.jh.sortManager.sorters.QuickSorter;
import com.sparta.jh.sortManager.sorters.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Tests for sorters.
 */
public class SorterTest {

    @Test
    void whenNullInput_thenThrowsException() {
        Sorter sorter = SorterManager.sorterFactory("BINARY_TREE");
        Assertions.assertThrows(NullPointerException.class, () -> {
            sorter.sortArray(null);
        });
    }

    @Test
    void whenEmptyArray_thenThrowsEmptyArrayException() {
        int[] testArr = new int[0];
        Sorter sorter = SorterManager.sorterFactory("BINARY_TREE");
        Assertions.assertThrows(EmptyArrayException.class, () -> {
            sorter.sortArray(testArr);
        });
    }

    @Test
    void whenNullPointerThrown_thenMessageIsCorrect() {
        Sorter sorter = SorterManager.sorterFactory("BINARY_TREE");
        Exception e = Assertions.assertThrows(NullPointerException.class, () -> {
            sorter.sortArray(null);
        });

        String expectedMessage = "Input array cannot be null!";
        String actualMessage = e.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenEmptyArrayThrown_thenMessageIsCorrect() {
        int[] testArr = new int[0];
        Sorter sorter = SorterManager.sorterFactory("BINARY_TREE");
        Exception e = Assertions.assertThrows(EmptyArrayException.class, () -> {
            sorter.sortArray(testArr);
        });

        String expectedMessage = "Array cannot be empty!";
        String actualMessage = e.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void sortsPositiveArray() throws EmptyArrayException {
        Sorter sorter = SorterManager.sorterFactory("MERGE");
        int[] unsortedArr = {9, 7, 1, 10, 2, 5, 4, 3, 8, 6};
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(sortedArr, sorter.sortArray(unsortedArr));
    }

    @Test
    void sortsNegativeArray() throws EmptyArrayException {
        Sorter sorter = SorterManager.sorterFactory("MERGE");
        int[] unsortedArr = {-9, -7, -1, -10, -2, -5, -4, -3, -8, -6};
        int[] sortedArr = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
        Assertions.assertArrayEquals(sortedArr, sorter.sortArray(unsortedArr));
    }

    @Test
    void sortsArrayWithDuplicates() throws EmptyArrayException {
        Sorter sorter = SorterManager.sorterFactory("MERGE");
        int[] unsortedArr = {4, 3, 2, 3, 4, 1, 4, 2, 3, 4};
        int[] sortedArr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        Assertions.assertArrayEquals(sortedArr, sorter.sortArray(unsortedArr));
    }

    @Test
    void sortsLargeArray() throws EmptyArrayException {
        Sorter sorter = SorterManager.sorterFactory("QUICK");
        int[] unsortedArr = ArrayManager.generateRandomArray(1000);
        int[] mySortedArr = sorter.sortArray(unsortedArr);
        Arrays.sort(unsortedArr);
        Assertions.assertArrayEquals(unsortedArr, mySortedArr);
    }
}