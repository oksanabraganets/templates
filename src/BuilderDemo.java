public class BuilderDemo {

    public static void main(String[] args){
        CarBuilder builder = new CarBuilder();
        Car car = builder
                .mark("Matiz")
                .transmission(Transmission.MANUAL)
                .maxSpeed(200)
                .build();
        System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}
class Car{
    private String mark;
    private Transmission transmission;
    private int maxSpeed;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder{
    private String m = "Default";
    private Transmission t = Transmission.MANUAL;
    private int s = 120;

    CarBuilder mark(String m){
        this.m = m;
        return this;
    }

    CarBuilder transmission(Transmission t){
        this.t = t;
        return this;
    }

    CarBuilder maxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMark(m);
        car.setMaxSpeed(s);
        car.setTransmission(t);
        return car;
    }

}
