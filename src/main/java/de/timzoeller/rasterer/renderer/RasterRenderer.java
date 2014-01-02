/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.renderer;

import de.timzoeller.rasterer.model.Rasterpixel;
import de.timzoeller.rasterer.model.RasterImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tim
 */
public abstract class RasterRenderer {

    protected abstract void drawPixel(BufferedImage image, Color color, int xPos, int yPos, int pixelSize, double pixelWeight);

    public BufferedImage toBufferedImage(RasterImage raster, Color backgroundColor, int pixelSize) {
        int imageWidth = raster.getWidth() * pixelSize;
        int imageHeight = raster.getHeight() * pixelSize;

        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        paintImageBackground(image, backgroundColor);

        for (int i = 0; i < raster.calculatePixelCount(); i++) {
            int xPos = (i % raster.getWidth()) * pixelSize;
            int yPos = (i / raster.getWidth()) * pixelSize;
            if (null != getPixelForIndex(raster, i)) {
                drawRasterPixelToImage(image, getPixelForIndex(raster, i), xPos, yPos, pixelSize);
            }
        }
        return image;
    }

    private void paintImageBackground(BufferedImage image, Color color) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    private Rasterpixel getPixelForIndex(RasterImage raster, int i) {
        return raster.getPixels()[i];
    }

    private void drawRasterPixelToImage(BufferedImage image, Rasterpixel pixel, int xPos, int yPos, int pixelSize) {
        Color pixelColor = new Color(pixel.getColor());
        drawPixel(image, pixelColor, xPos, yPos, pixelSize, pixel.getWeight());
    }

}
