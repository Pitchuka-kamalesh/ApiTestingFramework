package com.inheritancee;

public interface First extends Second,Third {
    @Override
    default void data() {

    }

}

interface Second {
    String nam = "000";
    public void data();

}


interface Third {
    String nam = "Third";
}
