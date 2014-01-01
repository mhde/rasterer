/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.model;

/**
 *
 * @author tim
 */
public class RasterImage {

    private int width;
    private int height;
    private Rasterpixel[] pixels;

    public RasterImage(int height, int width) {
        this.height = height;
        this.width = width;
        pixels = new Rasterpixel[width * height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rasterpixel[] getPixels() {
        return pixels;
    }

    public void setPixels(Rasterpixel[] pixels) {
        this.pixels = pixels;
    }

    public int calculatePixelCount() {
        return width * height;
    }

}
