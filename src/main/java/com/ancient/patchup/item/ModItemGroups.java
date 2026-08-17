package com.ancient.patchup.item;

import com.ancient.patchup.Compats;
import com.ancient.patchup.PatchUp;
import com.ancient.patchup.block.another_furniture.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final ItemGroup PATCH_UP_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PatchUp.MOD_ID, "patchup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.patchup_group"))
                    .icon(() -> new ItemStack(
                            Compats.ANOTHER_FURNITURE.isLoaded() ? Sofa.FOREST_SOFA.get() :
                            Items.STICK)).entries((displayContext, entries) -> {

                        if (Compats.ANOTHER_FURNITURE.isLoaded()) {
                            /* Stools */
                            for (Supplier<Block> stool : Stool.STOOLS.values()) {
                                entries.add(stool.get());
                            }
                            /* Tall Stools */
                            for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
                                entries.add(tallStool.get());
                            }
                            /* Sofas */
                            for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
                                entries.add(sofa.get());
                            }
                            /* Lamps */
                            for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
                                entries.add(lamp.get());
                            }
                            /* Curtains */
                            for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
                                entries.add(curtain.get());
                            }
                        }

                        if (Compats.FARMERS_DELIGHT.isLoaded()) {
                            for (com.ancient.patchup.block.farmers_delight.CanvasSigns.CanvasSignEntry entry : com.ancient.patchup.block.farmers_delight.CanvasSigns.ENTRIES) {
                                entries.add(entry.signItem());
                                entries.add(entry.hangingSignItem());
                            }
                        }

                        if (Compats.COMFORTS.isLoaded()) {
                            for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
                                entries.add(entry.hammockItem().get());
                                entries.add(entry.sleepingBagItem().get());
                            }
                        }

                    }).build());


    public static void registerItemGroups() {
        PatchUp.LOGGER.info("Registering Item Groups for " + PatchUp.MOD_ID);
    }
}
