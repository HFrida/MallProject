package com.company;

public class Police extends GameCharacter {

    private int saveMoney;

    public Police(int yPos, int xPos) {
        super(yPos, xPos);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int save (int saveMoney) {
        this.saveMoney = saveMoney * 2;
        return saveMoney;
    }
}
