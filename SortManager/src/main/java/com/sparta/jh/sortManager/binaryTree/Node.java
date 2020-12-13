package com.sparta.jh.sortManager.binaryTree;

/**
 * Node class for a binary tree.
 */
public class Node {

    private int element;
    private Node leftChild;
    private Node rightChild;

    public Node(int element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public boolean hasLeftChild() {
        if (leftChild != null) {
            return true;
        }
        return false;
    }

    public boolean hasRightChild() {
        if (rightChild != null) {
            return true;
        }
        return false;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
