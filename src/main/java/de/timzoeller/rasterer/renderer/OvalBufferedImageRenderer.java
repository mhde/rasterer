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
public class OvalBufferedImageRenderer extends BufferedImageRenderer {

    protected void drawPixel(BufferedImage image, Color color, int xPos, int yPos, int pixelSize, double pixelWeight) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);
        
        int drawSize = new Double(pixelWeight * pixelSize).intValue();
        Double offset = new Double(pixelSize - drawSize) / 2;       
        
        graphics.fillOval(xPos + offset.intValue(), yPos + offset.intValue(), drawSize, drawSize);
    }

}
