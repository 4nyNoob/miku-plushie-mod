package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum NeruVariant {

    NERU_PLUSH(0, "akita_neru_plush"),
    NERU_PLUSH_TAILS(1, "akita_neru_plush_tails")
    ;

    private static final NeruVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(NeruVariant::getId)).toArray(NeruVariant[]::new);
    private final int id;
    private final String block;

    NeruVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static NeruVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
