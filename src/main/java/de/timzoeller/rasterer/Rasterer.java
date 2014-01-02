package de.timzoeller.rasterer;

import de.timzoeller.rasterer.converter.ImageConverter;
import de.timzoeller.rasterer.model.RasterImage;
import java.awt.image.BufferedImage;
import de.timzoeller.rasterer.renderer.RasterRenderer;
import java.awt.Color;

public class Rasterer {

    public BufferedImage convertImageToRaster(BufferedImage source, int horizontalResolution, int pixelSize, RasterRenderer renderer, Color rasterBackgroundColor) {
        RasterImage raster = buildRasterFromImage(source, horizontalResolution);
        return renderRasterToImage(raster, pixelSize, renderer, rasterBackgroundColor);        
    }

    private RasterImage buildRasterFromImage(BufferedImage source, int horizontalResolution) {
        ImageConverter converter = new ImageConverter();
        return converter.imageToRaster(source, horizontalResolution);
    }

    private BufferedImage renderRasterToImage(RasterImage raster, int pixelSize, RasterRenderer renderer, Color rasterBackgroundColor) {
        return renderer.toBufferedImage(raster, rasterBackgroundColor, pixelSize);
    }

}
