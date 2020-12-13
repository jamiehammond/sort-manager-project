package com.sparta.jh.sortManager;

import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.managers.ArrayManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the ArrayManager class.
 */
public class ArrayManagerTest {

    @Test
    void whenNullInput_thenThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            ArrayManager.arrayToString(null);
        });
    }

    @Test
    void whenEmptyArray_thenThrowsEmptyArrayException() {
        int[] testArr = new int[0];
        Assertions.assertThrows(EmptyArrayException.class, () -> {
            ArrayManager.arrayToString(testArr);
        });
    }

    @Test
    void whenNullPointerThrown_thenMessageIsCorrect() {
        Exception e = Assertions.assertThrows(NullPointerException.class, () -> {
            ArrayManager.arrayToString(null);
        });

        String expectedMessage = "Input array cannot be null!";
        String actualMessage = e.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenEmptyArrayThrown_thenMessageIsCorrect() {
        int[] testArr = new int[0];
        Exception e = Assertions.assertThrows(EmptyArrayException.class, () -> {
            ArrayManager.arrayToString(testArr);
            ;
        });

        String expectedMessage = "Array cannot be empty!";
        String actualMessage = e.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convertsArrayToString() throws EmptyArrayException {
        Assertions.assertEquals("[1, 2, 3]", ArrayManager.arrayToString(new int[]{1, 2, 3}));
    }

    @Test
    void convertsOneElementArrayToString() throws EmptyArrayException {
        Assertions.assertEquals("[1]", ArrayManager.arrayToString(new int[]{1}));
    }
}
