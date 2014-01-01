/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.converter;

import de.timzoeller.rasterer.model.Rasterpixel;
import de.timzoeller.rasterer.model.RasterImage;
import java.awt.image.BufferedImage;

/**
 *
 * @author tim
 */
public class ImageConverter {

    public RasterImage imageToRaster(BufferedImage image, int width) {
        int pixelSizeInImage = image.getWidth() / width;
        int height = image.getHeight() / pixelSizeInImage;
        
        RasterImage raster = new RasterImage(height, width);
        
        int pixelIndex = 0;
        for (int i = 0; i < height; i++) {            
            for(int j = 0; j < width; j++) {
                int currentX = j * pixelSizeInImage;
                int currentY = i * pixelSizeInImage;
                raster.getPixels()[pixelIndex++] = new Rasterpixel(image.getSubimage(currentX, currentY, pixelSizeInImage, pixelSizeInImage)); 
            }            
        }     

        return raster;
    }

}
