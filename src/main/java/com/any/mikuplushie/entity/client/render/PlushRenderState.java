package com.any.mikuplushie.entity.client.render;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import java.util.HashMap;
import java.util.Map;

public class PlushRenderState extends LivingEntityRenderState implements GeoRenderState {
    private final Map<DataTicket<?>, Object> data = new HashMap<>();
    public String plushName;
    public String variant;
    public boolean dancing;
    public boolean attacking;
    public float healthRatio;
    @Override
    public Map<DataTicket<?>, Object> getDataMap() { return data; }
    // EntityRenderState's GeckoLib mixin writes directly to its own map.
    // Keep writes and reads together when supplying a custom map here.
    @Override
    public <D> void addGeckolibData(DataTicket<D> ticket, D value) { data.put(ticket, value); }
    @Override
    public boolean hasGeckolibData(DataTicket<?> ticket) { return data.containsKey(ticket); }
}
