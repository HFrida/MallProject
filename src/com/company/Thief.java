package com.company;

public class Thief extends GameCharacter {

    private int stealMoney;

    public Thief(int yPos, int xPos, int stealMoney) {
        super(yPos, xPos);
        this.stealMoney = stealMoney;
    }

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }


     public int getStealMoney() {
        return stealMoney;
    }
}
