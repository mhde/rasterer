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

    protected void drawPixel(BufferedImage image, Color color, int xPos, int yPos, int pixelSize, double pixelWeight) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);

        int drawSize = new Double(pixelWeight * pixelSize).intValue();
        Double offset = new Double(pixelSize - drawSize) / 2;

        drawRectangleWithBorder(graphics, xPos, offset.intValue(), yPos, drawSize);
    }

    private void drawRectangleWithBorder(Graphics2D graphics, int xPos, int offset, int yPos, int drawSize) {
        int BORDER = 1;
        
        graphics.fillRect(xPos + offset - BORDER, yPos + offset - BORDER, drawSize - 2 * BORDER, drawSize - 2 * BORDER);
    }

}
