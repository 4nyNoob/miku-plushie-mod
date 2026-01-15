package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum RinVariant {

    RIN_PLUSH (0, "rin_plush"),
    ;

    private static final RinVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(RinVariant::getId)).toArray(RinVariant[]::new);
    private final int id;
    private final String block;

    RinVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static RinVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
