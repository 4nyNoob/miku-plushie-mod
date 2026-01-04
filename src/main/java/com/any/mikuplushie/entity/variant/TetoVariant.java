package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum TetoVariant {

    TETO_PLUSH(0, "teto_plush"),
    TETO_PLUSH_MESMERIZER(1, "teto_plush_mesmerizer"),
    TETO_PLUSH_SHADOW(2, "teto_plush_shadow"),
    TETO_PLUSH_BIRDBRAIN(3, "teto_plush_birdbrain"),
    TETO_PLUSH_REGRET_ROCK(4, "teto_plush_regret_rock"),
    TETO_PLUSH_DONT_BELIEVE_IN_T(5, "teto_plush_dont_believe_in_t"),
    TETO_PLUSH_LIAR_DANCER(6, "teto_plush_liar_dancer"),
    TETO_PLUSH_WHATCHACALLITSNAME(7, "teto_plush_whatchacallitsname"),
    TETO_PLUSH_SOME_MORE_OF_THAT_SONG(8, "teto_plush_some_more_of_that_song"),
    TETO_PLUSH_LOBSTER(9, "teto_plush_lobster"),
    TETO_PLUSH_SYNTHV(10, "teto_plush_synthv"),
    TETO_PLUSH_SPOKEN_FOR(11, "teto_plush_spoken_for"),
    TETO_PLUSH_PPPP(11, "teto_plush_pppp"),
    TETO_PLUSH_SHRIMP(12, "teto_plush_shrimp"),

    ;

    private static final TetoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(TetoVariant::getId)).toArray(TetoVariant[]::new);
    private final int id;
    private final String block;

    TetoVariant(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static TetoVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
