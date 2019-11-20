package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Shop extends Room {

    private ArrayList<Item> items;
    private SalesPerson person;


    public Shop(String name, Map<String, String> exits, ArrayList<Item> items, SalesPerson person) {
        super(name, exits);
        this.items = items;
        this.person = person;
    }

    public Shop(String name, Map<String, String> exits, ArrayList<Item> items) {
        super(name, exits);
        this.items = items;
        this.person = null;
    }
    public Shop(String name, Map<String, String> exits) {
        super(name, exits);
    }

    public Item buyItem(String foundItem) {
        for (Item item : items) {
            if (foundItem.equalsIgnoreCase(item.getName())) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public SalesPerson getPerson() {
        return person;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    @Override
    public String toString() {
        StringBuilder descriptionString = new StringBuilder();
        descriptionString.append(name).append("\n");
        if (items == null) {
            descriptionString.append("There are no items for sale here \n");
        }
        else {
            descriptionString.append("These items are for sale in this shop: \n");
            for (Item item : items) {
                descriptionString.append(item.getName()).append(", ").append(item.getPrice()).append(" kr").append("\n");
            }
        }
        descriptionString.append("You can se exits to the:\n");
        for (String exit : exits.keySet()) {
            descriptionString.append(exit).append(", ");
        }
        return descriptionString.subSequence(0, descriptionString.length()-2).toString();
    }

}
