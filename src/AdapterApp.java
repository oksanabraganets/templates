public class AdapterApp {
    public static void main(String[] args){
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){ System.out.println("Рисуем линию");}
    void drawRasterSquare(){System.out.println("Рисуем квадрат");}
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics graphics = new RasterGraphics();

    public void drawLine() {
        graphics.drawRasterLine();
    }

    public void drawSquare() {
       graphics.drawRasterSquare();
    }
}