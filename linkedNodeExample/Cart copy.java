public class Cart implements ShoppingList {

    private Node head;

    @Override
    public void addItem(Product item) throws IllegalStateException {
        if (head == null) {
            head = new Node(item, null);

        } else {
            head = new Node(item, head);
        }
    }

    @Override
    public boolean removeItem(String item) {
        Node temp = head;
        boolean flag = false;

        while (temp != null) {
            if (item.equals(temp.data.getName())) {
                head = temp.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    @Override
    public double totalCost() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total = total + temp.data.getPrice();
            temp = temp.next;
        }
        return total;
    }

    @Override
    public void clearAll() {
        head = null;
    }

    @Override
    public String toString() {
        StringBuilder printedStack = new StringBuilder();
        Node temp = head;
        if (temp != null) {
            while (temp != null) {
                printedStack.append(temp.data.toString()).append(" ");
                temp = temp.next;
            }
            return printedStack.toString();
        } else {
            return "Cart is empty";
        }

    }

    private static class Node {
        Product data;
        Node next;

        public Node(Product data, Node next) {
            this.next = next;
            this.data = data;
        }

    }
}
