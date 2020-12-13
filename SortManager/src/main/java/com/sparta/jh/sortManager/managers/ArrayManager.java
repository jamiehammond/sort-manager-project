package com.sparta.jh.sortManager.managers;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.main.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Manages methods used to create and manipulate arrays.
 */
public class ArrayManager {
    static Logger logger = LogManager.getLogger(ArrayManager.class);

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (random.nextInt(size) + 1);
        }
        return array;
    }

    public static String arrayToString(int[] array) throws NullPointerException, EmptyArrayException {
        if (array == null) {
            logger.error("Null array input provided to arrayToString.");
            throw new NullPointerException("Input array cannot be null!");
        } else if (array.length == 0) {
            logger.error("Empty array input provided to arrayToString.");
            throw new EmptyArrayException();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array.length == 1) {
                stringBuilder.append("[").append(array[i]).append("]");
            } else if (i == 0) {
                stringBuilder.append("[").append(array[i]).append(", ");
            } else if (i == array.length - 1) {
                stringBuilder.append(array[i]).append("]");
            } else {
                stringBuilder.append(array[i]).append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
