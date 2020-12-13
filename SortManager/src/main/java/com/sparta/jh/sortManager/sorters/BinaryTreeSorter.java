package com.sparta.jh.sortManager.sorters;

import com.sparta.jh.sortManager.binaryTree.BinaryTree;
import com.sparta.jh.sortManager.exceptions.EmptyArrayException;
import com.sparta.jh.sortManager.managers.SorterManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Creates a new Binary Tree from the array given and returns it in ascending order.
 */
public class BinaryTreeSorter implements Sorter {
    static Logger logger = LogManager.getLogger(BinaryTreeSorter.class);

    @Override
    public int[] sortArray(int[] arrayToSort) throws NullPointerException, EmptyArrayException {
        if (arrayToSort == null) {
            logger.error("Null input array provided to sortArray.");
            throw new NullPointerException("Input array cannot be null!");
        } else if (arrayToSort.length == 0) {
            logger.error("Empty input array provided to sortArray.");
            throw new EmptyArrayException();
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addElements(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }
}