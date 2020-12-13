package com.sparta.jh.sortManager.binaryTree;

import com.sparta.jh.sortManager.exceptions.ChildNotFoundException;

import java.util.ArrayList;

/**
 * Controls creation and manipulation of Binary Tree elements and nodes.
 */
public class BinaryTree implements BinaryTreeInterface {

    private Node rootNode;

    public BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public BinaryTree(int element) {
        this.rootNode = new Node(element);
    }

    public BinaryTree() {
        this.rootNode = null;
    }

    public void addElement(final int element) {
        if (rootNode == null) {
            rootNode = new Node(element);
        } else {
            addNodeToTree(rootNode, element);
        }
    }

    public void addElements(final int[] elements) {
        for (int elem : elements) {
            addElement(elem);
        }
    }

    public boolean findElement(final int value) {
        return getNode(value) != null;
    }

    public Node getNode(final int element) {
        Node currentNode = rootNode;
        while (currentNode != null) {
            if (element == currentNode.getElement()) {
                return currentNode;
            } else if (element < currentNode.getElement()) {
                currentNode = currentNode.getLeftChild();
            } else if (element > currentNode.getElement()) {
                currentNode = currentNode.getRightChild();
            }
        }
        return null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node leftChild = getNode(element).getLeftChild();
        if (leftChild == null) {
            throw new ChildNotFoundException();
        } else {
            return leftChild.getElement();
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node rightChild = getNode(element).getRightChild();
        if (rightChild == null) {
            throw new ChildNotFoundException();
        } else {
            return rightChild.getElement();
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        ArrayList<Integer> elements = new ArrayList<>();
        elements = getSortedTreeAsc(rootNode, elements);
        int[] sortedArray = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            sortedArray[i] = elements.get(i);
        }
        return sortedArray;
    }

    public ArrayList<Integer> getSortedTreeAsc(Node currentNode, ArrayList<Integer> elements) {
        if (currentNode == null) {
            return elements;
        }

        getSortedTreeAsc(currentNode.getLeftChild(), elements);
        elements.add(currentNode.getElement());
        getSortedTreeAsc(currentNode.getRightChild(), elements);

        return elements;
    }

    @Override
    public int[] getSortedTreeDesc() {
        ArrayList<Integer> elements = new ArrayList<>();
        elements = getSortedTreeDesc(rootNode, elements);
        int[] sortedArray = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            sortedArray[i] = elements.get(i);
        }
        return sortedArray;
    }

    public ArrayList<Integer> getSortedTreeDesc(Node currentNode, ArrayList<Integer> elements) {
        if (currentNode == null) {
            return elements;
        }

        getSortedTreeDesc(currentNode.getRightChild(), elements);
        elements.add(currentNode.getElement());
        getSortedTreeDesc(currentNode.getLeftChild(), elements);

        return elements;
    }

    private void addNodeToTree(Node currentNode, int element) {
        if (element <= currentNode.getElement()) {
            if (currentNode.hasLeftChild()) {
                addNodeToTree(currentNode.getLeftChild(), element);
            } else {
                currentNode.setLeftChild(new Node(element));
            }
        } else if (element > currentNode.getElement()) {
            if (currentNode.hasRightChild()) {
                addNodeToTree(currentNode.getRightChild(), element);
            } else {
                currentNode.setRightChild(new Node(element));
            }
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getElement();
    }

    @Override
    public int getNumberOfElements() {
        return getNumberOfElements(rootNode);
    }

    private int getNumberOfElements(Node currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            return 1 + getNumberOfElements(currentNode.getLeftChild()) + getNumberOfElements(currentNode.getRightChild());
        }
    }
}