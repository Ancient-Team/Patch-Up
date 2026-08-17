package com.ancient.patchup.block.comforts;

import com.illusivesoulworks.comforts.common.ComfortsRegistry;
import com.illusivesoulworks.comforts.common.block.HammockBlock;
import com.illusivesoulworks.comforts.common.block.SleepingBagBlock;
import com.illusivesoulworks.comforts.common.item.HammockItem;
import com.illusivesoulworks.comforts.common.item.SleepingBagItem;
import com.illusivesoulworks.comforts.common.registry.RegistryObject;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;

public class ComfortsItems {

    public record ComfortsEntry(
            DDDyes dye,
            RegistryObject<Block> hammockBlock,
            RegistryObject<Item> hammockItem,
            RegistryObject<Block> sleepingBagBlock,
            RegistryObject<Item> sleepingBagItem
    ) {}

    public static final List<ComfortsEntry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();
            String name = dye.asString();

            RegistryObject<Block> hammock = ComfortsRegistry.BLOCKS.register("hammock_" + name,
                    () -> new HammockBlock(color));
            RegistryObject<Item> hammockItem = ComfortsRegistry.ITEMS.register("hammock_" + name,
                    () -> new HammockItem(hammock.get()));

            RegistryObject<Block> sleepingBag = ComfortsRegistry.BLOCKS.register("sleeping_bag_" + name,
                    () -> new SleepingBagBlock(color));
            RegistryObject<Item> sleepingBagItem = ComfortsRegistry.ITEMS.register("sleeping_bag_" + name,
                    () -> new SleepingBagItem(sleepingBag.get()));

            ComfortsRegistry.HAMMOCKS.put(color, hammock);
            ComfortsRegistry.SLEEPING_BAGS.put(color, sleepingBag);

            ComfortsRegistry.HAMMOCK_BLOCK_ENTITY.get().addSupportedBlock(hammock.get());
            ComfortsRegistry.SLEEPING_BAG_BLOCK_ENTITY.get().addSupportedBlock(sleepingBag.get());

            ENTRIES.add(new ComfortsEntry(dye, hammock, hammockItem, sleepingBag, sleepingBagItem));
        }
    }
}
