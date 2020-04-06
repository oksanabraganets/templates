
public class Delegate {
    public static void main(String[] args){
        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();
        painter.setGraphics(new Square());
        painter.draw();

    }
}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("drawing Triangle");
    }
}

class Square implements Graphics{
    public void draw() { System.out.println("drawing Square");}
}

class Circle implements Graphics{
    public void draw() { System.out.println("drawing Circle");}
}

class Painter {
    Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        graphics.draw();
    }
}