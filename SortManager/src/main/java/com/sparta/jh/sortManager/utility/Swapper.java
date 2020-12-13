package com.sparta.jh.sortManager.utility;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.sorters.SelectionSorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Swapper {
    static Logger logger = LogManager.getLogger(SelectionSorter.class);

    public static void swap(int[] array, int i, int j) throws NullPointerException, EmptyArrayException {
        if (array == null) {
            logger.error("Null input array provided to swap.");
            throw new NullPointerException("Input array cannot be null!");
        } else if (array.length == 0) {
            logger.error("Empty input array provided to swap.");
            throw new EmptyArrayException();
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}