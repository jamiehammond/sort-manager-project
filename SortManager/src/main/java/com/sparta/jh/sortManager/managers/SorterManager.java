package com.sparta.jh.sortManager.managers;

import com.sparta.jh.sortManager.sorters.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Manages creation and manipulation of sorters.
 * Defaults to QuickSort.
 */
public class SorterManager {
    static Logger logger = LogManager.getLogger(SorterManager.class);

    public static Sorter sorterFactory(String sorter) {
        switch (sorter) {
            case "BINARY_TREE":
                return new BinaryTreeSorter();
            case "BUBBLE":
                return new BubbleSorter();
            case "INSERTION":
                return new InsertionSorter();
            case "MERGE":
                return new MergeSorter();
            case "QUICK":
                return new QuickSorter();
            case "SELECTION":
                return new SelectionSorter();
        }
        logger.warn("Default sorter returned by sorterFactory.");
        return new QuickSorter();
    }
}