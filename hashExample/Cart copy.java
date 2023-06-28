public class Cart implements ShoppingList {

    private String[] keys;
    private Product[] items;
    private final int DEFAULT_SIZE = 20;
    private int count = 0;

    //string variable to act as placeholder of deleted items in case look-up is needed
    String deleted = "X";

    public Cart() {
        keys = new String[DEFAULT_SIZE];
        items = new Product[DEFAULT_SIZE];
    }

    @Override
    public void addItem(Product item) throws IllegalStateException {
        //Check if cart has open space
        if (count < DEFAULT_SIZE) {
            //Get hash value from key
            int i = hash(item.getName());
            //Check if hash value index is empty
            if (keys[i] == null || keys [i].equals(deleted)) {
                //Assign value to empty index
                keys[i] = item.getName();
                items[i] = item;
                count++;
            }
            //Linear probe for empty index value
            else {
                boolean flag = false;
                int j = i + 1;
                //traverse through arrays
                while (!flag) {
                    //Wrap around search to start of array
                    j = j % DEFAULT_SIZE;
                    //Check if index is empty
                    if (keys[j] == null || keys[j].equals(deleted)) {
                        //Assign value to found empty index
                        keys[j] = item.getName();
                        items[j] = item;
                        count++;
                        flag = true;
                    }
                    else {j++;}
                }
            }
        }
        else {
            System.out.println("Cart is full");
        }
    }

    @Override
    public boolean removeItem(String item) {
        boolean flag = false;

        if (!isEmpty()) {
            int i = hash(item);
            //Check if item at index matches item being searched
            if (keys[i].equals(item)) {
                //Put placeholder value as key
                keys[i] = deleted;
                items[i] = null;
                count--;
                flag = true;
            }
            //Another value is currently in hashed index
            else {

                for (int j = i + 1; i < DEFAULT_SIZE; i++) {
                    //Wrap around search to start of array
                    j = j % DEFAULT_SIZE;
                    //Check if index is empty
                    if (keys[j] != null && keys[j].equals(item)) {
                        //Remove value found
                        keys[j] = deleted;
                        items[j] = null;
                        count--;
                        flag = true;

                    } else {
                        j++;
                    }
                }
            }
        } else {
            return false;
        }
        return flag;
    }

    @Override
    public void clearAll() {
        keys = new String[DEFAULT_SIZE];
        items = new Product[DEFAULT_SIZE];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        StringBuilder printedCart = new StringBuilder();
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            if (keys[i] != null && !keys[i].equals(deleted)) {
                printedCart.append(items[i].toString()).append(" ");
            }
        }
        return printedCart.toString();
    }

    private int hash(String key) {

        //Parse val into an int
        int val1 = key.charAt(0);
        int val2 = key.charAt(1);
        int val3 = key.charAt(2);
        int val = (val1 + val2 + val3) * key.length();

        int p = 331;        //Large prime number
        int a = 330;        //Int between 0 and p-1
        int b = 32;         //Int between 0 and p

        //Put into the form mx + b then mod by p
        val = (a * val + b) % p;

        //Mod by array length
        return val % DEFAULT_SIZE;

    }
}
