package net.random.wildlife.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum ButterflyVariant {
    HEART(0),
    MONARCH(1),
    OWL(2),
    BLUEISH(3),
    RED(4),
    YELLOW(5),
    CORAL(6),
    GRAY(7),
    RAINBOW(8),
    BLACK(9);

    private static final ButterflyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ButterflyVariant::getId)).toArray(ButterflyVariant[]::new);
    private final int id;

    ButterflyVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static ButterflyVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
