public class AbstractFactoryApp {
    public static void main(String[] args){
        DeviceFactory factory = getDeviceFactoryByName("EN");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        TouchPad touchPad = factory.getTouchPad();

        mouse.click();
        keyboard.print();
        keyboard.println();
        touchPad.track(3, 4);
    }

    public static DeviceFactory getDeviceFactoryByName(String country){
        if (country.equals("RU"))
            return new RUDeviceFactory();
        else if (country.equals("EN"))
            return new ENDeviceFactory();
        throw new RuntimeException("This language is not supported: " + country);
    }
}

interface Mouse{
    void click();
    void doubleClick();
}

interface Keyboard{
    void print();
    void println();
}

interface TouchPad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}

class RUMouse implements Mouse{
    public void click(){ System.out.println("Щелчек мышью"); }
    public void doubleClick(){ System.out.println("Двойной щелчек мышью"); }
}

class RUKeyboard implements Keyboard{
    public void print(){ System.out.print("Печатать"); }
    public void println(){ System.out.println("Печатать строку"); }
}

class RUTouchPad implements TouchPad{
    public void track(int deltaX, int deltaY){
        int distance = (int)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        System.out.println("Сдвиг на " + distance + " пикселей");
    }
}

class ENMouse implements Mouse{
    public void click(){ System.out.println("Mouse click"); }
    public void doubleClick(){ System.out.println("Mouse double click"); }
}

class ENKeyboard implements Keyboard{
    public void print(){ System.out.print("Print"); }
    public void println(){ System.out.println("Print line"); }
}

class ENTouchPad implements TouchPad{
    public void track(int deltaX, int deltaY){
        int distance = (int)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        System.out.println("Track for " + distance + " pixels");
    }
}

class RUDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new RUMouse();
    }

    public Keyboard getKeyboard() {
        return new RUKeyboard();
    }

    public TouchPad getTouchPad() {
        return new RUTouchPad();
    }
}

class ENDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new ENMouse();
    }

    public Keyboard getKeyboard() {
        return new ENKeyboard();
    }

    public TouchPad getTouchPad() {
        return new ENTouchPad();
    }
}