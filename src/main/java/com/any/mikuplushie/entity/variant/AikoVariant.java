package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AikoVariant {

    AIKO_PLUSH (0, "aiko_plush"),
    ;

    private static final AikoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(AikoVariant::getId)).toArray(AikoVariant[]::new);
    private final int id;
    private final String block;

    AikoVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static AikoVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
