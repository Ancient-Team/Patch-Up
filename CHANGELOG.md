# Changelog

## [1.0.0-beta.9.1+1.21.1]

### Fixes & Improvements
* **Pickaxe & Mod Tags (Mining Fix)**:
  * Fixed an issue where `minecraft:mineable/pickaxe` broke for players running the mod without Refined Storage installed due to unconditioned tag entries in resources.
  * Moved Refined Storage pickaxe mineable block tags into Fabric Data Generation (`ModBlockTagProvider`) so all 336 blocks are marked optional (`"required": false`), preventing Minecraft from failing tag loading when Refined Storage is absent.
  * Moved all 21 Refined Storage item tags into Fabric Data Generation (`ModItemTagProvider`) with optional entries (`"required": false`), eliminating missing tag reference warnings when Refined Storage is absent.
  * Removed static unconditioned tag JSON files from resources.

## [1.0.0-beta.9+1.21.1]

### Features & Additions
* **Refined Storage Compatibility**:
  * Added full support for 16 Dye Depot color variants across 21 Refined Storage network blocks and devices (336 color variants total):
    * **Cables**: `<color>_cable` (connecting properly by color and with neutral cables).
    * **Controllers**: `<color>_controller` and `<color>_creative_controller` with animated LED display cutout textures.
    * **Grids**: Standard Grid, Crafting Grid, and Pattern Grid (`<color>_grid`, `<color>_crafting_grid`, `<color>_pattern_grid`).
    * **Network Devices**: Importer, Exporter, External Storage, Detector, Destructor, Constructor, Wireless Transmitter, Network Receiver, Network Transmitter, Relay, Disk Interface, and Security Manager.
    * **Autocrafting**: Autocrafter, Autocrafter Manager, and Autocrafting Monitor.
  * Added 336 blockstates and 624 model definitions (block models with emissive cutout textures and custom RS item models).
  * Generated 21 procedural cutout and cable textures for all 16 Dye Depot colors (`maroon`, `rose`, `coral`, `indigo`, `navy`, `slate`, `olive`, `amber`, `beige`, `teal`, `mint`, `aqua`, `verdant`, `forest`, `ginger`, `tan`).
  * Added 320 recoloring recipes (`refinedstorage:recoloring`) with `fabric:load_conditions` supporting crafting grid dyeing from any color to another.
  * Added 336 block drop loot tables preserving block entity custom names and controller energy states.
  * Extended 21 Refined Storage item tags and added all blocks to `minecraft:mineable/pickaxe`.
  * Added dedicated creative inventory tab: **Patch Up: Refined Storage** (`itemgroup.patchup.refined_storage`).

## [1.0.0-beta.8+1.21.1]

### Features & Additions
* **Snowy Spirit Compatibility**:
  * Added 16 Dye Depot color variants for Glow Lights (blocks, items, procedural recolor respecting natural pine garland, recipes, dyeing recipes, and loot tables).
  * Added 16 Dye Depot color variants for Gumdrops (blocks, items, procedural recolor, recipes, dyeing recipes, and loot tables).
  * Added 16 Dye Depot color variants for Sleds and Chest Sleds (items, entities, models, textures, recipes).
  * Added 16 Dye Depot color variants for Winter Hats (armor items, models, textures, recipes).
* **Sleep Tight Compatibility**:
  * Added support for 16 Dye Depot color variants of hammocks (blocks, items, procedural recolor, crafting & dyeing recipes, tags, and creative tab integration).
* **Amendments Compatibility**:
  * Added static blockstate definitions and tags for all 16 Dye Depot ceiling banners (`ceiling_banner_<color>`).

### Fixes & Improvements
* **Snowy Spirit Particles**: Fixed `IllegalAccessError` on `BillboardParticle.scale` when rendering Glow Light particles (`GlowLightParticleMixin`, `BillboardParticleAccessor`, and `PatchUpMixinPlugin`).
* **Resource Conditions**: Added `NeoFabricModLoadedCondition` (`neofabric:mod_loaded`) to resolve recipe condition parsing errors on Fabric for mods ported with NeoFabric tooling (e.g. Snowy Spirit ginger crates).
* **Amendments Blockstates**: Fixed 128 model loading errors and warnings caused by Moonlight dynamic resource generator creating invalid blockstate combinations for Dye Depot ceiling banners.
* **Sleep Tight Advancement**: Fixed `sleep_tight:husbandry/hammock` advancement parsing error in Minecraft 1.21 and added `fabric:load_conditions` so it loads conditionally only when Sleep Tight is installed.
* **Arts & Crafts Compatibility**: Fixed an `AbstractMethodError` crash when rendering Dyed Decorated Pots in inventories, creative menu tabs, or JEI by using Fabric's `BuiltinItemRenderer` (5-parameter signature).
* **Fabric Attachment Disconnect**: Fixed `Connection Lost: Received attachment change for unknown target!` race condition on chunk loading (`AttachmentChangeMixin`).
* **Supplementaries & SuppSquared Candle Holders**: Fixed texture generator to only recolor the candle wax while preserving the iron/gold base holder texture.
* **SuppSquared Textures**: Fixed a path typo in asset generation affecting verdant sack models (`suppsquaverdant` namespace bug).
* **Build System**: Enforced `DuplicatesStrategy.EXCLUDE` across all archive tasks in `build.gradle`.
