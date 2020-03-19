import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args){
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.setMeasurements(18, 746);
    }

}

interface Observer{
    void handleEvent(int temp, int pressure);
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer o : observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observer{

    public void handleEvent(int temp, int pressure) {
        System.out.println("Weather has changed. Temperature is "+ temp
        +", pressure is "+pressure);
    }
}