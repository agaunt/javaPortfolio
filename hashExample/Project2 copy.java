/*
Name: Abigail Gaunt
Course: CIS211
Section: 400
Date: 3/31/2023
Assignment: Project 2
I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice != 6) {

            System.out.println("*** Shopping List ***");
            System.out.println("1. View Shopping List");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Delete Entire List");
            System.out.println("5. Exit");
            System.out.println("Enter Choice (1-5): ");

            try {
                menuChoice = scanner.nextInt();

                if (menuChoice == 1) {
                    System.out.println(cart);
                }

                else if (menuChoice == 2) {

                    createNewProduct(cart);

                } else if (menuChoice == 3) {

                    removeFromCart(cart);

                }  else if (menuChoice == 4) {
                    cart.clearAll();
                    System.out.println("All items removed from list.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Entry, please select from the menu.");
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("Shopping List Exited");
    }

    /**
     * createNewProduct
     * The user enters a name and price, product is created and added to cart
     * @param cart (products)
     */
    public static void createNewProduct(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Enter item price: ");
        double itemPrice = scanner.nextDouble();
        Product product = new Product(itemName, itemPrice);
        cart.addItem(product);
    }

    /**
     * removeFromCart
     * The user enters name of the product for removal, the product is removed and user is informed whether
     * removal was successful
     * @param cart (products)
     */
    public static void removeFromCart(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product you wish to remove: ");
        String removedItem = scanner.nextLine();
        boolean removed = cart.removeItem(removedItem);

        if (removed) {
            System.out.println("Product removed from list");
        }
        else {
            System.out.println("Product not found in list");
        }
    }
}
