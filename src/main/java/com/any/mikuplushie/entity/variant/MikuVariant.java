package com.any.mikuplushie.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum MikuVariant {

    MIKU_PLUSH_BR (0, "miku_plush_br"),
    MIKU_PLUSH_BR_BA (1, "miku_plush_br_ba"),
    MIKU_PLUSH_BIK (2, "miku_plush_bik"),
    MIKU_PLUSH_BR_BEACH (3, "miku_plush_br_beach"),
    MIKU_PLUSH_BR_BRAID (4, "miku_plush_br_braid"),
    MIKU_PLUSH_BR_BA_DRUM (5, "miku_plush_br_ba_drum"),
    MIKU_PLUSH_BR_PA (6, "miku_plush_br_pa"),
    MIKU_PLUSH_BR_SP (7, "miku_plush_br_sp"),
    MIKU_PLUSH_BR_MG (8, "miku_plush_br_mg"),
    MIKU_PLUSH_BR_BROWN_BRO (9, "miku_plush_br_brown_bro"),
    MIKU_PLUSH_BR_ELECTRICIAN (10, "miku_plush_br_electrician"),
    MIKU_PLUSH_BR_BIK_ORANGE (11, "miku_plush_br_bik_orange"),
    MIKU_PLUSH_BR_AM (12, "miku_plush_br_am"),
    MIKU_PLUSH_BR_FUT_FLA (13, "miku_plush_br_fut_fla"),
    MIKU_PLUSH_BR_FUT_CRVG (14, "miku_plush_br_fut_crvg"),
    MIKU_PLUSH_BR_GO (15, "miku_plush_br_go"),
    MIKU_PLUSH_BR_SCHOOL_PE (16, "miku_plush_br_school_pe"),
    MIKU_PLUSH_BR_FUT_CAM (17, "miku_plush_br_fut_cam"),
    MIKU_PLUSH_BR_RS (18, "miku_plush_br_rs"),
    MIKU_PLUSH_FROG (19, "miku_plush_frog"),
    MIKU_PLUSH_MUSHROOM (20, "miku_plush_mushroom"),
    MIKU_PLUSH_SENBONZAKURA (21, "miku_plush_senbonzakura"),
    MIKU_PLUSH_URAOTOMELOVERS (22, "miku_plush_uraotomelovers"),
    MIKU_PLUSH_PERSONADANCING (23, "miku_plush_personadancing"),
    MIKU_PLUSH_HELLOPLANET (24, "miku_plush_helloplanet"),
    MIKU_PLUSH_HACHUNE (25, "miku_plush_hachune"),
    MIKU_PLUSH_ZATSUNE (26, "miku_plush_zatsune"),
    MIKU_PLUSH_INFINITY (27, "miku_plush_infinity"),
    MIKU_PLUSH_VAMPIRE (28, "miku_plush_vampire"),
    MIKU_PLUSH_WEREWOMAN (29, "miku_plush_werewoman"),
    MIKU_PLUSH_JASON (30, "miku_plush_jason"),
    MIKU_PLUSH_MICHAEL_MYERS (31, "miku_plush_michael_myers"),
    MIKU_PLUSH_PUMPKIN (32, "miku_plush_pumpkin"),
    MIKU_PLUSH_GHOSTFACE (33, "miku_plush_ghostface"),
    MIKU_PLUSH_FRANKENSTEIN (34, "miku_plush_frankenstein"),
    MIKU_PLUSH_MUMMY (35, "miku_plush_mummy"),
    MIKU_PLUSH_GHOST (36, "miku_plush_ghost"),
    MIKU_PLUSH_PATATI (37, "miku_plush_patati"),
    MIKU_PLUSH_PATATA (38, "miku_plush_patata"),
    MIKU_PLUSH_DEVIL (39, "miku_plush_devil"),
    MIKU_PLUSH_WITCH (40, "miku_plush_witch"),
    MIKU_PLUSH_SANTA (41, "miku_plush_santa"),
    MIKU_PLUSH_REINDEER (42, "miku_plush_reindeer"),
    MIKU_PLUSH_SANTA_ELF (43, "miku_plush_santa_elf"),
    MIKU_PLUSH_XMAS_TREE (44, "miku_plush_xmas_tree"),
    MIKU_PLUSH (45, "miku_plush"),
    MIKU_PLUSH_SONIC_CROSSWORLDS (46, "miku_plush_sonic_crossworlds"),
    MIKU_PLUSH_FORTNITE_NEKO (47, "miku_plush_fortnite_neko"),
    MIKU_PLUSH_V4 (48, "miku_plush_v4"),
    MIKU_PLUSH_MESMERIZER (49, "miku_plush_mesmerizer"),
    MIKU_PLUSH_SONIC (50, "miku_plush_sonic"),
    MIKU_PLUSH_DIGITAL_STARS_2025 (51, "miku_plush_digital_stars_2025"),
    MIKU_PLUSH_ROTTEN_GIRL (52, "miku_plush_rotten_girl"),
    MIKU_PLUSH_PSYCHO_MODE (53, "miku_plush_psycho_mode"),
    MIKU_PLUSH_DONT_BELIEVE_IN_T (54, "miku_plush_dont_believe_in_t"),
    MIKU_PLUSH_STATIC (55, "miku_plush_static"),
    MIKU_PLUSH_MOCHIMOCHI (56, "miku_plush_mochimochi"),
    MIKU_PLUSH_MONITORING (57, "miku_plush_monitoring"),
    MIKU_PLUSH_HOLLOW_KNIGHT (58, "miku_plush_hollow_knight"),
    MIKU_PLUSH_HORNET (59, "miku_plush_hornet"),
    MIKU_PLUSH_WORLD_IS_MINE (60, "miku_plush_world_is_mine"),
    MIKU_PLUSH_ROLLING_GIRL (61, "miku_plush_rolling_girl"),
    MIKU_PLUSH_DEEP_SEA_GIRL (62, "miku_plush_deep_sea_girl"),
    MIKU_PLUSH_LUCARIO_Z (63, "miku_plush_lucario_z"),
    ;

    private static final MikuVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(MikuVariant::getId)).toArray(MikuVariant[]::new);
    private final int id;
    private final String block;

    MikuVariant (int id, String block) {
        this.id = id;
        this.block = block;
    }

    public int getId () {
        return id;
    }

    public String getBlock () {
        return block;
    }

    public static MikuVariant byId (int id) {
        return BY_ID[id % BY_ID.length];
    }
}
