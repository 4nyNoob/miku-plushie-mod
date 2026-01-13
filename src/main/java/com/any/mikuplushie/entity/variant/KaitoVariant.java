package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KaitoVariant {

    KAITO_PLUSH (0, "kaito_plush"),
    KAITO_PLUSH_V3 (1, "kaito_plush_v3"),
    KAITO_PLUSH_V4 (2, "kaito_plush_v4"),
    ;

    private static final KaitoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(KaitoVariant::getId)).toArray(KaitoVariant[]::new);
    private final int id;
    private final String block;

    KaitoVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static KaitoVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
