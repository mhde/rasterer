rasterer
========

Image rasterer, written in Java. The project is under development.

Usage:

```java
// Create Raster from BufferedImage with a 80-pixel-per-line raster
BufferedImage source ... ;
int resolution = 80;

ImageConverter converter = new ImageConverter();
RasterImage rasterImage = converter.imageToRaster(source, resolution);

// Convert RasterImage to BufferedImage, background color is white, rasterpixels in image will be rendered with 40px width
int pixelSize = 40;
Renderer<BufferedImage> bufferedImageRenderer = new OvalBufferedImageRenderer();
BufferedImage result = bufferedImageRenderer.render(rasterImage, Color.WHITE, pixelSize);
```
