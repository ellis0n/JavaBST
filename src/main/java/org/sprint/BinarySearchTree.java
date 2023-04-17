package org.sprint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BinarySearchTree {

    // Node class has been made public to facilitate testing.
    // In a real application, this would be private, and we wouldn't test
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    Node root;

    public void insertNode(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node cur = root;

            while (true) {
                if (data < cur.data) {
                    if (cur.left == null) {
                        cur.left = newNode;
                        break;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
    }

    // Get unformatted JSON representation (used for testing)
    public String getJSONRepresentation() {
        Gson gson = new Gson();
        return gson.toJson(this.root);
    }


    // Get formatted JSON representation (used for testing and CLI class)
    public String getPrettyJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }



}
