package com.ancient.patchup.datagen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AssetGenerator {

    public record ColorDef(String name, int rgb) {}

    public static final ColorDef[] COLORS = new ColorDef[]{
            new ColorDef("maroon", 0x7B2813),
            new ColorDef("rose", 0xFF5E64),
            new ColorDef("coral", 0xDF7758),
            new ColorDef("indigo", 0x331E57),
            new ColorDef("navy", 0x153D64),
            new ColorDef("slate", 0x4C5E86),
            new ColorDef("olive", 0x8C8F2A),
            new ColorDef("amber", 0xD7AF00),
            new ColorDef("beige", 0xE1D5A3),
            new ColorDef("teal", 0x2F7B67),
            new ColorDef("mint", 0x38CE7D),
            new ColorDef("aqua", 0x5EF0CC),
            new ColorDef("verdant", 0x255714),
            new ColorDef("forest", 0x32A326),
            new ColorDef("ginger", 0xCF6121),
            new ColorDef("tan", 0xF49C5D)
    };

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Asset Generator for Supplementaries and SuppSquared...");

        Path baseDir = Paths.get("src/main/resources/assets");
        Path loomCache = Paths.get(".gradle/loom-cache/remapped_mods/remapped/maven/modrinth");

        File suppJar = findJar(loomCache, "supplementaries-652de5e3");
        File suppSqJar = findJar(loomCache, "supplementaries-squared-652de5e3");

        System.out.println("Supplementaries JAR: " + suppJar);
        System.out.println("SuppSquared JAR: " + suppSqJar);

        if (suppJar != null && suppJar.exists()) {
            generateSupplementariesAssets(baseDir.resolve("supplementaries"), suppJar);
        }

        if (suppSqJar != null && suppSqJar.exists()) {
            generateSuppSquaredAssets(baseDir.resolve("suppsquared"), suppSqJar);
        }

        System.out.println("Asset generation completed successfully!");
    }

    private static File findJar(Path root, String prefix) throws IOException {
        try (var stream = Files.walk(root)) {
            return stream.filter(p -> p.getFileName().toString().contains(prefix) && p.toString().endsWith(".jar"))
                    .map(Path::toFile)
                    .findFirst()
                    .orElse(null);
        }
    }

    private static void generateSupplementariesAssets(Path outDir, File suppJar) throws Exception {
        try (ZipFile zip = new ZipFile(suppJar)) {
            // Load templates
            BufferedImage awningTemplate = readImage(zip, "assets/supplementaries/textures/block/awnings/awning_white.png");
            BufferedImage awningSideTemplate = readImage(zip, "assets/supplementaries/textures/block/awnings/awning_white_side.png");
            BufferedImage buntingTemplate = readImage(zip, "assets/supplementaries/textures/block/buntings/bunting_white.png");
            BufferedImage wallBuntingTemplate = readImage(zip, "assets/supplementaries/textures/block/buntings/wall_bunting_white.png");
            BufferedImage buntingItemTemplate = readImage(zip, "assets/supplementaries/textures/item/buntings/bunting_white.png");
            BufferedImage candleHolderItemTemplate = readImage(zip, "assets/supplementaries/textures/item/candle_holders/white.png");

            BufferedImage presentSideTemplate = readImage(zip, "assets/supplementaries/textures/block/presents/present_side_white.png");
            BufferedImage presentTopTemplate = readImage(zip, "assets/supplementaries/textures/block/presents/present_top_white.png");
            BufferedImage presentBottomTemplate = readImage(zip, "assets/supplementaries/textures/block/presents/present_bottom_white.png");
            BufferedImage presentInsideTemplate = readImage(zip, "assets/supplementaries/textures/block/presents/present_inside_white.png");
            BufferedImage presentTrappedTemplate = readImage(zip, "assets/supplementaries/textures/block/presents/present_trapped_white.png");

            String awningBlockstateTemplate = readString(zip, "assets/supplementaries/blockstates/awning_red.json");
            String candleHolderBlockstateTemplate = readString(zip, "assets/supplementaries/blockstates/candle_holder_red.json");
            String presentBlockstateTemplate = readString(zip, "assets/supplementaries/blockstates/present_red.json");
            String trappedPresentBlockstateTemplate = readString(zip, "assets/supplementaries/blockstates/trapped_present_red.json");

            for (ColorDef col : COLORS) {
                String c = col.name();
                int rgb = col.rgb();

                // 1. Awnings
                // Textures
                writeImage(recolor(awningTemplate, rgb), outDir.resolve("textures/block/awnings/awning_" + c + ".png"));
                writeImage(recolor(awningSideTemplate, rgb), outDir.resolve("textures/block/awnings/awning_" + c + "_side.png"));

                // Blockstate
                String bsAwning = awningBlockstateTemplate.replace("red", c);
                writeString(bsAwning, outDir.resolve("blockstates/awning_" + c + ".json"));

                // Block Models
                writeString(awningModel("supplementaries:block/awnings/top", c), outDir.resolve("models/block/awnings/" + c + "_top.json"));
                writeString(awningModel("supplementaries:block/awnings/top_slanted", c), outDir.resolve("models/block/awnings/" + c + "_top_slanted.json"));
                writeString(awningModel("supplementaries:block/awnings/bottom", c), outDir.resolve("models/block/awnings/" + c + "_bottom.json"));
                writeString(awningModel("supplementaries:block/awnings/bottom_slanted", c), outDir.resolve("models/block/awnings/" + c + "_bottom_slanted.json"));

                // Item Model
                writeString(awningItemModel(c), outDir.resolve("models/item/awning_" + c + ".json"));

                // 2. Buntings
                // Textures
                writeImage(recolor(buntingTemplate, rgb), outDir.resolve("textures/block/buntings/bunting_" + c + ".png"));
                writeImage(recolor(wallBuntingTemplate, rgb), outDir.resolve("textures/block/buntings/wall_bunting_" + c + ".png"));
                writeImage(recolor(buntingItemTemplate, rgb), outDir.resolve("textures/item/buntings/bunting_" + c + ".png"));

                // Blockstates
                writeString(buntingCeilingBlockstate(c), outDir.resolve("blockstates/bunting_" + c + ".json"));
                writeString(buntingWallBlockstate(c), outDir.resolve("blockstates/bunting_wall_" + c + ".json"));

                // Block Models
                writeString(buntingCeilingModel(c), outDir.resolve("models/block/buntings/" + c + "_ceiling.json"));
                writeString(buntingWallModel(c), outDir.resolve("models/block/buntings/" + c + "_wall.json"));

                // Item Model
                writeString(buntingItemModel(c), outDir.resolve("models/item/bunting_" + c + ".json"));

                // 3. Candle Holders
                // Texture
                writeImage(recolor(candleHolderItemTemplate, rgb), outDir.resolve("textures/item/candle_holders/" + c + ".png"));

                // Blockstate
                String bsCandle = candleHolderBlockstateTemplate.replace("red", c);
                writeString(bsCandle, outDir.resolve("blockstates/candle_holder_" + c + ".json"));

                // Item Model
                writeString(candleHolderItemModel("supplementaries", c), outDir.resolve("models/item/candle_holder_" + c + ".json"));

                // 30 Block Models
                generateCandleHolderBlockModels("supplementaries", outDir, c);

                // 4. Presents & Trapped Presents
                // Textures
                writeImage(recolor(presentSideTemplate, rgb), outDir.resolve("textures/block/presents/present_side_" + c + ".png"));
                writeImage(recolor(presentTopTemplate, rgb), outDir.resolve("textures/block/presents/present_top_" + c + ".png"));
                writeImage(recolor(presentBottomTemplate, rgb), outDir.resolve("textures/block/presents/present_bottom_" + c + ".png"));
                writeImage(recolor(presentInsideTemplate, rgb), outDir.resolve("textures/block/presents/present_inside_" + c + ".png"));
                writeImage(recolor(presentTrappedTemplate, rgb), outDir.resolve("textures/block/presents/present_trapped_" + c + ".png"));

                // Blockstates
                writeString(presentBlockstateTemplate.replace("red", c), outDir.resolve("blockstates/present_" + c + ".json"));
                writeString(trappedPresentBlockstateTemplate.replace("red", c), outDir.resolve("blockstates/trapped_present_" + c + ".json"));

                // Block Models
                writeString(presentClosedModel(c), outDir.resolve("models/block/presents/present_closed_" + c + ".json"));
                writeString(presentOpenedModel(c), outDir.resolve("models/block/presents/present_opened_" + c + ".json"));
                writeString(trappedPresentClosedModel(c), outDir.resolve("models/block/presents/trapped_present_closed_" + c + ".json"));
                writeString(trappedPresentOpenedModel(c), outDir.resolve("models/block/presents/trapped_present_opened_" + c + ".json"));

                // Item Models
                writeString(presentItemModel(c), outDir.resolve("models/item/present_" + c + ".json"));
                writeString(trappedPresentItemModel(c), outDir.resolve("models/item/trapped_present_" + c + ".json"));
            }
        }
    }

    private static void generateSuppSquaredAssets(Path outDir, File suppSqJar) throws Exception {
        try (ZipFile zip = new ZipFile(suppSqJar)) {
            // Load templates
            BufferedImage sackFront = readImage(zip, "assets/suppsquared/textures/block/oldsacks/sack_white_front.png");
            BufferedImage sackTop = readImage(zip, "assets/suppsquared/textures/block/oldsacks/sack_white_top.png");
            BufferedImage sackBottom = readImage(zip, "assets/suppsquared/textures/block/oldsacks/sack_white_bottom.png");
            BufferedImage sackClosed = readImage(zip, "assets/suppsquared/textures/block/oldsacks/sack_white_closed.png");
            BufferedImage sackOpen = readImage(zip, "assets/suppsquared/textures/block/oldsacks/sack_white_open.png");
            BufferedImage goldCandleHolderItemTemplate = readImage(zip, "assets/suppsquared/textures/item/candle_holders/white.png");

            String sackBlockstateTemplate = readString(zip, "assets/suppsquared/blockstates/sack_red.json");
            String goldCandleHolderBlockstateTemplate = readString(zip, "assets/suppsquared/blockstates/gold_candle_holder_red.json");

            for (ColorDef col : COLORS) {
                String c = col.name();
                int rgb = col.rgb();

                // 1. Sacks
                // Textures (written to both block/oldsacks and block/ for safety)
                BufferedImage f = recolor(sackFront, rgb);
                BufferedImage t = recolor(sackTop, rgb);
                BufferedImage b = recolor(sackBottom, rgb);
                BufferedImage cl = recolor(sackClosed, rgb);
                BufferedImage op = recolor(sackOpen, rgb);

                writeImage(f, outDir.resolve("textures/block/oldsacks/sack_" + c + "_front.png"));
                writeImage(t, outDir.resolve("textures/block/oldsacks/sack_" + c + "_top.png"));
                writeImage(b, outDir.resolve("textures/block/oldsacks/sack_" + c + "_bottom.png"));
                writeImage(cl, outDir.resolve("textures/block/oldsacks/sack_" + c + "_closed.png"));
                writeImage(op, outDir.resolve("textures/block/oldsacks/sack_" + c + "_open.png"));

                writeImage(f, outDir.resolve("textures/block/sack_" + c + "_front.png"));
                writeImage(t, outDir.resolve("textures/block/sack_" + c + "_top.png"));
                writeImage(b, outDir.resolve("textures/block/sack_" + c + "_bottom.png"));
                writeImage(cl, outDir.resolve("textures/block/sack_" + c + "_closed.png"));
                writeImage(op, outDir.resolve("textures/block/sack_" + c + "_open.png"));

                // Blockstate
                String bsSack = sackBlockstateTemplate.replace("red", c);
                writeString(bsSack, outDir.resolve("blockstates/sack_" + c + ".json"));

                // Block Models
                writeString(sackClosedModel(c), outDir.resolve("models/block/sacks/" + c + "_closed.json"));
                writeString(sackOpenModel(c), outDir.resolve("models/block/sacks/" + c + "_open.json"));

                // Item Model
                writeString(sackItemModel(c), outDir.resolve("models/item/sack_" + c + ".json"));

                // 2. Gold Candle Holders
                // Texture
                writeImage(recolor(goldCandleHolderItemTemplate, rgb), outDir.resolve("textures/item/candle_holders/" + c + ".png"));

                // Blockstate
                String bsGoldCandle = goldCandleHolderBlockstateTemplate.replace("red", c);
                writeString(bsGoldCandle, outDir.resolve("blockstates/gold_candle_holder_" + c + ".json"));

                // Item Model
                writeString(candleHolderItemModel("suppsquared", c), outDir.resolve("models/item/gold_candle_holder_" + c + ".json"));

                // 30 Block Models
                generateCandleHolderBlockModels("suppsquared", outDir, c);
            }
        }
    }

    private static final String[] CANDLE_VARIANTS = new String[]{
            "floor_1", "floor_1_lit", "floor_2", "floor_2_lit", "floor_3", "floor_3_lit", "floor_4", "floor_4_lit",
            "wall_1", "wall_1_lit", "wall_2", "wall_2_lit", "wall_3", "wall_3_lit", "wall_4", "wall_4_lit",
            "ceiling_1", "ceiling_1_lit", "ceiling_1f", "ceiling_1f_lit",
            "ceiling_2", "ceiling_2_lit", "ceiling_2f", "ceiling_2f_lit",
            "ceiling_3", "ceiling_3_lit", "ceiling_3f", "ceiling_3f_lit",
            "ceiling_4", "ceiling_4_lit"
    };

    private static void generateCandleHolderBlockModels(String modId, Path outDir, String color) throws IOException {
        for (String var : CANDLE_VARIANTS) {
            String json = """
                    {
                      "credit": "Made with Blockbench",
                      "parent": "%s:block/candle_holders/%s",
                      "textures": {
                        "1": "%s:block/candle_holder",
                        "particle": "%s:block/candle_holder",
                        "all": "dye_depot:block/%s_candle"
                      }
                    }
                    """.formatted(modId, var, modId, modId, color);
            writeString(json, outDir.resolve("models/block/candle_holders/" + color + "_" + var + ".json"));
        }
    }

    private static String awningModel(String parent, String color) {
        return """
                {
                  "parent": "%s",
                  "textures": {
                    "1": "supplementaries:block/awnings/awning_%s",
                    "up": "supplementaries:block/awnings/awning_%s_side",
                    "particle": "supplementaries:block/awnings/awning_%s"
                  }
                }
                """.formatted(parent, color, color, color);
    }

    private static String awningItemModel(String color) {
        return """
                {
                  "parent": "supplementaries:item/awning",
                  "textures": {
                    "1": "supplementaries:block/awnings/awning_%s",
                    "up": "supplementaries:block/awnings/awning_%s_side",
                    "particle": "supplementaries:block/awnings/awning_%s"
                  }
                }
                """.formatted(color, color, color);
    }

    private static String buntingCeilingBlockstate(String color) {
        return """
                {
                  "variants": {
                    "axis=x": {
                      "model": "supplementaries:block/buntings/%s_ceiling",
                      "y": 90
                    },
                    "axis=z": {
                      "model": "supplementaries:block/buntings/%s_ceiling"
                    }
                  }
                }
                """.formatted(color, color);
    }

    private static String buntingWallBlockstate(String color) {
        return """
                {
                  "variants": {
                    "facing=north": {
                      "model": "supplementaries:block/buntings/%s_wall"
                    },
                    "facing=east": {
                      "model": "supplementaries:block/buntings/%s_wall",
                      "y": 90
                    },
                    "facing=south": {
                      "model": "supplementaries:block/buntings/%s_wall",
                      "y": 180
                    },
                    "facing=west": {
                      "model": "supplementaries:block/buntings/%s_wall",
                      "y": 270
                    }
                  }
                }
                """.formatted(color, color, color, color);
    }

    private static String buntingCeilingModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/buntings/white_ceiling",
                  "textures": {
                    "0": "supplementaries:block/buntings/wall_bunting_%s",
                    "particle": "supplementaries:block/buntings/wall_bunting_%s"
                  }
                }
                """.formatted(color, color);
    }

    private static String buntingWallModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/buntings/white_wall",
                  "textures": {
                    "0": "supplementaries:block/buntings/wall_bunting_%s",
                    "particle": "supplementaries:block/buntings/wall_bunting_%s"
                  }
                }
                """.formatted(color, color);
    }

    private static String buntingItemModel(String color) {
        return """
                {
                  "parent": "item/generated",
                  "textures": {
                    "layer0": "supplementaries:item/buntings/bunting_%s"
                  }
                }
                """.formatted(color);
    }

    private static String sackClosedModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/sack_closed",
                  "textures": {
                    "1": "suppsquared:block/oldsacks/sack_%s_front",
                    "2": "suppsquared:block/oldsacks/sack_%s_top",
                    "3": "suppsquared:block/oldsacks/sack_%s_bottom",
                    "4": "suppsquared:block/oldsacks/sack_%s_closed",
                    "particle": "suppsquared:block/oldsacks/sack_%s_front"
                  }
                }
                """.formatted(color, color, color, color, color);
    }

    private static String sackOpenModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/sack_open",
                  "textures": {
                    "1": "suppsquared:block/oldsacks/sack_%s_front",
                    "2": "suppsquared:block/oldsacks/sack_%s_top",
                    "3": "suppsquared:block/oldsacks/sack_%s_bottom",
                    "4": "suppsquared:block/oldsacks/sack_%s_open",
                    "particle": "suppsquared:block/oldsacks/sack_%s_front"
                  }
                }
                """.formatted(color, color, color, color, color);
    }

    private static String sackItemModel(String color) {
        return """
                {
                  "parent": "suppsquared:block/sacks/%s_closed"
                }
                """.formatted(color);
    }

    private static String candleHolderItemModel(String modId, String color) {
        return """
                {
                  "credit": "Made with Blockbench",
                  "parent": "item/generated",
                  "textures": {
                    "layer0": "%s:item/candle_holders/%s"
                  }
                }
                """.formatted(modId, color);
    }

    private static String presentClosedModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/present_closed_template",
                  "credit": "Made with Blockbench",
                  "textures": {
                    "bottom": "supplementaries:block/presents/present_bottom_%s",
                    "top": "supplementaries:block/presents/present_top_%s",
                    "particle": "supplementaries:block/presents/present_side_%s",
                    "side": "supplementaries:block/presents/present_side_%s"
                  }
                }
                """.formatted(color, color, color, color);
    }

    private static String presentOpenedModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/present_opened_template",
                  "credit": "Made with Blockbench",
                  "textures": {
                    "bottom": "supplementaries:block/presents/present_bottom_%s",
                    "inside": "supplementaries:block/presents/present_inside_%s",
                    "particle": "supplementaries:block/presents/present_side_%s",
                    "side": "supplementaries:block/presents/present_side_%s"
                  }
                }
                """.formatted(color, color, color, color);
    }

    private static String trappedPresentClosedModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/trapped_present_closed_template",
                  "credit": "Made with Blockbench",
                  "textures": {
                    "3": "supplementaries:block/presents/present_trapped_%s",
                    "bottom": "supplementaries:block/presents/present_bottom_%s",
                    "top": "supplementaries:block/presents/present_top_%s",
                    "particle": "supplementaries:block/presents/present_side_%s",
                    "side": "supplementaries:block/presents/present_side_%s"
                  }
                }
                """.formatted(color, color, color, color, color);
    }

    private static String trappedPresentOpenedModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/trapped_present_opened_template",
                  "credit": "Made with Blockbench",
                  "textures": {
                    "3": "supplementaries:block/presents/present_trapped_%s",
                    "bottom": "supplementaries:block/presents/present_bottom_%s",
                    "inside": "supplementaries:block/presents/present_inside_%s",
                    "particle": "supplementaries:block/presents/present_side_%s",
                    "side": "supplementaries:block/presents/present_side_%s"
                  }
                }
                """.formatted(color, color, color, color, color);
    }

    private static String presentItemModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/presents/present_opened_%s",
                  "overrides": [
                    {
                      "predicate": {
                        "supplementaries:packed": 1
                      },
                      "model": "supplementaries:block/presents/present_closed_%s"
                    }
                  ]
                }
                """.formatted(color, color);
    }

    private static String trappedPresentItemModel(String color) {
        return """
                {
                  "parent": "supplementaries:block/presents/trapped_present_opened_%s",
                  "overrides": [
                    {
                      "predicate": {
                        "supplementaries:primed": 1
                      },
                      "model": "supplementaries:block/presents/trapped_present_closed_%s"
                    }
                  ]
                }
                """.formatted(color, color);
    }

    private static BufferedImage recolor(BufferedImage src, int targetRgb) {
        if (src == null) return null;
        int width = src.getWidth();
        int height = src.getHeight();
        BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        int tr = (targetRgb >> 16) & 0xFF;
        int tg = (targetRgb >> 8) & 0xFF;
        int tb = targetRgb & 0xFF;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = src.getRGB(x, y);
                int a = (argb >> 24) & 0xFF;
                if (a == 0) {
                    dest.setRGB(x, y, 0);
                    continue;
                }
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                double intensity = (0.299 * r + 0.587 * g + 0.114 * b) / 255.0;

                int nr = Math.min(255, (int) Math.round(intensity * tr));
                int ng = Math.min(255, (int) Math.round(intensity * tg));
                int nb = Math.min(255, (int) Math.round(intensity * tb));

                int newArgb = (a << 24) | (nr << 16) | (ng << 8) | nb;
                dest.setRGB(x, y, newArgb);
            }
        }
        return dest;
    }

    private static BufferedImage readImage(ZipFile zip, String entryPath) throws IOException {
        ZipEntry entry = zip.getEntry(entryPath);
        if (entry == null) return null;
        try (InputStream is = zip.getInputStream(entry)) {
            return ImageIO.read(is);
        }
    }

    private static String readString(ZipFile zip, String entryPath) throws IOException {
        ZipEntry entry = zip.getEntry(entryPath);
        if (entry == null) return null;
        try (InputStream is = zip.getInputStream(entry)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private static void writeImage(BufferedImage img, Path outPath) throws IOException {
        if (img == null) return;
        Files.createDirectories(outPath.getParent());
        ImageIO.write(img, "PNG", outPath.toFile());
    }

    private static void writeString(String content, Path outPath) throws IOException {
        if (content == null) return;
        Files.createDirectories(outPath.getParent());
        Files.writeString(outPath, content, StandardCharsets.UTF_8);
    }
}
