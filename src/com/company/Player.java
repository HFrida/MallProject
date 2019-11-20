package com.company;

import java.util.ArrayList;

public class Player extends GameCharacter implements CashReduce {

    private int cash;
    protected ArrayList<Item> inventory;

    public Player(int yPos, int xPos) {
        super(yPos, xPos);
        this.inventory = new ArrayList<Item>();
    }

    public void exit(String playerPosition) {
        if (xPos == 0) {
            xPos++;
        }
        else if (xPos == 2) {
            xPos--;
        }
        }

    public void enter(String playerDirection) {
        switch (playerDirection) {
            case "H&M":
                xPos--;
                break;
            case "SCORETT":
                xPos++;
                break;
            case "SMYCKA":
                xPos--;
                break;
            case "ATM":
                xPos++;
                break;
            case "GAME STOP":
                xPos--;
                break;
            case "ARKEN ZOO":
                xPos++;
                break;
            case "MQ":
                xPos--;
                break;
            case "APOTEKET":
                xPos++;
                break;
            case "INTERSPORT":
                xPos--;
                break;
            case "PRESSBYRÅN":
                xPos++;
                break;
        }
    }

    public void move(String playerDirection) {
        switch (playerDirection) {
            case "E":
                xPos++;
                break;
            case "W" :
                xPos--;
                break;
            case "N":
                yPos--;
                break;
            case "S":
                yPos++;
                break;
        }
    }
    public void addInventory (Item item) {
        inventory.add(item);
    }
    public void buyItem(int cash) {
        this.cash -= cash;
    }

    public void withdrawal(int amount) {
        this.cash += amount;
    }

    @Override
    public int cashReduceMethod(int cash) {
        this.cash -= cash;
        return cash;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

}