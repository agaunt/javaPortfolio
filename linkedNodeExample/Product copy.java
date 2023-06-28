public class Product {

    //Data Elements
    private String name;
    private double price;
    private int quantity;


    //Constructors
    public Product(){}

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {return name;}

    public double getPrice() {return price;}

    public int getQuantity() {return quantity;}

    //toString
    @Override
    public String toString() {
        return "Item Name: " + name + " Item Price: " + price + " Quantity: " + quantity + "\n";
    }

}
