package com.ancient.patchup.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public record NeoFabricModLoadedCondition(String modId) implements ResourceCondition {
    public static final MapCodec<NeoFabricModLoadedCondition> CODEC = Codec.STRING.fieldOf("modid")
            .xmap(NeoFabricModLoadedCondition::new, NeoFabricModLoadedCondition::modId);

    public static final ResourceConditionType<NeoFabricModLoadedCondition> TYPE = ResourceConditionType.create(
            Identifier.of("neofabric", "mod_loaded"),
            CODEC
    );

    public static void init() {
        ResourceConditions.register(TYPE);
    }

    @Override
    public ResourceConditionType<?> getType() {
        return TYPE;
    }

    @Override
    public boolean test(@Nullable RegistryWrapper.WrapperLookup registryLookup) {
        return FabricLoader.getInstance().isModLoaded(this.modId);
    }
}
