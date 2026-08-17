package com.ancient.patchup;

import com.ancient.patchup.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PatchUpDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		var blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider((output, registries) -> new ModItemTagProvider(output, registries));
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(EnglishLangProvider::new);

	}
}
