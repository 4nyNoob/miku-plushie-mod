package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum LukaVariant {

    LUKA_PLUSH (0, "luka_plush"),
    ;

    private static final LukaVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(LukaVariant::getId)).toArray(LukaVariant[]::new);
    private final int id;
    private final String block;

    LukaVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static LukaVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
