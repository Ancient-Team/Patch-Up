import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

public class GenerateGuiTextures {

    // 4-shade authentic Dye Depot canvas palettes: [shade0, shade1, shade2, shade3]
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
        GenerateAllCanvasTextures.main(args);
    }
}
