package net.atoba_azul.cc_compat.datagen.asset_gen;

import net.mehvahdjukaar.moonlight.api.resources.textures.Palette;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;

public class ModPallete {
    // Here Palette class use is shown
    public static Palette modifyPallete(TextureImage image) {
        //keeping this here in case we do need to modify palletes, but rn I'm keeping this empty.
        Palette originalPalette = Palette.fromImage(image);

        return originalPalette;
    }

}
