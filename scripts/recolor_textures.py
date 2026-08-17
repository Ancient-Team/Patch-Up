#!/usr/bin/env python3
"""
Dye Depot Texture Recolor Utility for Patch Up
Usage:
    python scripts/recolor_textures.py <input_template_png> [output_dir] [--prefix]
"""

import sys
import os
from pathlib import Path

# Official Dye Depot Color Palette (RGB)
DYE_DEPOT_COLORS = {
    "maroon":   (104, 31, 16),
    "rose":     (219, 69, 77),
    "coral":    (227, 110, 77),
    "ginger":   (176, 66, 15),
    "tan":      (217, 136, 77),
    "beige":    (228, 194, 129),
    "amber":    (187, 147, 17),
    "olive":    (129, 128, 40),
    "forest":   (70, 151, 35),
    "verdant":  (18, 77, 33),
    "teal":     (40, 100, 88),
    "mint":     (49, 175, 103),
    "aqua":     (92, 232, 203),
    "slate":    (80, 98, 138),
    "navy":     (32, 45, 79),
    "indigo":   (36, 21, 62),
}

def tint_pixel(pixel, target_rgb):
    """Multiplies grayscale/white base pixel brightness with target RGB while preserving alpha."""
    r, g, b, *a = pixel
    alpha = a[0] if a else 255
    if alpha == 0:
        return (0, 0, 0, 0)
    
    # Calculate luminosity / relative brightness of base pixel
    lum = (r * 0.299 + g * 0.587 + b * 0.114) / 255.0

    new_r = min(255, int(target_rgb[0] * lum))
    new_g = min(255, int(target_rgb[1] * lum))
    new_b = min(255, int(target_rgb[2] * lum))
    return (new_r, new_g, new_b, alpha)

def recolor_image(input_path: str, output_dir: str = None, prefix: bool = True):
    try:
        from PIL import Image
    except ImportError:
        print("[ERROR] Pillow is required. Install it using: pip install pillow")
        return

    input_file = Path(input_path)
    if not input_file.exists():
        print(f"[ERROR] Input file not found: {input_file}")
        return

    if output_dir is None:
        out_dir = input_file.parent
    else:
        out_dir = Path(output_dir)
        out_dir.mkdir(parents=True, exist_ok=True)

    base_img = Image.open(input_file).convert("RGBA")
    width, height = base_img.size

    base_name = input_file.stem
    # If base name starts with white_ or template_, strip it
    for prefix_to_strip in ["white_", "template_", "base_"]:
        if base_name.startswith(prefix_to_strip):
            base_name = base_name[len(prefix_to_strip):]

    print(f"Generating 16 recolored variants for: {base_name} ({width}x{height})")

    for color_name, rgb in DYE_DEPOT_COLORS.items():
        new_img = Image.new("RGBA", (width, height))
        for x in range(width):
            for y in range(height):
                pixel = base_img.getpixel((x, y))
                new_img.putpixel((x, y), tint_pixel(pixel, rgb))

        filename = f"{color_name}_{base_name}.png" if prefix else f"{base_name}_{color_name}.png"
        out_path = out_dir / filename
        new_img.save(out_path)
        print(f"  -> Created: {out_path.name}")

    print("[SUCCESS] All 16 textures generated successfully!")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python scripts/recolor_textures.py <input_template.png> [output_dir]")
        sys.exit(1)

    in_file = sys.argv[1]
    out_directory = sys.argv[2] if len(sys.argv) > 2 else None
    recolor_image(in_file, out_directory)
