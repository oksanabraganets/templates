import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args){
        SquareShape square1 = new SquareShape();
        SquareShape square2 = new SquareShape();
        CircleShape circle = new CircleShape();

        SquareShape square3 = new SquareShape();
        TriangleShape triangle1 = new TriangleShape();
        TriangleShape triangle2 = new TriangleShape();

        Composite composite1 = new Composite();
        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(circle);

        Composite composite2 = new Composite();
        composite2.addComponent(square3);
        composite2.addComponent(triangle1);
        composite2.addComponent(triangle2);

        Composite comp = new Composite();
        comp.addComponent(composite1);
        comp.addComponent(composite2);

        comp.draw();

    }
}

interface Shape{
    void draw();
}

class SquareShape implements Shape {
    public void draw() {
        System.out.println("Привет, я Квадрат.");
    }
}
class CircleShape implements Shape{
    public void draw() {
        System.out.println("Привет, я Круг.");
    }
}
class TriangleShape implements Shape{
    public void draw() {
        System.out.println("Привет, я Треугольник.");
    }
}

class Composite implements Shape{
    List<Shape> components = new ArrayList<>();

    void addComponent(Shape component){
        components.add(component);
    }

    void removeComponent(Shape component){
        components.remove(component);
    }
    public void draw() {
        for (Shape c : components){
            c.draw();
        }
    }
}

