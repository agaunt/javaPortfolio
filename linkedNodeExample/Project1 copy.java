/*
Name: Abigail Gaunt
Course: CIS211
Section: 400
Date: 3/3/2023
Assignment: Project 1
I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice != 6) {

            System.out.println("*** Shopping List ***");
            System.out.println("1. View Shopping List");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. View List Price Total");
            System.out.println("5. Delete Entire List");
            System.out.println("6. Exit");
            System.out.println("Enter Choice (1-6): ");

            try {
                menuChoice = scanner.nextInt();

                if (menuChoice == 1) {
                    System.out.println(cart);
                }

                else if (menuChoice == 2) {

                    Product product = createNewProduct();
                    cart.addItem(product);

                } else if (menuChoice == 3) {

                    boolean removed = removeFromCart(cart);

                    if (removed) {
                        System.out.println("Product removed from list");
                    }
                    else {
                        System.out.println("Product not found in list");
                    }
                } else if (menuChoice == 4) {
                    System.out.println("Cart Total: $" + cart.totalCost());

                } else if (menuChoice == 5) {
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
     * The user is able to enter the name, price, and quantity of a product to add to list
     * @return Product
     */
    public static Product createNewProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product.setName(name);

        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        product.setQuantity(quantity);

        System.out.println("Enter product price for one unit: ");
        double price = scanner.nextDouble();
        product.setPrice(price * quantity);

        return product;
    }

    /**
     * removeFromCart
     * The user enters the name of a product to search, if a match is found the product is removed
     * from the list
     * @param cart Cart
     * @return boolean
     */
    public static boolean removeFromCart(Cart cart) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of item to remove: ");
        String name = scanner.nextLine();
        return cart.removeItem(name);
    }
}