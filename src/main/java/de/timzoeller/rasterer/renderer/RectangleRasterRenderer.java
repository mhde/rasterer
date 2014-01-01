/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tim
 */
public class RectangleRasterRenderer extends RasterRenderer {

    protected void paintImageBackground(BufferedImage image) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    protected void drawPixel(BufferedImage image, Color color, int xPos, int yPos, int pixelSize) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);
        drawRectangleWithBorder(graphics, xPos, yPos, pixelSize);
    }

    private void drawRectangleWithBorder(Graphics2D graphics, int xPos, int yPos, int pixelSize) {
        graphics.fillRect(xPos + 1, yPos + 1, pixelSize - 2, pixelSize - 2);
    }

}