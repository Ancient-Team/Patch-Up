package com.ancient.patchup;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatchUp implements ModInitializer {
	public static final String MOD_ID = "patchup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		if (Compats.ANOTHER_FURNITURE.isLoaded()) {
			Stool.init();
			Stool.registerFlammables();
			TallStool.init();
			TallStool.registerFlammables();
			Sofa.init();
			Sofa.registerFlammables();
			Lamp.init();
			Lamp.registerFlammables();
			Curtain.init();
			Curtain.registerFlammables();
		}

		if (Compats.FARMERS_DELIGHT.isLoaded()) {
			com.ancient.patchup.block.farmers_delight.CanvasSigns.init();
		}

		if (Compats.COMFORTS.isLoaded()) {
			com.ancient.patchup.block.comforts.ComfortsItems.init();
		}

	}
}