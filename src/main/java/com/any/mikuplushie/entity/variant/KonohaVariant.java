package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KonohaVariant {

    KONOHA_PLUSH (0, "konoha_plush"),
    ;

    private static final KonohaVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(KonohaVariant::getId)).toArray(KonohaVariant[]::new);
    private final int id;
    private final String block;

    KonohaVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static KonohaVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
