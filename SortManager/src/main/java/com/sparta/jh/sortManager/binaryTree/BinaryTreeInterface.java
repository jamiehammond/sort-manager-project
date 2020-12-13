package com.sparta.jh.sortManager.binaryTree;

import com.sparta.jh.sortManager.exceptions.ChildNotFoundException;

/**
 * Specifies methods required for a Binary Tree.
 */
public interface BinaryTreeInterface {

    int getRootElement();

    int getNumberOfElements();

    void addElements(final int[] elements);

    void addElement(final int element);

    boolean findElement(final int element);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}