package com.ancient.patchup.datagen;

import com.ancient.patchup.block.*;
import com.ancient.patchup.block.another_furniture.Lamp;
import com.ancient.patchup.block.another_furniture.Sofa;
import com.ancient.patchup.block.another_furniture.Stool;
import com.ancient.patchup.block.another_furniture.TallStool;
import com.ancient.patchup.block.heart_and_home.Paper_Lantern;
import com.ancient.patchup.block.heart_and_home.Shingles;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        /* Built */
        addDrop(Trims.MAROON_TERRACOTTA_TRIM);
        addDrop(Trims.ROSE_TERRACOTTA_TRIM);
        addDrop(Trims.CORAL_TERRACOTTA_TRIM);
        addDrop(Trims.GINGER_TERRACOTTA_TRIM);
        addDrop(Trims.TAN_TERRACOTTA_TRIM);
        addDrop(Trims.BEIGE_TERRACOTTA_TRIM);
        addDrop(Trims.AMBER_TERRACOTTA_TRIM);
        addDrop(Trims.OLIVE_TERRACOTTA_TRIM);
        addDrop(Trims.FOREST_TERRACOTTA_TRIM);
        addDrop(Trims.VERDANT_TERRACOTTA_TRIM);
        addDrop(Trims.TEAL_TERRACOTTA_TRIM);
        addDrop(Trims.MINT_TERRACOTTA_TRIM);
        addDrop(Trims.AQUA_TERRACOTTA_TRIM);
        addDrop(Trims.SLATE_TERRACOTTA_TRIM);
        addDrop(Trims.NAVY_TERRACOTTA_TRIM);
        addDrop(Trims.INDIGO_TERRACOTTA_TRIM);

        /* Stool */
        addDrop(Stool.MAROON_STOOL.get());
        addDrop(Stool.ROSE_STOOL.get());
        addDrop(Stool.CORAL_STOOL.get());
        addDrop(Stool.GINGER_STOOL.get());
        addDrop(Stool.TAN_STOOL.get());
        addDrop(Stool.BEIGE_STOOL.get());
        addDrop(Stool.AMBER_STOOL.get());
        addDrop(Stool.OLIVE_STOOL.get());
        addDrop(Stool.FOREST_STOOL.get());
        addDrop(Stool.VERDANT_STOOL.get());
        addDrop(Stool.TEAL_STOOL.get());
        addDrop(Stool.MINT_STOOL.get());
        addDrop(Stool.AQUA_STOOL.get());
        addDrop(Stool.SLATE_STOOL.get());
        addDrop(Stool.NAVY_STOOL.get());
        addDrop(Stool.INDIGO_STOOL.get());

        /* Tall Stool */
        addDrop(TallStool.MAROON_TALL_STOOL.get());
        addDrop(TallStool.ROSE_TALL_STOOL.get());
        addDrop(TallStool.CORAL_TALL_STOOL.get());
        addDrop(TallStool.GINGER_TALL_STOOL.get());
        addDrop(TallStool.TAN_TALL_STOOL.get());
        addDrop(TallStool.BEIGE_TALL_STOOL.get());
        addDrop(TallStool.AMBER_TALL_STOOL.get());
        addDrop(TallStool.OLIVE_TALL_STOOL.get());
        addDrop(TallStool.FOREST_TALL_STOOL.get());
        addDrop(TallStool.VERDANT_TALL_STOOL.get());
        addDrop(TallStool.TEAL_TALL_STOOL.get());
        addDrop(TallStool.MINT_TALL_STOOL.get());
        addDrop(TallStool.AQUA_TALL_STOOL.get());
        addDrop(TallStool.SLATE_TALL_STOOL.get());
        addDrop(TallStool.NAVY_TALL_STOOL.get());
        addDrop(TallStool.INDIGO_TALL_STOOL.get());

        /* Sofa */
        addDrop(Sofa.MAROON_SOFA.get());
        addDrop(Sofa.ROSE_SOFA.get());
        addDrop(Sofa.CORAL_SOFA.get());
        addDrop(Sofa.GINGER_SOFA.get());
        addDrop(Sofa.TAN_SOFA.get());
        addDrop(Sofa.BEIGE_SOFA.get());
        addDrop(Sofa.AMBER_SOFA.get());
        addDrop(Sofa.OLIVE_SOFA.get());
        addDrop(Sofa.FOREST_SOFA.get());
        addDrop(Sofa.VERDANT_SOFA.get());
        addDrop(Sofa.TEAL_SOFA.get());
        addDrop(Sofa.MINT_SOFA.get());
        addDrop(Sofa.AQUA_SOFA.get());
        addDrop(Sofa.SLATE_SOFA.get());
        addDrop(Sofa.NAVY_SOFA.get());
        addDrop(Sofa.INDIGO_SOFA.get());

        /* Lamp */
        addDrop(Lamp.MAROON_LAMP.get());
        addDrop(Lamp.ROSE_LAMP.get());
        addDrop(Lamp.CORAL_LAMP.get());
        addDrop(Lamp.GINGER_LAMP.get());
        addDrop(Lamp.TAN_LAMP.get());
        addDrop(Lamp.BEIGE_LAMP.get());
        addDrop(Lamp.AMBER_LAMP.get());
        addDrop(Lamp.OLIVE_LAMP.get());
        addDrop(Lamp.FOREST_LAMP.get());
        addDrop(Lamp.VERDANT_LAMP.get());
        addDrop(Lamp.TEAL_LAMP.get());
        addDrop(Lamp.MINT_LAMP.get());
        addDrop(Lamp.AQUA_LAMP.get());
        addDrop(Lamp.SLATE_LAMP.get());
        addDrop(Lamp.NAVY_LAMP.get());
        addDrop(Lamp.INDIGO_LAMP.get());

        /* Paper Lantern */
        addDrop(Paper_Lantern.MAROON_PAPER_LANTERN);
        addDrop(Paper_Lantern.ROSE_PAPER_LANTERN);
        addDrop(Paper_Lantern.CORAL_PAPER_LANTERN);
        addDrop(Paper_Lantern.GINGER_PAPER_LANTERN);
        addDrop(Paper_Lantern.TAN_PAPER_LANTERN);
        addDrop(Paper_Lantern.BEIGE_PAPER_LANTERN);
        addDrop(Paper_Lantern.AMBER_PAPER_LANTERN);
        addDrop(Paper_Lantern.OLIVE_PAPER_LANTERN);
        addDrop(Paper_Lantern.FOREST_PAPER_LANTERN);
        addDrop(Paper_Lantern.VERDANT_PAPER_LANTERN);
        addDrop(Paper_Lantern.TEAL_PAPER_LANTERN);
        addDrop(Paper_Lantern.MINT_PAPER_LANTERN);
        addDrop(Paper_Lantern.AQUA_PAPER_LANTERN);
        addDrop(Paper_Lantern.SLATE_PAPER_LANTERN);
        addDrop(Paper_Lantern.NAVY_PAPER_LANTERN);
        addDrop(Paper_Lantern.INDIGO_PAPER_LANTERN);

        /* Shingles */
        addDrop(Shingles.MAROON_SHINGLES);
        addDrop(Shingles.MAROON_SHINGLE_STAIRS);
        addDrop(Shingles.MAROON_SHINGLE_SLAB);
        addDrop(Shingles.ROSE_SHINGLES);
        addDrop(Shingles.ROSE_SHINGLE_STAIRS);
        addDrop(Shingles.ROSE_SHINGLE_SLAB);
        addDrop(Shingles.CORAL_SHINGLES);
        addDrop(Shingles.CORAL_SHINGLE_STAIRS);
        addDrop(Shingles.CORAL_SHINGLE_SLAB);
        addDrop(Shingles.GINGER_SHINGLES);
        addDrop(Shingles.GINGER_SHINGLE_STAIRS);
        addDrop(Shingles.GINGER_SHINGLE_SLAB);
        addDrop(Shingles.TAN_SHINGLES);
        addDrop(Shingles.TAN_SHINGLE_STAIRS);
        addDrop(Shingles.TAN_SHINGLE_SLAB);
        addDrop(Shingles.BEIGE_SHINGLES);
        addDrop(Shingles.BEIGE_SHINGLE_STAIRS);
        addDrop(Shingles.BEIGE_SHINGLE_SLAB);
        addDrop(Shingles.AMBER_SHINGLES);
        addDrop(Shingles.AMBER_SHINGLE_STAIRS);
        addDrop(Shingles.AMBER_SHINGLE_SLAB);
        addDrop(Shingles.OLIVE_SHINGLES);
        addDrop(Shingles.OLIVE_SHINGLE_STAIRS);
        addDrop(Shingles.OLIVE_SHINGLE_SLAB);
        addDrop(Shingles.FOREST_SHINGLES);
        addDrop(Shingles.FOREST_SHINGLE_STAIRS);
        addDrop(Shingles.FOREST_SHINGLE_SLAB);
        addDrop(Shingles.VERDANT_SHINGLES);
        addDrop(Shingles.VERDANT_SHINGLE_STAIRS);
        addDrop(Shingles.VERDANT_SHINGLE_SLAB);
        addDrop(Shingles.TEAL_SHINGLES);
        addDrop(Shingles.TEAL_SHINGLE_STAIRS);
        addDrop(Shingles.TEAL_SHINGLE_SLAB);
        addDrop(Shingles.MINT_SHINGLES);
        addDrop(Shingles.MINT_SHINGLE_STAIRS);
        addDrop(Shingles.MINT_SHINGLE_SLAB);
        addDrop(Shingles.AQUA_SHINGLES);
        addDrop(Shingles.AQUA_SHINGLE_STAIRS);
        addDrop(Shingles.AQUA_SHINGLE_SLAB);
        addDrop(Shingles.SLATE_SHINGLES);
        addDrop(Shingles.SLATE_SHINGLE_STAIRS);
        addDrop(Shingles.SLATE_SHINGLE_SLAB);
        addDrop(Shingles.NAVY_SHINGLES);
        addDrop(Shingles.NAVY_SHINGLE_STAIRS);
        addDrop(Shingles.NAVY_SHINGLE_SLAB);
        addDrop(Shingles.INDIGO_SHINGLES);
        addDrop(Shingles.INDIGO_SHINGLE_STAIRS);
        addDrop(Shingles.INDIGO_SHINGLE_SLAB);

        /* Stained Barred Glass Pane */
    }
}