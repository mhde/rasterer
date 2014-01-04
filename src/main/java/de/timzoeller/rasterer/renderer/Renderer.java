/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.timzoeller.rasterer.renderer;

import de.timzoeller.rasterer.model.RasterImage;
import java.awt.Color;

/**
 *
 * @author tim
 */
public interface Renderer<T> {

    public T render(RasterImage raster, Color backgroundColor, int pixelSize);
}
