public class Decorator {
    public static void main(String[] args){
        //PrinterInterface p = new Printer("Привет");
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Привет"))));
        printer.print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }
}

abstract class AbstractDecorator implements PrinterInterface{
    PrinterInterface component;

    public AbstractDecorator(PrinterInterface component) {
        this.component = component;
    }
    public void print(){
        component.print();
    }
}

class QuotesDecorator extends AbstractDecorator{

    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

}

class LeftBracketDecorator extends AbstractDecorator{

    public void print() {
        System.out.print("[");
        super.print();
    }

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }
}

class RightBracketDecorator extends AbstractDecorator{
    
    public void print() {
        super.print();
        System.out.print("]");
    }

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }
}