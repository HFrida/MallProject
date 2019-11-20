package com.company;

import java.util.Map;

public class Room {

    protected String name;
    protected Map<String, String> exits;

    public Room(String name, Map<String, String> exits) {
        this.name = name;
        this.exits = exits;
    }

    public Room() {
    }

    //public Map<String, String> getExits() {
    //    return exits;
    //}

    public boolean possibleExits(String direction) {
        return exits.containsKey(direction);
    }

    public String getDirection(String newDirection) {
        return exits.get(newDirection);
    }
}
