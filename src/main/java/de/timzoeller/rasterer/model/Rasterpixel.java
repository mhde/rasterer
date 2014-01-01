/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.model;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author tim
 */
public class Rasterpixel {

    private int color;
    private double weight;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int calculateAverageColor(BufferedImage image) {
        return image.getRGB(image.getWidth() / 2, image.getHeight() / 2);
    }

    private double calculateWeight(BufferedImage image) {
        double luminanceSum = 0;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color currentColor = new Color(image.getRGB(x, y));
                luminanceSum += calculateLuminance(currentColor);
            }
        }
        return 1 - ((luminanceSum / calculatePixelCount(image)) / (255*2));
    }

    private int calculatePixelCount(BufferedImage image) {
        return image.getHeight() * image.getWidth();
    }

    private double calculateLuminance(Color currentColor) {
        return (0.2126 * currentColor.getRed()) + (0.7152 * currentColor.getGreen()) + (0.0722 * currentColor.getBlue());
    }
}
