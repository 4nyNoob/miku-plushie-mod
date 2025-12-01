package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum MeikoVariant {

    MEIKO_PLUSH (0, "meiko_plush"),
    ;

    private static final MeikoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(MeikoVariant::getId)).toArray(MeikoVariant[]::new);
    private final int id;
    private final String block;

    MeikoVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static MeikoVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
