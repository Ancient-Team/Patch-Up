package com.ancient.patchup;

import net.fabricmc.loader.api.FabricLoader;

public enum Compats {
    ANOTHER_FURNITURE("another_furniture"),
    FARMERS_DELIGHT("farmersdelight"),
    COMFORTS("comforts"),
    ARTS_AND_CRAFTS("arts_and_crafts"),
    SUPPLEMENTARIES("supplementaries"),
    SUPP_SQUARED("suppsquared"),
    AMENDMENTS("amendments");

    private final String id;

    Compats(String id) {
        this.id = id;
    }

    public boolean isLoaded() {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    public String getId() {
        return id;
    }
}
