package com.any.mikuplushie.worldgen.generators;

import com.any.mikuplushie.MikuPlushie;

public class ModWorldGeneration {
    public static void generateModWorldGeneration(){
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " World Gen");
        ModLeekGenerator.generateLeek();
    }
}
