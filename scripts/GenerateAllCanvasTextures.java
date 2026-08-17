import java.io.File;
import java.util.Map;
import java.util.zip.ZipFile;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GenerateAllCanvasTextures {

    // 4-shade authentic Dye Depot canvas palettes: [shade0, shade1, shade2, shade3]
    // shade0 corresponds to White(207,212,213)
    // shade1 corresponds to White(223,226,227)
    // shade2 corresponds to White(243,244,245)
    // shade3 corresponds to White(254,254,254)
    public static final Map<String, int[][]> DYE_DEPOT_PALETTES = Map.ofEntries(
            Map.entry("maroon", new int[][]{ {93, 24, 15}, {104, 30, 15}, {110, 34, 16}, {118, 36, 18} }),
            Map.entry("rose", new int[][]{ {208, 54, 66}, {218, 60, 71}, {224, 76, 82}, {224, 88, 92} }),
            Map.entry("coral", new int[][]{ {213, 88, 63}, {230, 114, 79}, {237, 128, 90}, {244, 140, 100} }),
            Map.entry("ginger", new int[][]{ {149, 55, 11}, {164, 60, 12}, {183, 70, 16}, {208, 84, 24} }),
            Map.entry("tan", new int[][]{ {193, 118, 63}, {222, 139, 81}, {231, 146, 85}, {240, 153, 91} }),
            Map.entry("beige", new int[][]{ {222, 179, 111}, {230, 198, 133}, {234, 207, 146}, {237, 214, 157} }),
            Map.entry("amber", new int[][]{ {167, 123, 20}, {180, 138, 18}, {192, 151, 18}, {211, 175, 26} }),
            Map.entry("olive", new int[][]{ {114, 109, 37}, {119, 116, 38}, {124, 123, 39}, {135, 137, 42} }),
            Map.entry("forest", new int[][]{ {66, 127, 33}, {71, 151, 34}, {73, 158, 36}, {76, 180, 39} }),
            Map.entry("verdant", new int[][]{ {17, 64, 26}, {17, 73, 30}, {19, 80, 35}, {20, 92, 43} }),
            Map.entry("teal", new int[][]{ {36, 86, 80}, {40, 101, 87}, {42, 105, 91}, {47, 117, 99} }),
            Map.entry("mint", new int[][]{ {40, 141, 93}, {49, 155, 98}, {50, 177, 103}, {52, 198, 109} }),
            Map.entry("aqua", new int[][]{ {78, 206, 193}, {91, 215, 194}, {93, 233, 203}, {97, 255, 216} }),
            Map.entry("slate", new int[][]{ {68, 84, 121}, {79, 98, 138}, {88, 109, 150}, {93, 113, 156} }),
            Map.entry("navy", new int[][]{ {25, 36, 68}, {26, 38, 72}, {31, 44, 78}, {37, 51, 85} }),
            Map.entry("indigo", new int[][]{ {28, 17, 55}, {32, 20, 55}, {41, 24, 66}, {44, 27, 73} })
    );

    public static void main(String[] args) throws Exception {
        File gradleCaches = new File(System.getProperty("user.home") + "/.gradle/caches");
        File fdJar = ComparePalettes.findJar(gradleCaches, "farmers-delight-refabricated");
        if (fdJar == null) {
            System.err.println("Could not find farmers-delight-refabricated JAR!");
            return;
        }

        try (ZipFile zip = new ZipFile(fdJar)) {
            BufferedImage templateSign = ImageIO.read(zip.getInputStream(zip.getEntry("assets/farmersdelight/textures/entity/signs/canvas_white.png")));
            BufferedImage templateHangingSign = ImageIO.read(zip.getInputStream(zip.getEntry("assets/farmersdelight/textures/entity/signs/hanging/canvas_white.png")));
            BufferedImage templateGuiHanging = ImageIO.read(zip.getInputStream(zip.getEntry("assets/farmersdelight/textures/gui/hanging_signs/canvas_white.png")));
            BufferedImage templateItemSign = ImageIO.read(zip.getInputStream(zip.getEntry("assets/farmersdelight/textures/item/white_canvas_sign.png")));
            BufferedImage templateItemHangingSign = ImageIO.read(zip.getInputStream(zip.getEntry("assets/farmersdelight/textures/item/white_hanging_canvas_sign.png")));

            File dirEntitySigns = new File("src/main/resources/assets/farmersdelight/textures/entity/signs");
            File dirEntityHangingSigns = new File("src/main/resources/assets/farmersdelight/textures/entity/signs/hanging");
            File dirGuiHangingSigns = new File("src/main/resources/assets/farmersdelight/textures/gui/hanging_signs");
            File dirItemSigns = new File("src/main/resources/assets/patchup/textures/item");

            dirEntitySigns.mkdirs();
            dirEntityHangingSigns.mkdirs();
            dirGuiHangingSigns.mkdirs();
            dirItemSigns.mkdirs();

            for (Map.Entry<String, int[][]> entry : DYE_DEPOT_PALETTES.entrySet()) {
                String colorName = entry.getKey();
                int[][] palette = entry.getValue();

                // 1. Standing entity sign texture
                BufferedImage resSign = recolorTemplate(templateSign, palette);
                ImageIO.write(resSign, "png", new File(dirEntitySigns, "canvas_" + colorName + ".png"));

                // 2. Hanging entity sign texture
                BufferedImage resHangingSign = recolorTemplate(templateHangingSign, palette);
                ImageIO.write(resHangingSign, "png", new File(dirEntityHangingSigns, "canvas_" + colorName + ".png"));

                // 3. Hanging GUI sign texture
                BufferedImage resGuiHanging = recolorTemplate(templateGuiHanging, palette);
                ImageIO.write(resGuiHanging, "png", new File(dirGuiHangingSigns, "canvas_" + colorName + ".png"));

                // 4. Standing sign item texture
                BufferedImage resItemSign = recolorTemplate(templateItemSign, palette);
                ImageIO.write(resItemSign, "png", new File(dirItemSigns, colorName + "_canvas_sign.png"));

                // 5. Hanging sign item texture
                BufferedImage resItemHangingSign = recolorTemplate(templateItemHangingSign, palette);
                ImageIO.write(resItemHangingSign, "png", new File(dirItemSigns, colorName + "_hanging_canvas_sign.png"));

                System.out.println("Generated all 5 textures for color: " + colorName);
            }
        }

        System.out.println("\nSUCCESS: All canvas sign textures (blocks, hanging, GUI, and items) generated with 100% harmonized palettes!");
    }

    private static BufferedImage recolorTemplate(BufferedImage template, int[][] palette) {
        int w = template.getWidth();
        int h = template.getHeight();
        BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = template.getRGB(x, y);
                int a = (pixel >> 24) & 0xFF;
                if (a == 0) {
                    result.setRGB(x, y, 0);
                    continue;
                }

                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;

                // Match the 4 canvas shades:
                // shade0: (207, 212, 213)
                // shade1: (223, 226, 227)
                // shade2: (243, 244, 245)
                // shade3: (254, 254, 254)
                if (r == 207 && g == 212 && b == 213) {
                    int[] rgb = palette[0];
                    result.setRGB(x, y, (a << 24) | (rgb[0] << 16) | (rgb[1] << 8) | rgb[2]);
                } else if (r == 223 && g == 226 && b == 227) {
                    int[] rgb = palette[1];
                    result.setRGB(x, y, (a << 24) | (rgb[0] << 16) | (rgb[1] << 8) | rgb[2]);
                } else if (r == 243 && g == 244 && b == 245) {
                    int[] rgb = palette[2];
                    result.setRGB(x, y, (a << 24) | (rgb[0] << 16) | (rgb[1] << 8) | rgb[2]);
                } else if (r == 254 && g == 254 && b == 254) {
                    int[] rgb = palette[3];
                    result.setRGB(x, y, (a << 24) | (rgb[0] << 16) | (rgb[1] << 8) | rgb[2]);
                } else {
                    // Wood frame, log, chain, hanger, etc. -> preserve unchanged!
                    result.setRGB(x, y, pixel);
                }
            }
        }
        return result;
    }
}
