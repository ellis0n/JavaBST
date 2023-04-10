package org.example;

import static org.junit.Assert.*;
import org.junit.Test;


public class BinarySearchTreeTest {
    @Test
    public void testInsertNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(8);

        assertEquals(5, bst.root.data);
        assertEquals(3, bst.root.left.data);
        assertEquals(1, bst.root.left.left.data);
        assertEquals(4, bst.root.left.right.data);
        assertEquals(7, bst.root.right.data);
        assertEquals(6, bst.root.right.left.data);
        assertEquals(8, bst.root
