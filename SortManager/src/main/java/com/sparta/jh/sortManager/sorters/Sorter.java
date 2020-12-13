package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;

/**
 * Specifies a class that can sort an array of integers.
 */
public interface Sorter {
    int[] sortArray(int[] arrayToSort) throws EmptyArrayException;
}