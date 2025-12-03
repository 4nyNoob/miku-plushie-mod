package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum GumiVariant {

    GUMI_PLUSH (0, "gumi_plush"),
    ;

    private static final GumiVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(GumiVariant::getId)).toArray(GumiVariant[]::new);
    private final int id;
    private final String block;

    GumiVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static GumiVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
