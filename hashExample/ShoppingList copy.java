/*
 * @author Delaware Technical Community College
 * Starter and/or reference code provided for Delaware Technical Community College courses.
 */

public interface ShoppingList {
    /**
     * Adds a new entry to this shopping list.
     *
     * @param item A product to be added to this shopping list.
     * @throws IllegalStateException- if the product cannot be added at this time due to capacity restrictions
     */    public void addItem(Product item) throws IllegalStateException;

    /**
     * Removes and returns true if the product was successfully removed.
     *
     * @param item the name of the product to be removed.
     * @return true if the product was successfully removed from the shopping list.
     * @return false if the product was not found in the shopping list
     */    public boolean removeItem(String item);

    /**
     * Clears (removes) all items from the shopping list.
     *
     */    public void clearAll();
}