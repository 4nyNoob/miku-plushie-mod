package com.any.miku_plushie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Constants {

  public static final String OLD_MOD_ID = "miku-plushie";
  public static final String MOD_ID = "miku_plushie";
  public static final String MOD_NAME = "Miku Plushie";
  public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

  public static final List<String> PLUSH_NAMES = List.of(
      "miku",
      "aiko",
      "teto",
      "akita_neru",
      "rin",
      "len",
      "konoha",
      "luka",
      "meiko",
      "gumi",
      "kaito"
  );
  public static final List<String> PLUSH_BLOCK_NAMES = new ArrayList<>();
  public static final List<String> TETO_PICKAXE_NAMES = new ArrayList<>();
  public static final List<String> OTHER_ITEM_NAMES = new ArrayList<>();
  public static final List<String> OTHER_BLOCK_NAMES = new ArrayList<>();
}