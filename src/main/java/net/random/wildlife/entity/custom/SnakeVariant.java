package net.random.wildlife.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum SnakeVariant {
    DEFAULT(0),
    WARM(1),
    JUNGLE(2);

    private static final SnakeVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SnakeVariant::getId)).toArray(SnakeVariant[]::new);
    private final int id;

    SnakeVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static SnakeVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }

}
