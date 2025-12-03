package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum LenVariant {

    LEN_PLUSH (0, "len_plush"),
    ;

    private static final LenVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(LenVariant::getId)).toArray(LenVariant[]::new);
    private final int id;
    private final String block;

    LenVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static LenVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
