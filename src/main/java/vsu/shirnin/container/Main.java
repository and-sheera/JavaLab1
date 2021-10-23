package vsu.shirnin.container;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Container list = new Container();
        int choice;
        do {
            System.out.println("\nМеню: ");
            System.out.println("1. Add item to the end");
            System.out.println("2. Add item to the beginning");
            System.out.println("3. Insert item after another item");
            System.out.println("4. Remove item");
            System.out.println("5. Extract item");
            System.out.println("6. Remove last item");
            System.out.println("7. Show container length");
            System.out.println("0. Exit");
            System.out.println("Current container: " + list.show());
            System.out.print("Select: ");
            choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    // Add item to the end
                    System.out.println("Enter the value: ");
                    int data = in.nextInt();
                    list.push(data);
                }
                case 2 -> {
                    // Add item to the beginning
                    System.out.println("Enter the value: ");
                    int data = in.nextInt();
                    list.addToBeg(data);
                }
                case 3 -> {
                    // Insert item after another item
                    System.out.println("Enter the index of the element after which you want to insert the new: ");
                    int afterIndex = in.nextInt();
                    if (afterIndex < 1 || afterIndex > list.length()) {
                        System.out.println("No item with this index found :( \n Try again.");
                    } else {
                        System.out.println("Enter the value of the new item: ");
                        int data = in.nextInt();
                        list.insert(afterIndex, data);
                    }
                }
                case 4 -> {
                    // Remove item
                    if (list.notEmpty()) {
                        System.out.println("Enter the index of the item to remove: ");
                        int index = in.nextInt();
                        list.delete(index);
                    } else {
                        System.out.println("It is impossible to delete an item because the container is empty");
                    }
                }
                case 5 -> {
                    // Extract item
                    if (list.notEmpty()) {
                        System.out.println("Enter the index of the item to remove: ");
                        int index = in.nextInt();
                        int extractedElement = list.extract(index);
                        System.out.println("Extracted element = " + extractedElement);
                    } else {
                        System.out.println("It is impossible to extract an item because the container is empty");
                    }
                }
                case 6 -> {
                    // Remove last item
                    if (list.notEmpty()) {
                        System.out.println("The last item will now be removed");
                        int removedElement = list.pop();
                        System.out.println("Removed element = " + removedElement);
                    } else {
                        System.out.println("It is impossible to remove an item because the container is empty");
                    }
                }
                case 7 -> // Show container length
                        System.out.println("Container length: " + list.length());
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("The wrong menu item is selected. Try again.\n");
            }
        } while (choice != 0);
    }
}
