package de.timzoeller.rasterer;

import de.timzoeller.rasterer.converter.ImageConverter;
import de.timzoeller.rasterer.model.RasterImage;
import java.awt.image.BufferedImage;
import de.timzoeller.rasterer.renderer.OvalRasterRenderer;

public class Rasterer {

    public BufferedImage convertImageToRaster(BufferedImage source, int horizontalResolution, int pixelSize) {
        RasterImage raster = buildRasterFromImage(source, horizontalResolution);
        return renderRasterToImage(raster, pixelSize);        
    }

    private RasterImage buildRasterFromImage(BufferedImage source, int horizontalResolution) {
        ImageConverter converter = new ImageConverter();
        return converter.imageToRaster(source, horizontalResolution);
    }

    private BufferedImage renderRasterToImage(RasterImage raster, int pixelSize) {
        OvalRasterRenderer renderer = new OvalRasterRenderer();
        return renderer.toBufferedImage(raster, pixelSize);
    }

}
