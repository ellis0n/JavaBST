package org.sprint;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        for (String number : numbers) {
            try {
                int data = Integer.parseInt(number);
                bst.insertNode(data);
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + number + "\" is not a valid integer. Skipping...");
            }
        }

        String json = bst.getJSONRepresentation();
        System.out.println(json);
    }
}
