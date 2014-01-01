/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.model;

import java.awt.image.BufferedImage;

/**
 *
 * @author tim
 */
public class Rasterpixel {

    private int color;
    private int weight;
    
    public Rasterpixel(BufferedImage image) {
        this.color = calculateAverageColor(image);
        this.weight = calculateWeight(image);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }  

    private int calculateAverageColor(BufferedImage image) {
        return image.getRGB(image.getWidth() / 2, image.getHeight() / 2);
    }

    private int calculateWeight(BufferedImage image) {
        return 5;
    }
    
}
